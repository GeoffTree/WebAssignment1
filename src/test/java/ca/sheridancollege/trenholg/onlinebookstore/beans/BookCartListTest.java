package ca.sheridancollege.trenholg.onlinebookstore.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookCartListTest {

    private BookCartList cart;

    @BeforeEach
    void setUp() {
        cart = new BookCartList();
    }

    @Test
    void addToCart() {
        Book book = new Book("test book 1", "Author Test1", 10.20);
        cart.addToCart(book);

        assertEquals(1, cart.getSize());
    }

    @Test
    void getSubtotal() {
        Book book = new Book("test book 1", "Author Test1", 10.20);
        Book book2 = new Book("test book 2", "Author Test2", 10.20);
        cart.addToCart(book);
        cart.addToCart(book2);

        double expected = 10.20 + 10.20;
        assertEquals(expected, cart.getSubtotal(), 0.01);
    }

    @Test
    void getSaleTax() {
        Book book = new Book("test book 1", "Author Test1", 10.20);
        cart.addToCart(book);
        double expected = 10.20 * 0.13;
        assertEquals(expected, cart.getSaleTax(), 0.01);
    }

    @Test
    void getTotal() {
        Book book = new Book("test book 1", "Author Test1", 10.20);
        Book book2 = new Book("test book 2", "Author Test2", 10.20);
        cart.addToCart(book);
        cart.addToCart(book2);
        double expected = (10.20 + 10.20) * 1.13;
        assertEquals(expected, cart.getTotal(), 0.01);
    }
}