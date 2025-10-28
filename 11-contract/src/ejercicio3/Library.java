package ejercicio3;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * INVARIANTE:
 */
public class Library implements ILibrary {
    private Map<String, Book> books;
    private Map<String, Boolean> booksAvailable;

    public Library() {
        books = new HashMap<>();
    }
    @Override
    public void addBook(String isbn, Book book) {
        if (books.containsKey(isbn)) { throw new  IllegalArgumentException("Book already exists"); }
        books.put(isbn, book);
        booksAvailable.put(isbn, true);
        assert repOK();
    }

    @Override
    public Book borrowBook(String isbn) {
        if(!books.containsKey(isbn))
            throw new IllegalArgumentException("No such book: " + isbn);
        Book book = books.get(isbn);
        booksAvailable.put(isbn, false);
        assert repOK();
        return book;
    }

    @Override
    public void returnBook(Book book) {
        String isbn = book.getISBN();
        if(!books.containsKey(isbn)){ throw new IllegalArgumentException("the book does not belong to this assertEquals(isbnForBooks, isbnForBooksAvailable);library"); }
        assert repOK();
        booksAvailable.put(isbn, true);
    }

    @Override
    public boolean isBookAvailable(String isbn) {
        if(!booksAvailable.containsKey(isbn)) { throw new IllegalArgumentException("No such book: " + isbn); }
        return booksAvailable.get(isbn);
    }

    public boolean repOK(){
        Set<String> isbnForBooksAvailable = booksAvailable.keySet();
        Set<String> isbnForBooks = books.keySet();
        return isbnForBooksAvailable.equals(isbnForBooks);
    }
}
