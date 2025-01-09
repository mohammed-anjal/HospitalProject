package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.Person;

public interface PersonDao {
	Person savePerson(int eid, Person person);
	
	boolean deletePersonById(int pid);
	
	Person getPersonById(int pid);
	
	Person updatePersonById(int pid, Person person);
	
	List<Person> getAllPerson();
	
	List<Person> getPersonByGender(String gender);
	
	List<Person> getPersonByAge(int age);
	
	List<Person> getPersonByPhone(long phone);
}
