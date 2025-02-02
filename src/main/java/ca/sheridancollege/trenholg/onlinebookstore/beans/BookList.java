package ca.sheridancollege.trenholg.onlinebookstore.beans;

import lombok.Getter;
import org.springframework.stereotype.Component;

import ca.sheridancollege.trenholg.onlinebookstore.beans.Book;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class BookList {
    private List<Book> books = new ArrayList<>();

    public BookList() {
        createInventory();
    }

    private void createInventory() {
        books.add(new Book("test 1", "author 1", 10.10 ));
        books.add(new Book("test 2", "author 2", 10.20 ));
        books.add(new Book("test 3", "author 3", 10.30 ));

    }

    public void addBook(Book book) {
        books.add(book);
    }
}
