package kr.co.kwonshzzang.mycontact.service;

import kr.co.kwonshzzang.mycontact.domain.Block;
import kr.co.kwonshzzang.mycontact.domain.Person;
import kr.co.kwonshzzang.mycontact.repository.BlockRepository;
import kr.co.kwonshzzang.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();
//        System.out.println(result);
        result.stream().forEach(System.out::println);
    }

    private void givenPeople() {
        givenPerson("martin", 10, "A");
        givenPerson("david", 9, "B");
        givenBlockPerson("dennis", 7, "O");
        givenBlockPerson("martin", 11, "AB");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(givenBlocks("martin"));
        personRepository.save(blockPerson);
    }

    private void givenBlocks() {
        givenBlocks("martin");
    }

    private Block givenBlocks(String name) {
        return blockRepository.save(new Block(name));
    }


}