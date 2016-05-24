package resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Person;
import service.PersonService;

@RestController
@RequestMapping(value="person")
public class PersonResourceImpl implements PersonResource {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@Override
	public boolean signUp(@RequestBody Person person) {
		return personService.signUp(person);
	}

	@RequestMapping(value = "/getPersons", method = RequestMethod.GET)
	@Override
	public @ResponseBody List<Person> getPersons() {
		return personService.getPersons();
		
	}

	@RequestMapping(value = "/GetById/{idPerson}", method = RequestMethod.GET)
	@Override
	public @ResponseBody Person findById(@PathVariable int idPerson) {
		Person person = null;
		try{
			person = personService.findById(idPerson);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return person;
	}


	@RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.POST)
	@Override
	public @ResponseBody Person login(@PathVariable(value="email") String email, @PathVariable(value="password") String password) {
		return personService.login(email, password);
	}

	
}
