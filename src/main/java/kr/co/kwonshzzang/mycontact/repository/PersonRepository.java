package kr.co.kwonshzzang.mycontact.repository;

import kr.co.kwonshzzang.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
