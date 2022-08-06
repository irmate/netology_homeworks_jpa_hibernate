package ru.netology.DAOapp_hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.DAOapp_hibernate.entity.Person;
import ru.netology.DAOapp_hibernate.repository.AppRepository;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    private final AppRepository appRepository;

    public AppServiceImpl(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public List<Person> getPersons() {
        return appRepository.getPersons();
    }

    @Override
    public Person createOrUpdatePerson(Person person) {
        return appRepository.createOrUpdatePerson(person);
    }

    @Override
    public List<Person> getPersonByCity(String city) {
        return appRepository.getPersonByCity(city);
    }

    @Override
    public void deletePerson(String name, String surname) {
        appRepository.deletePerson(name, surname);
    }

    @Override
    public Person getPersonByNameAndSurname(String name, String surname) {
        return appRepository.findPersonByNameAndSurname(name, surname);
    }

    @Override
    public List<Person> getPersonLessThanAge(int age) {
        return appRepository.findPersonsLessThanAge(age);
    }
}