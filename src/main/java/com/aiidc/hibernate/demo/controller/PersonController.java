package com.aiidc.hibernate.demo.controller;

import com.aiidc.hibernate.demo.entity.Person;
import com.aiidc.hibernate.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPerson(@RequestParam String name) {
        return ResponseEntity.ok(personService.getByName(name));
    }

    @PostMapping
    public ResponseEntity savePerson(@RequestBody Person req) {
        Person person = new Person();
        person.setAge(req.getAge());
        person.setName(req.getName());
        person.setProfile(req.getProfile());
        person.setCreateTime(LocalDateTime.now());

        Long id = personService.save(person);

        return ResponseEntity.ok(id);
    }
}
