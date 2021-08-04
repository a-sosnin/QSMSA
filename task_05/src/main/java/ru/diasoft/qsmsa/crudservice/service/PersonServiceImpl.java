package ru.diasoft.qsmsa.crudservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diasoft.qsmsa.crudservice.entity.Person;
import ru.diasoft.qsmsa.crudservice.exception.NotFoundException;
import ru.diasoft.qsmsa.crudservice.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Person insert(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person update(Long id, Person person) {
        Person foundPerson = personRepository.findById(id).orElseThrow(NotFoundException::new);
        foundPerson.setLastName(person.getLastName());
        foundPerson.setFirstName(person.getFirstName());
        foundPerson.setMiddleName(person.getMiddleName());
        foundPerson.setDateOfBirth(person.getDateOfBirth());
        personRepository.save(foundPerson);
        return person;
    }
}
