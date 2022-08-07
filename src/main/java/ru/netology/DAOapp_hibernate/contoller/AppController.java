package ru.netology.DAOapp_hibernate.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.DAOapp_hibernate.entity.Person;
import ru.netology.DAOapp_hibernate.service.AppServiceImpl;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {
    private final AppServiceImpl appServiceImpl;

    public AppController(AppServiceImpl appServiceImpl) {
        this.appServiceImpl = appServiceImpl;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> read() {
        var persons = appServiceImpl.getPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping("/persons/create")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        var newPerson = appServiceImpl.createOrUpdatePerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

    @PutMapping("/persons/update")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        var updatedPerson = appServiceImpl.createOrUpdatePerson(person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping("/persons/delete")
    public ResponseEntity<String> delete(@PathParam("name") String name, @PathParam("surname") String surname) {
        appServiceImpl.deletePerson(name, surname);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Person>> getPersonsByCity(@PathParam("city") String city) {
        var personsByCity = appServiceImpl.getPersonByCity(city);
        return new ResponseEntity<>(personsByCity, HttpStatus.OK);
    }

    @GetMapping("/persons/by-name-surname")
    public ResponseEntity<Person> getPersonByNameAndSurname(@PathParam("name") String name, @PathParam("surname") String surname) {
        var personByNameAndSurname = appServiceImpl.getPersonByNameAndSurname(name, surname);
        return new ResponseEntity<>(personByNameAndSurname, HttpStatus.OK);
    }

    @GetMapping("/persons/by-lessthan-age/{age}")
    public ResponseEntity<List<Person>> getPersonLessThanAge(@PathVariable int age) {
        var personsLessThanAge = appServiceImpl.getPersonLessThanAge(age);
        return new ResponseEntity<>(personsLessThanAge, HttpStatus.OK);
    }
}