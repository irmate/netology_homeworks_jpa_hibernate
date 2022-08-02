create table persons
(
    name varchar(255),
    surname varchar(255),
    age int,
    phone_number varchar(20),
    city_of_living varchar(100),
    primary key (name, surname, age)
);