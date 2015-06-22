package library.domain.books;

import java.util.List;

import library.domain.people.Person;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends Repository<Book, Long> {

	public List<Book> findAll();
	
	@Query(value="SELECT * FROM books b WHERE b.rented_by = :personId", nativeQuery=true)
	public List<Book> findByRentedBy(@Param("personId") Long personId);
	
}
