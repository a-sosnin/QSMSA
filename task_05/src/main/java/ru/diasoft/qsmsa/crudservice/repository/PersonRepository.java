package ru.diasoft.qsmsa.crudservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.qsmsa.crudservice.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
