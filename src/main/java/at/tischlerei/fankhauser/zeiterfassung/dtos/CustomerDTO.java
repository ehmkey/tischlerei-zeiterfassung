package at.tischlerei.fankhauser.zeiterfassung.dtos;

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

    private String contact;

    private String address;
}
