package ca.sheridancollege.trenholg.onlinebookstore.controllers;

import ca.sheridancollege.trenholg.onlinebookstore.beans.BookCartList;
import ca.sheridancollege.trenholg.onlinebookstore.beans.BookList;
import ca.sheridancollege.trenholg.onlinebookstore.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("cart")
public class HomeController {
    @Autowired
    private BookList bookList;

    @ModelAttribute("cart")
    public BookCartList getCart(){
        return new BookCartList();
    };


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

    @GetMapping("/ShoppingBook")
    public String shoppingBook(Model model, @ModelAttribute("cart") BookCartList cart) {
        model.addAttribute("books", bookList.getBooks());
        model.addAttribute("cartSize", cart.getSize());
        return "ShoppingBook";
    }

    @GetMapping("/addToCart/{isbn}")
    public String addToCart(@PathVariable("isbn") String isbn, @ModelAttribute("cart") BookCartList cart) {
        for (Book book : bookList.getBooks()) {
            if (book.getBookISBN().equals(isbn)) {
                cart.addToCart(book);
                break;
            }
        }
        return "redirect:/ShoppingBook";
    }

    @GetMapping("/Checkout")
    public String checkout(Model model, @ModelAttribute("cart") BookCartList cart) {
        model.addAttribute("cartItems", cart.getCartBooks());
        model.addAttribute("subtotal", String.format("%.2f", cart.getSubtotal()));
        model.addAttribute("salesTax", String.format("%.2f", cart.getSaleTax()));
        model.addAttribute("total", String.format("%.2f", cart.getTotal()));
        return "checkout";
    }


}
