package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.PersonDaoImp;
import com.ty.hospitalapp.dto.Person;

public class PersonService {
	PersonDaoImp daoImp = new PersonDaoImp();

	public void savePersonService(Person person,int eid) {
		Person personRt = daoImp.savePerson(eid, person);
		if (personRt != null) {
			System.out.println("Data Saved");
		} else {
			System.out.println("Data was not saved !");
		}
	}

	public void deletePersonService(int pid) {
		boolean flag = daoImp.deletePersonById(pid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data was not deleted!");
		}
	}

	public Person getPersonById(int pid) {
		Person person = daoImp.getPersonById(pid);
		if (person != null) {
			return person;
		} else {
			return null;
		}
	}

	public void UpdatePersonService(Person person,int pid) {
		Person personRt = daoImp.updatePersonById(pid,person);
		if(personRt != null) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data was not updated !");
		}
}
	public List<Person> getAllPersonService() {
		List<Person> persons = daoImp.getAllPerson();
		if (persons != null) {
			return persons;
		} else {
			return null;
		}
	}
}
