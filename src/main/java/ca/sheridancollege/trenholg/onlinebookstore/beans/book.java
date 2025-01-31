package ca.sheridancollege.trenholg.onlinebookstore.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class book {
    private String bookISBN;
    private String bookTitle;
    private String bookAuthor;
    private Double bookPrice;
}
