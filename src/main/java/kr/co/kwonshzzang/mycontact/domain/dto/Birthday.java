package kr.co.kwonshzzang.mycontact.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Embeddable
public class Birthday {
    private Integer yearOfBirthday;
    @Min(1)
    @Max(12)
    private Integer monthOfBirthday;
    @Min(1)
    @Max(31)
    private Integer dayOfBirthday;

    public Birthday(LocalDate birthDay) {
        this.yearOfBirthday = birthDay.getYear();
        this.monthOfBirthday = birthDay.getMonthValue();
        this.dayOfBirthday = birthDay.getDayOfMonth();
    }
}
