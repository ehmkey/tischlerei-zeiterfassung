package at.tischlerei.fankhauser.zeiterfassung.entities;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String firstname;

    @NotNull
    @Column(nullable = false)
    private String lastname;

    private String phone;

    private LocalDate birthday;

    private String address;

    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;

    @Column(name = "hourly_rate")
    private Long hourlyRate;

    private String iban;

    private String bic;

    private String bankname;
}
