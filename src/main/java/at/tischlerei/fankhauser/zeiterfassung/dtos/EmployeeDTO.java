package at.tischlerei.fankhauser.zeiterfassung.dtos;


import java.time.LocalDate;

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

    private LocalDate birthday;

    private String address;

    private LocalDate dateOfJoining;

    private Long hourlyRate;

    private String iban;

    private String bic;

    private String bankname;
}
