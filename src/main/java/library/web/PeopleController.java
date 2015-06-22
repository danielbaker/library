package library.web;

import java.util.List;

import library.domain.people.PeopleRepository;
import library.domain.people.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PeopleController {
	
	@Autowired
	PeopleRepository peopleRepository;

    public PeopleController() { }
	
    public PeopleController(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	@RequestMapping("/people")
    public List<Person> getPeople() {
    	return peopleRepository.findAll();
    }

}
