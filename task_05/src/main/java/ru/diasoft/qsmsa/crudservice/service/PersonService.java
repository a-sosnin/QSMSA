package ru.diasoft.qsmsa.crudservice.service;

import ru.diasoft.qsmsa.crudservice.entity.Person;
import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getById(Long id);
    Person insert(Person person);
    void delete(Long id);
    Person update(Long id, Person person);
}
