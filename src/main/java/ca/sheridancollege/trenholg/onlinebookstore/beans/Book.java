package ca.sheridancollege.trenholg.onlinebookstore.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Data

public class Book {
    private String bookISBN;
    private String bookTitle;
    private String bookAuthor;
    private Double bookPrice;

    public Book(){
        this.bookISBN = randomISBN();
    }

    public Book(String bookTitle, String bookAuthor, Double bookPrice) {
        this.bookISBN = randomISBN();
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    private String randomISBN() {
        Random rand = new Random();
        int randomNum = rand.nextInt(900000) + 100000;
        return String.valueOf(randomNum);
    }
}
