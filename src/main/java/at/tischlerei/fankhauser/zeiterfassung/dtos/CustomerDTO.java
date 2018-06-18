package at.tischlerei.fankhauser.zeiterfassung.dtos;

import javax.persistence.Column;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A DTO for the Customer entity.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerDTO{
    private Long id;

    private String name;

    private String phone;

    @Column(name = "additonal_information")
    private String additonalInformation;

    private String zip;

    private String street;

    private String city;
}
