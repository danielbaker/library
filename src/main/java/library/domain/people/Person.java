package library.domain.people;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import library.domain.books.Book;

@Entity(name="People")
public class Person {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String emailAddress;
	
	@Column
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy="rentedBy", fetch=FetchType.LAZY)
	private List<Book> onLoan;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<Book> getOnLoan() {
		return onLoan;
	}

	public void setOnLoan(List<Book> onLoan) {
		this.onLoan = onLoan;
	}
}
