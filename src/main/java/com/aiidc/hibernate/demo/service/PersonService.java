package com.aiidc.hibernate.demo.service;

import com.aiidc.hibernate.demo.dao.PersonRepository;
import com.aiidc.hibernate.demo.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person getById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("用户[%ld]未找到", id)));
    }

    public List<Person> getByName(String name) {
        return personRepository.findByName(name);
    }

    public Long save(Person person) {
        personRepository.save(person);

        return person.getId();
    }
}
