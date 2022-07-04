package kr.co.kwonshzzang.mycontact.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private int age;
    private String hobby;
    @NonNull
    private String bloodType;
    private String address;
    private LocalDate birthDay;
    private String job;
    @ToString.Exclude
    private String phoneNumber;

//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block;

}
