package library.domain.people;

import java.util.List;

import library.domain.books.Book;

import org.springframework.data.repository.*;

public interface PeopleRepository extends Repository<Person, Long>  {

	public List<Person> findAll();
	
}
