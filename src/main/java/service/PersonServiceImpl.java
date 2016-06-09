package service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PersonDAO;
import model.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	@Override
	public boolean signUp(Person person) {
		
		personDAO.save(person);
		return true;
	}

	@Transactional
	@Override
	public List<Person> getPersons() {

		int x = 0;
		int xy = x;
		Iterable iterable = personDAO.findAll();
		Stream s = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterable.iterator(), Spliterator.ORDERED), false);
		List<Person> persons = (List<Person>) s.collect(Collectors.toList());
		s.close();
	
		return persons;
	}

	@Transactional
	@Override
	public Person findById(int idPerson) {
		return personDAO.findByIdPerson(idPerson);
	}

	@Transactional
	@Override
	public Person login(String email, String password) {
		return personDAO.login(email, password);
	}

}
