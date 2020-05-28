package by.epam.library.validator;

import by.epam.library.entity.Author;

import java.util.List;

public class BookValidator {
    public static boolean isTitleValid(String title) {
        return !title.isEmpty();
    }

    public static boolean isNumberOfPagesValid(int number) {
        return number > 0;
    }

    public static boolean isAuthorsValid(List<Author> authors) {
        return !authors.isEmpty();
    }
}
