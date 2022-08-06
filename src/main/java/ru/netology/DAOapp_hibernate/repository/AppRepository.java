package ru.netology.DAOapp_hibernate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.DAOapp_hibernate.entity.Person;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class AppRepository {

    private final PersonRepository personRepository;

    public AppRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person createOrUpdatePerson(Person person) {
        var name = person.getContact().getName();
        var surname = person.getContact().getSurname();
        if (personRepository.findByContact_NameAndContact_Surname(name, surname).isEmpty()) {
            personRepository.save(person);
        } else {
            personRepository.updatePerson(name, surname, person.getPhoneNumber(), person.getCityOfLiving());
        }
        return person;
    }

    public List<Person> getPersonByCity(String city) {
        return personRepository.findByCityOfLivingLikeIgnoreCase(city);
    }

    public Person findPersonByNameAndSurname(String name, String surname) {
        return personRepository.findByContact_NameAndContact_Surname(name, surname).orElseThrow(EntityNotFoundException::new);
    }

    public List<Person> findPersonsLessThanAge(int age) {
        return personRepository.findByContact_AgeLessThanOrderByContact_AgeAsc(age);
    }

    public void deletePerson(String name, String surname) {
        var person = personRepository.findByContact_NameAndContact_Surname(name, surname).orElseThrow(EntityNotFoundException::new);
        personRepository.delete(person);
    }
}