package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.PersonDao;
import com.ty.hospitalapp.dto.Encounter;
import com.ty.hospitalapp.dto.MedOrder;
import com.ty.hospitalapp.dto.Observation;
import com.ty.hospitalapp.dto.Person;

public class PersonDaoImp implements PersonDao{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Person savePerson(int eid, Person person) {
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			
			return person;
		}
		return null;
	}

	public boolean deletePersonById(int pid) {
		Person person = entityManager.find(Person.class, pid);
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			
			return true;
		}
		return false;
	}

	public Person getPersonById(int pid) {
		Person person = entityManager.find(Person.class, pid);
		if (person != null) {
			return person;
		}
		return null;
	}

	public Person updatePersonById(int pid, Person person) {
		Person person1 = entityManager.find(Person.class, pid);
		if (person != null) {
			person1.setAddress(person.getAddress());
			person1.setAge(person.getAge());
			person1.setDob(person.getDob());
			person1.setEmail(person.getEmail());
			person1.setEncounters(person.getEncounters());
			person1.setGender(person.getGender());
			person1.setName(person.getName());
			person1.setPhno(person.getPhno());
			
			entityTransaction.begin();
			entityManager.merge(person1);
			entityTransaction.commit();
			
			return person1;
		}
		return null;
	}

	public List<Person> getAllPerson() {
		Query query = entityManager.createQuery("select s from Person s");
		List<Person> persons = query.getResultList();
		return persons;
	}

	public List<Person> getPersonByGender(String gender) {
		Query query = entityManager.createQuery("SELECT o.gender FROM Person o WHERE o.gender =?");
		query.setParameter(1, gender);
		List <Person> persons = query.getResultList();
		return persons;
	
	}

	public List<Person> getPersonByAge(int age) {
		Query query = entityManager.createQuery("SELECT o.age FROM Person o WHERE o.age =?");
		query.setParameter(1, age);
		List <Person> persons = query.getResultList();
		return persons;
	}

	public List<Person> getPersonByPhone(long phone) {
		Query query = entityManager.createQuery("SELECT o.phno FROM Person o WHERE o.phno =?");
		query.setParameter(1, phone);
		List <Person> persons = query.getResultList();
		return persons;
	}

}
