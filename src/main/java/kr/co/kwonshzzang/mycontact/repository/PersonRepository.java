package kr.co.kwonshzzang.mycontact.repository;

import kr.co.kwonshzzang.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
    List<Person> findByBlockIsNull();
    List<Person> findByBloodType(String bloodType);
//    @Query(value = "select person from Person person where person.birthDay.monthOfBirthday = ?1 and person.birthDay.dayOfBirthday =?2")
//    @Query(value = "select person from Person person where person.birthDay.monthOfBirthday = :monthOfBirthday and person.birthDay.dayOfBirthday =:dayOfBirthday")
//    @Query(value = "select * from person where month_of_birthday = :monthOfBirthday and day_of_birthday =:dayOfBirthday", nativeQuery = true)
    @Query(value = "select person from Person person where person.birthDay.monthOfBirthday =?1")
    List<Person> findByMonthOfBirthday(int monthOfBirthday);
//    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday, @Param ("dayOfBirthday") int dayOfBirthday);
}
