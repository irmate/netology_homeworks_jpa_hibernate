package ru.netology.DAOapp_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Persons")
public class Person {
    @EmbeddedId
    private Contact contact;
    private String phoneNumber;
    private String cityOfLiving;
}