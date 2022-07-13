package kr.co.kwonshzzang.mycontact.service;

import kr.co.kwonshzzang.mycontact.domain.Person;
import kr.co.kwonshzzang.mycontact.repository.BlockRepository;
import kr.co.kwonshzzang.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTests {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludedBlocks() {
        List<Person> result = personService.getPeopleExcludeBlocks();

        assertEquals(result.size(), 3);
        assertEquals(result.get(0).getName(), "david");
        assertEquals(result.get(1).getName(), "dennis");
        assertEquals(result.get(2).getName(), "benn");
//
    }

    @Test
    void getPeopleByName() {
        List<Person> result = personService.getPeopleByName("martin");

        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getName(), "martin");
    }

    @Test
    void findByBloodType() {
        List<Person> result = personService.getPeopleByBloodType("A");

        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getName(), "martin");
        assertEquals(result.get(1).getName(), "benn");
    }

    @Test
    void findByBirthdayBetween() {
        List<Person> result = personService.getPeopleByBirthday(8);

        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getName(), "martin");
        assertEquals(result.get(1).getName(), "sophia");
    }



    @Test
    void getPerson() {
        Person person = personService.getPerson(3L);

        assertEquals(person.getName(), "dennis");

    }

}