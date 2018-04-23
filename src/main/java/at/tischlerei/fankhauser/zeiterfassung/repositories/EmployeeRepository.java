package at.tischlerei.fankhauser.zeiterfassung.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.tischlerei.fankhauser.zeiterfassung.entities.Employee;


/**
 * Spring Data JPA repository for the Employee entity.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
