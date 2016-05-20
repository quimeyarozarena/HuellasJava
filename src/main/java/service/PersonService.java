package service;

import java.util.List;

import model.Person;

public interface PersonService {
	
    public boolean signUp(Person person);
    public List<Person> getPersons();
    public Person findById(int idPerson);
    public Person login(String email, String password);
}
