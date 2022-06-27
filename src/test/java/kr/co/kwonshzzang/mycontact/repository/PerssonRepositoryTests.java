package kr.co.kwonshzzang.mycontact.repository;

import kr.co.kwonshzzang.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PerssonRepositoryTests {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person();
        person.setName("martin");
        person.setAge(10);
        personRepository.save(person);

//        System.out.println(personRepository.findAll());
        List<Person> people = personRepository.findAll();
        assertEquals(people.size(), 1);
        assertEquals(people.get(0).getName(), "martin");
        assertEquals(people.get(0).getAge(), 10);
    }

}