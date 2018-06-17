package at.tischlerei.fankhauser.zeiterfassung.entities;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "worked_order")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class WorkedOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "working_date", nullable = false)
    private LocalDate workingDate;
    
    @NotNull
    @Column(name = "working_hours", nullable = false)
    private Double workingHours;

    @OneToOne
    @JoinColumn(unique = true)
    private Employee employee;

    @OneToOne
    @JoinColumn(unique = true)
    private Order orders;
}
