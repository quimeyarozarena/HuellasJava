package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import model.Person;
import service.PersonService;

@Controller
@Path("/persons")
public class PersonResourceImpl implements PersonResource {

	@Autowired
	private PersonService personService;
	
	@POST
	@Path("/signUp")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	@Override
	public boolean signUp(Person person) {
		return personService.signUp(person);
	}

	@GET
	@Path("/getPersons")
	@Produces({MediaType.APPLICATION_JSON})
	@Override
	public List<Person> getPersons() {
		return personService.getPersons();
		
	}

	@GET
	@Path("/getById/{idPerson}")
	@Produces({MediaType.APPLICATION_JSON})
	@Override
	public Person findById(@PathParam("idPerson") int idPerson) {
		Person person = null;
		try{
			person = personService.findById(idPerson);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return person;
	}


	@POST
	@Path("/login/{email}/{password}")
	@Produces({MediaType.APPLICATION_JSON})
	@Override
	public Person login(@PathParam("email") String email, @PathParam("password") String password) {
		return personService.login(email, password);
	}
	
}
