package ca.sheridancollege.trenholg.onlinebookstore.controllers;

import ca.sheridancollege.trenholg.onlinebookstore.beans.BookList;
import ca.sheridancollege.trenholg.onlinebookstore.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


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
        model.addAttribute("newBook", new Book());
        return "availableBook";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book) {
        bookList.addBook(book);
        return "redirect:/Books";
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
