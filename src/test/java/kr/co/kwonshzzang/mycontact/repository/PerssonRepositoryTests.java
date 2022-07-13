package kr.co.kwonshzzang.mycontact.repository;

import kr.co.kwonshzzang.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PerssonRepositoryTests {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person();
        person.setName("john");
        person.setAge(10);
        person.setBloodType("A");
        personRepository.save(person);

        List<Person> people = personRepository.findByName("john");
        assertEquals(people.size(), 1);
        assertEquals(people.get(0).getName(), "john");
        assertEquals(people.get(0).getAge(), 10);
        assertEquals(people.get(0).getBloodType(), "A");
    }

    @Test
    void findByBloodType() {
        List<Person> reslult = personRepository.findByBloodType("A");

        assertEquals(reslult.size(), 2);
        assertEquals(reslult.get(0).getName(), "martin");
        assertEquals(reslult.get(1).getName(), "benn");
    }

    @Test
    void findByBirthdayBetween() {
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getName(), "martin");
        assertEquals(result.get(1).getName(), "sophia");
    }


}