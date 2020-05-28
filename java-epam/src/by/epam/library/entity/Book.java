package by.epam.library.entity;

import by.epam.library.exception.BookException;
import by.epam.library.validator.BookValidator;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private List<Author> authors;
    private int numberOfPages;

    public Book() {}

    public Book(String title, List<Author> authors, int numberOfPages) {
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception{
        if (BookValidator.isTitleValid(title)) {
            this.title = title;
        }
        else {
            throw new BookException("There isn't book's title");
        }
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) throws Exception{
        if (BookValidator.isAuthorsValid(authors)) {
            this.authors = authors;
        }
        else {
            throw new BookException("List of authors is empty");
        }
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) throws Exception{
        if (BookValidator.isNumberOfPagesValid(numberOfPages)) {
            this.numberOfPages = numberOfPages;
        }
        else {
            throw new BookException("Number of pages isn't valid");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", authors=").append(authors);
        sb.append(", numberOfPages=").append(numberOfPages);
        sb.append('}');
        return sb.toString();
    }
}
