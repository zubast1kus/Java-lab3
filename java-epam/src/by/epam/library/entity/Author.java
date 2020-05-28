package by.epam.library.entity;

import by.epam.library.exception.AuthorException;
import by.epam.library.validator.AuthorValidator;

import java.io.Serializable;
import java.util.List;

public class Author implements Serializable {
    private short age;
    private String fullName;
    private List<Book> books;

    public Author(){}

    public Author(String fullName) {
        this.fullName = fullName;
    }

    public Author(String fullName, short age) {
        this.age = age;
        this.fullName = fullName;
    }

    public Author(String fullName, short age, List<Book> books) {
        this.age = age;
        this.books = books;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws Exception {
        if (AuthorValidator.isNameValid(fullName)) {
            this.fullName = fullName;
        }
        else {
            throw new AuthorException("Full name isn't valid");
        }
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) throws Exception {
        if (AuthorValidator.isAgeValid(age)) {
            this.age = age;
        }
        else {
            throw new AuthorException("Author's age isn't valid");
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("age=").append(age);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
