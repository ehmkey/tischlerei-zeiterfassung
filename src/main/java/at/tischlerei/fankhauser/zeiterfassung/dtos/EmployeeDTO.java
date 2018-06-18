package at.tischlerei.fankhauser.zeiterfassung.dtos;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A DTO for the Employee entity.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeDTO{
    private Long id;

    private String firstname;

    private String lastname;

    private String phone;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthday;

    private String zip;

    private String street;

    private String city;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfJoining;

    private Long hourlyRate;

    private String iban;

    private String bic;

    private String bankname;
}
