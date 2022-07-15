package kr.co.kwonshzzang.mycontact.controller;

import kr.co.kwonshzzang.mycontact.domain.Person;
import kr.co.kwonshzzang.mycontact.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }
}
