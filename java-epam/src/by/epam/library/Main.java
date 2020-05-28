package by.epam.library;

import by.epam.library.entity.Author;
import by.epam.library.entity.Book;
import by.epam.library.services.BookService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Author[] authors = new Author[3];
        Book[] books = new Book[3];

        authors[0] = new Author("J.K. Rowling", (short) 54);
        authors[1] = new Author("Stephen King", (short) 72);
        authors[2] = new Author("Peter Straub", (short) 77);

        ArrayList<Author> bookAuthors1 = new ArrayList<Author>();
        ArrayList<Book> authorBooks1 = new ArrayList<Book>();

        bookAuthors1.add(authors[0]);

        books[0] = new Book("Harry Potter and the Philosopher's Stone", bookAuthors1, 223);
        books[1] = new Book("Harry Potter and the Chamber of Secrets", bookAuthors1, 251);

        authorBooks1.add(books[0]);
        authorBooks1.add(books[1]);

        authors[0].setBooks(authorBooks1);

        ArrayList<Author> bookAuthors2 = new ArrayList<Author>();
        ArrayList<Book> authorBooks2 = new ArrayList<Book>();

        bookAuthors2.add(authors[1]);
        bookAuthors2.add(authors[2]);

        books[2] = new Book("The Talisman", bookAuthors2, 921);

        authorBooks2.add(books[2]);

        authors[1].setBooks(authorBooks2);
        authors[2].setBooks(authorBooks2);

        BookService bookService = new BookService();

        Optional<Book> maxBook = bookService.findMaxBook(Arrays.stream(books));

        if (maxBook.isPresent()) {
            System.out.println(maxBook.get());
        }

        maxBook = bookService.findMaxBook(Stream.empty());

        try {
            maxBook.orElseThrow(() -> new Exception("Can't find a book with max number of pages in an empty stream."));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        List<Book> singleAuthorBooks = bookService.filterSingleAuthorBook(Arrays.stream(books)).collect(Collectors.toList());

        System.out.println("Parallel stream example");

        singleAuthorBooks = bookService.filterSingleAuthorBook(Arrays.stream(books).parallel()).collect(Collectors.toList());
    }
}
