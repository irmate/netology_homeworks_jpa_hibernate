package ru.netology.DAOapp_hibernate.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AppRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List getPersonsByCity(String city) {
        return entityManager
                .createQuery("select p from Person p where p.cityOfLiving = :city")
                .setParameter("city", city)
                .getResultList();
    }
}