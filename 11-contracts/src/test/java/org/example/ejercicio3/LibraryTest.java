package org.example.ejercicio3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("123", "Clean Code", "Robert C. Martin");
        book2 = new Book("456", "Design Patterns", "GoF");
    }

    @Test
    void testAddBookYDisponibilidadInicial() {
        library.addBook("123", book1);
        assertTrue(library.isBookAvailable("123"));
    }

    @Test
    void testAddBookDuplicadoLanzaExcepcion() {
        library.addBook("123", book1);
        assertThrows(IllegalArgumentException.class, () -> library.addBook("123", book1));
    }

    @Test
    void testBorrowBookCambiaDisponibilidad() {
        library.addBook("123", book1);
        Book borrowed = library.borrowBook("123");
        assertEquals(book1, borrowed);
        assertFalse(library.isBookAvailable("123"));
    }

    @Test
    void testBorrowBookInexistenteLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> library.borrowBook("999"));
    }

    @Test
    void testReturnBookRestauraDisponibilidad() {
        library.addBook("123", book1);
        library.borrowBook("123");
        library.returnBook(book1);
        assertTrue(library.isBookAvailable("123"));
    }

    @Test
    void testReturnBookQueNoPerteneceLanzaExcepcion() {
        library.addBook("123", book1);
        Book externo = new Book("999", "Otro libro", "Desconocido");
        assertThrows(IllegalArgumentException.class, () -> library.returnBook(externo));
    }



    @Test
    void testRepOKConLibrosSincronizados() {
        library.addBook("123", book1);
        assertTrue(library.repOK());
    }
}
