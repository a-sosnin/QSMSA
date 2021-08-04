package ru.diasoft.qsmsa.crudservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_gen")
    @SequenceGenerator(name = "person_gen", sequenceName = "person_sequence", allocationSize = 1)    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "last_name", length = 64, nullable = false)
    private String lastName;

    @Column(name = "first_name", length = 64, nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 64)
    private String middleName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    public Person() {
    }

    public Person(String lastName, String firstName, String middleName, Date dateOfBirth){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
