package ru.diasoft.qsmsa.crudservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.qsmsa.crudservice.entity.Person;
import ru.diasoft.qsmsa.crudservice.exception.NotFoundException;
import ru.diasoft.qsmsa.crudservice.service.PersonServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    private SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    @Autowired
    PersonServiceImpl personService;

    @GetMapping
    public List<Person> getUsers() {
        return personService.getAll();
    }

    @GetMapping("{id}")
    public Person getUserById(@PathVariable long id) throws NotFoundException {
        return personService.getById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        personService.insert(person);
        return person;
    }

    @PutMapping("{id}")
    public Person update(@PathVariable long id, @RequestBody Person person) throws NotFoundException{
        return personService.update(id, person);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        personService.delete(id);
    }
}
