package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Person;
import service.PersonService;

@Controller
//@RequestMapping(value="person")
@Path(value="/person")
public class PersonControllerImpl implements PersonController {

	@Autowired
	private PersonService personService;
	
	@POST
	@Path("/signUp")
	@Override
	public boolean signUp(@RequestBody Person person) {
		return personService.signUp(person);
	}

	//@RequestMapping(value = "/getPersons", method = RequestMethod.GET)
	@GET
	@Path("/getPersons")
	@Override
	public @ResponseBody List<Person> getPersons() {
		List<Person> personsList = new ArrayList<>();
		Person person = new Person(1, "Quimey", "Arozarena", "quimeyarozarena@gmail.com", "156167352", "qui", false, false);
		personsList.add(person);
		//return personService.getPersons();
		return personsList;
	}

	@GET
	@Path("/GetById/{idPerson}")
	@Override
	public Person findById(@PathVariable(value="idPerson") int idPerson) {
		return personService.findById(idPerson);
	}

	@POST
	@Path("/login/{email}/{password}")
	@Override
	public Person login(@PathVariable(value="email") String email, @PathVariable(value="password") String password) {
		return personService.login(email, password);
	}

	
}
