package at.tischlerei.fankhauser.zeiterfassung.dtos;


import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A DTO for the WorkedOrder entity.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class WorkedOrderDTO{
    private Long id;

    private LocalDate workingDate;

    private Long employeeId;

    private Long ordersId;
}
