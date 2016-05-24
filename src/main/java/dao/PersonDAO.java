package dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Person;

@Transactional
@Repository
public interface PersonDAO extends CrudRepository<Person, Long>{

	public Person findByIdPerson(int idPerson);
	
	 @Query("select p from Person p where p.email = :email and p.password = :password")
	 public Person login(@Param("email") String email, @Param("password") String password);
	
}
