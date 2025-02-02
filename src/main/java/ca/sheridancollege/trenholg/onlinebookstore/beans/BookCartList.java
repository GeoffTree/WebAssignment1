package ca.sheridancollege.trenholg.onlinebookstore.beans;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookCartList {
    private List<Book> cartBooks = new ArrayList<>();
    private  static final double sale_tax = 0.13;

    public void addToCart(Book book) {
        cartBooks.add(book);
    }

    public List<Book> getCartBooks() {
        return cartBooks;
    }

    public int getSize() {
        return cartBooks.size();
    }

    public double getSubtotal() {
        return cartBooks.stream().mapToDouble(Book::getBookPrice).sum();
    }

    public double getSaleTax() {
        return getSubtotal() * sale_tax;
    }

    public double getTotal() {
        return getSubtotal() + getSaleTax();
    }
}
