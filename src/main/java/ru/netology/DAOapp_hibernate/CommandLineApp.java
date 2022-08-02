package ru.netology.DAOapp_hibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.DAOapp_hibernate.entity.Contact;
import ru.netology.DAOapp_hibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CommandLineApp implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var persons = List.of(
                new Person(new Contact("Alexey", "Fefelov", 25), "+7(923)0030988", "Moscow"),
                new Person(new Contact("Maxim", "Semenov", 34), "+7(909)0440986", "Moscow"),
                new Person(new Contact("Nadezda", "Ignatova", 44), "+7(808)0986644", "Vologda"),
                new Person(new Contact("Kirill", "Smirnov", 33), "+7(923)004332432", "Saint-Petersburg"),
                new Person(new Contact("Anton", "Ignatov", 46), "+7(902)04342236", "Vologda"),
                new Person(new Contact("Svetlana", "Prokopchuk", 22), "+7(843)09823423", "Ivanovo")
        );

        for (Person entity : persons) {
            entityManager.persist(entity);
        }
    }
}