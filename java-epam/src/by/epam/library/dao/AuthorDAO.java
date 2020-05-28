package by.epam.library.dao;

import by.epam.library.entity.Author;

import java.io.*;
import java.util.ArrayList;

public class AuthorDAO {
    private final String path = "data/author.dat";
    private ArrayList<Author> cache;

    public void load() {
        try {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
                this.cache = (ArrayList<Author>) inputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void create(Author item) {
        this.cache.add(item);
    }

    public void save() throws IOException {
        try {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
                outputStream.writeObject(cache);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Author> getAll() {
        return this.cache;
    }
}
