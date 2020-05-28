package by.epam.library.dao;

import by.epam.library.entity.Book;

import java.io.*;
import java.util.ArrayList;

public class BookDAO {
    private final String path = "data/book.dat";
    private ArrayList<Book> cache;

    public void load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            this.cache = (ArrayList<Book>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void create(Book item) {
        this.cache.add(item);
    }

    public void save() throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(cache);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getAll() {
        return this.cache;
    }
}
