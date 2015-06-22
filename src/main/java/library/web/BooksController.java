package library.web;

import java.util.List;

import library.domain.books.BookRepository;
import library.domain.books.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@Autowired
	BookRepository bookRepository;
	
	public BooksController() { }
	
	public BooksController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
    public List<Book> getBooks() {
    	return bookRepository.findAll();
    }
	
	@RequestMapping("/books/lentBy/{id}")
    public List<Book> getLentBooks(@PathVariable Long id) {
    	return bookRepository.findByRentedBy(id);
    }
	
}
