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
        books.add(new Book("Gardening for Computer Scientists", "Red Corn", 10.10 ));
        books.add(new Book("Python? Snake, Satire or OOP", "Monty Java", 10.20 ));
        books.add(new Book("Java or Coffee? What are Beans", "Joe Sun", 10.30 ));
        books.add(new Book("Spring Boots or Winter Boots", "Rosemary Thyme", 10.40 ));
        books.add(new Book("Lombok: The Monster", "Katt Burns", 10.50 ));
        books.add(new Book("Model Viewer", "Leif Torvald", 10.10 ));
        books.add(new Book("Computer Science Puns", "Ras Pi", 10.20 ));
        books.add(new Book("Rust for Computers", "Conner Troller", 10.30 ));
        books.add(new Book("Integrated Pest Management for Coding", "Bug Ham", 10.40 ));
        books.add(new Book("No Bugs: An Unlikely Story", "Geo Tree", 10.50 ));


    }

    public void addBook(Book book) {
        books.add(book);
    }
}
