package at.tischlerei.fankhauser.zeiterfassung.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.tischlerei.fankhauser.zeiterfassung.entities.Order;


/**
 * Spring Data JPA repository for the Order entity.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
