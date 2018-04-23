package at.tischlerei.fankhauser.zeiterfassung.dtos;


import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A DTO for the Order entity.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderDTO {

    private Long id;

    private Long calcualtedHours;

    private LocalDate orderDate;

    private String invoiceNumber;

    private LocalDate invoiceDate;

    private Long price;

    private Integer deliveryWeek;

    private Long customerId;
}
