package by.epam.library.services;

import by.epam.library.entity.Author;
import by.epam.library.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BookService {
    private final Logger logger = LogManager.getLogger();

    public boolean containBigBook(Stream<Book> books) {
        return books.anyMatch(book -> book.getNumberOfPages() > 200);
    }

    public Optional<Book> findMaxBook(Stream<Book> books) {
        return books.max(Comparator.comparingInt(Book::getNumberOfPages));
    }

    public Optional<Book> findMinBook(Stream<Book> books) {
        return books.min(Comparator.comparingInt(Book::getNumberOfPages));
    }

    public Stream<Book> filterSingleAuthorBook(Stream<Book> books) {
        logger.info("Find single author books");

        return books.filter(book -> book.getAuthors().size() == 1)
                    .peek(book -> System.out.println("[peek] Book with a single author: " + book));
    }

    public Stream<Book> sortBooksByPages(Stream<Book> books) {
        return books.sorted(Comparator.comparingInt(Book::getNumberOfPages));
    }

    public Stream<Book> sortBooksByTitles(Stream<Book> books) {
        return books.sorted(Comparator.comparing(Book::getTitle));
    }

    public List<Author> getAuthorList(Stream<Book> books) {
        List<Author> authors = new ArrayList<>();
        books.forEach(book -> authors.addAll(book.getAuthors()));
        return authors;
    }


    public List<Author> getAuthorListWithoutDuplicates (Stream<Book> books) {
        List<Author> authors = new ArrayList<>();

        Stream<Author> authorStream = getAuthorList(books).stream();
        authorStream.distinct().forEach(authors::add);
        return authors;
    }
 }