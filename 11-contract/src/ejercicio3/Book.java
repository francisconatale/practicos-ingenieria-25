package ejercicio3;

/**
 * INVARIANTE:
 */
public class Book {
    String ISBN;
    String title;
    String author;
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}
