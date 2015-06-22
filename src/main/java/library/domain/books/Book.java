package library.domain.books;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import library.domain.people.Person;

@Entity(name="books")
public class Book {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String isbn;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private Person rentedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Person getRentedBy() {
		return rentedBy;
	}

	public void setRentedBy(Person rentedBy) {
		this.rentedBy = rentedBy;
	}
	
}
