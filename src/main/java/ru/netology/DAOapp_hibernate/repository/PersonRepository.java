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
    @Query("select p from Person p where upper(p.cityOfLiving) like upper(:cityOfLiving)")
    List<Person> findByCityOfLivingLikeIgnoreCase(@Param("cityOfLiving") @NonNull String cityOfLiving);

    @Query("select p from Person p where p.contact.age < :age order by p.contact.age")
    List<Person> findByContact_AgeLessThanOrderByContact_AgeAsc(@Param("age") int age);

    @Query("select p from Person p where p.contact.name = :name and p.contact.surname = :surname")
    Optional<Person> findByContact_NameAndContact_Surname(@Param("name") @NonNull String name, @Param("surname") @NonNull String surname);

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