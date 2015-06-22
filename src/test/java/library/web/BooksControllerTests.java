package library.web;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import library.domain.books.Book;
import library.domain.books.BookRepository;

import org.junit.Before;
import org.junit.Test;

public class BooksControllerTests {

	BooksController controller;
	BookRepository repository;
	
	@Before
	public void setUp() {
		repository = mock(BookRepository.class);
		controller = new BooksController(repository);
	}

	@Test
	public void returnsAllBooksFromTheRepository() {
		List<Book> books = new ArrayList<Book>();
		when(repository.findAll()).thenReturn(books);
		assertThat(controller.getBooks(), is(books));
	}
	
	@Test
	public void returnsPersonsBooksFromTheRepository() {
		List<Book> books = new ArrayList<Book>();
		when(repository.findByRentedBy(1L)).thenReturn(books);
		assertThat(controller.getLentBooks(1L), is(books));
	}
	
}
