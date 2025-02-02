package ca.sheridancollege.trenholg.onlinebookstore.beans;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookCartList {
    private List<Book> cartBooks = new ArrayList<>();

    public void addToCart(Book book) {
        cartBooks.add(book);
    }

    public List<Book> getCartBooks() {
        return cartBooks;
    }

    public int getSize() {
        return cartBooks.size();
    }
}
