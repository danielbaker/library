package library.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import library.domain.people.PeopleRepository;
import library.domain.people.Person;

import org.junit.Before;
import org.junit.Test;

public class PeopleControllerTests {
	PeopleController controller;
	PeopleRepository repository;
	
	@Before
	public void setUp() {
		repository = mock(PeopleRepository.class);
		controller = new PeopleController(repository);
	}

	@Test
	public void returnsAllBooksFromTheRepository() {
		List<Person> people = new ArrayList<Person>();
		when(repository.findAll()).thenReturn(people);
		assertThat(controller.getPeople(), is(people));
	}
}
