package ru.netology.DAOapp_hibernate.service;

import ru.netology.DAOapp_hibernate.entity.Person;

import java.util.List;

public interface AppService {
    List<Person> getPersons();

    Person createOrUpdatePerson(Person person);

    List<Person> getPersonByCity(String city);

    void deletePerson(String name, String surname);

    Person getPersonByNameAndSurname(String name, String surname);

    List<Person> getPersonLessThanAge(int age);
}