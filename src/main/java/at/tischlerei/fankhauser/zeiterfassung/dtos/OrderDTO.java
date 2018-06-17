package at.tischlerei.fankhauser.zeiterfassung.dtos;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate orderDate;

    private String invoiceNumber;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate invoiceDate;

    private Long price;

    private Integer deliveryWeek;

    private Long customerId;
}
