package at.tischlerei.fankhauser.zeiterfassung.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.tischlerei.fankhauser.zeiterfassung.entities.WorkedOrder;


/**
 * Spring Data JPA repository for the WorkedOrder entity.
 */
@Repository
public interface WorkedOrderRepository extends JpaRepository<WorkedOrder, Long> {

}
