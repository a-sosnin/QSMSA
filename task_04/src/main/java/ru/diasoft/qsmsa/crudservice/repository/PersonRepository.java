package ru.diasoft.qsmsa.crudservice.repository;

import ru.diasoft.qsmsa.crudservice.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
