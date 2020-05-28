package by.epam.library.validator;

public class AuthorValidator {
    public static boolean isAgeValid(short age) {
        return age > 0;
    }

    public static boolean isNameValid(String fullName) {
        final String regex = "[A-Z][a-z]*\\s[A-Z][a-z]*";
        return fullName.matches(regex);
    }

}
