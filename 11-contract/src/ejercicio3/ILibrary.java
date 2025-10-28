package ejercicio3;
/**
 * INVARIANTE:
 * Toda implementación debe garantizar la integridad del conjunto de libros.
 */
public interface ILibrary {
    void addBook(String isbn, Book book);
    Book borrowBook(String isbn);
    void returnBook(Book book);
    boolean isBookAvailable(String isbn);
}
