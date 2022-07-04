package kr.co.kwonshzzang.mycontact.service;

import kr.co.kwonshzzang.mycontact.domain.Block;
import kr.co.kwonshzzang.mycontact.domain.Person;
import kr.co.kwonshzzang.mycontact.repository.BlockRepository;
import kr.co.kwonshzzang.mycontact.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlocks() {
        List<Person> people = personRepository.findAll();

        return people.stream().filter(person -> person.getBlock() == null).toList();
    }


}
