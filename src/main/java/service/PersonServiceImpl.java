package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
			
		/*List<Person> list = new ArrayList<>();
		Iterable iterable = personDAO.findAll();
		for (Object item : iterable) {
			list.add((Person) item);
	    }
		
		Stream s = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterable.iterator(), Spliterator.ORDERED), false);
		List listOfStream = (List) s.collect(Collectors.toList());
		List listOfString  = (List) s.collect(Collectors.toCollection(ArrayList::new));


		
		return list;*/
		
		return null;
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
