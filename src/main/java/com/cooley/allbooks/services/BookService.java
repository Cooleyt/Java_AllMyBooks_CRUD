package com.cooley.allbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooley.allbooks.models.Book;
import com.cooley.allbooks.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book oneBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		return optionalBook.get();		
    	}else {
    		return null;
    	}
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    //updates book
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
    	Book book = oneBook(id);
    		book.setTitle(title);
    		book.setDescription(desc);
    		book.setLanguage(lang);
    		book.setNumberOfPages(numOfPages);
    		
    		return bookRepository.save(book);
    }
}
