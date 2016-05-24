package resource;

import java.util.List;

import model.Person;

public interface PersonResource {
	
    public boolean signUp(Person person);
    public List<Person> getPersons();
    public Person findById(int idPerson);
    public Person login(String email, String password);

}
