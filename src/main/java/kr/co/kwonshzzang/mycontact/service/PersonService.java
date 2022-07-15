package kr.co.kwonshzzang.mycontact.service;

import kr.co.kwonshzzang.mycontact.domain.Block;
import kr.co.kwonshzzang.mycontact.domain.Person;
import kr.co.kwonshzzang.mycontact.repository.BlockRepository;
import kr.co.kwonshzzang.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlocks() {
//        List<Person> people = personRepository.findAll();
//
//        return people.stream().filter(person -> person.getBlock() == null).toList();
        return personRepository.findByBlockIsNull();
    }



    @Transactional
    public Person getPerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);

        log.info("person: {}", person);
        return person;
    }


    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> getPeopleByBloodType(String bloodType) {
        return personRepository.findByBloodType(bloodType);
    }

    public List<Person> getPeopleByBirthday(int monthOfBirthday) {
        return personRepository.findByMonthOfBirthday(monthOfBirthday);
    }


}
