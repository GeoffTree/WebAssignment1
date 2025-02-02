package ca.sheridancollege.trenholg.onlinebookstore.controllers;

import ca.sheridancollege.trenholg.onlinebookstore.beans.BookList;
import ca.sheridancollege.trenholg.onlinebookstore.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @Autowired
    private BookList bookList;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/Books")
    public String availableBook(Model model) {
        model.addAttribute("books", bookList.getBooks());
        return "availableBook";
    }

    @GetMapping("/Checkout")
    public String checkout(Model model) {
        return "checkout";
    }

    @GetMapping("/ShoppingCart")
    public String shoppingBook(Model model) {
        return "shoppingBook";
    }
}
