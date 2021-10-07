package com.cooley.allbooks.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cooley.allbooks.models.Book;
import com.cooley.allbooks.services.BookService;


@Controller
public class BookController {
	
	private final BookService bookService;
	 
	public BookController(BookService bookService){
	    this.bookService = bookService;
	}
	@GetMapping("/books")
	public String show(Model model) {
		List<Book> allBooks = bookService.allBooks();
		model.addAttribute("book", allBooks);
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@RequestMapping("/books/new")
    public String createBook(@ModelAttribute("book") Book book) {
        return "newBook.jsp";
    }
    @RequestMapping(value="/books/new", method=RequestMethod.POST)
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "newBook.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "editBook.jsp";
    }
    
    @RequestMapping(value="/books/{id}/edit", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "editBook.jsp";
        } 
        else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
	
