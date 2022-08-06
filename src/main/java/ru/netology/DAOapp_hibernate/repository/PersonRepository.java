package ru.netology.DAOapp_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.DAOapp_hibernate.entity.Contact;
import ru.netology.DAOapp_hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Contact> {
    List<Person> findByCityOfLivingLikeIgnoreCase(@NonNull String cityOfLiving);

    List<Person> findByContact_AgeLessThanOrderByContact_AgeAsc(int age);

    Optional<Person> findByContact_NameAndContact_Surname(@NonNull String name, @NonNull String surname);

    @Transactional
    @Modifying
    @Query("update Person p " +
            "set p.phoneNumber = :phoneNumber, " +
            "p.cityOfLiving = :cityOfLiving " +
            "where p.contact.name = :name and p.contact.surname = :surname")
    void updatePerson(@Param("name") String name,
                      @Param("surname") String surname,
                      @Param("phoneNumber") String phoneNumber,
                      @Param("cityOfLiving") String cityOfLiving);
}