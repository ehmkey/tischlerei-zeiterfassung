package at.tischlerei.fankhauser.zeiterfassung.services;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.tischlerei.fankhauser.zeiterfassung.entities.WorkedOrder;
import at.tischlerei.fankhauser.zeiterfassung.repositories.WorkedOrderRepository;


/**
 * Service Implementation for managing WorkedOrder.
 */
@Service
@Transactional
public class WorkedOrderService {

    private final Logger log = LoggerFactory.getLogger(WorkedOrderService.class);

    @Autowired
    private WorkedOrderRepository workedOrderRepository;

    /**
     * Save a workedOrder.
     *
     * @param WorkedOrder the entity to save
     * @return the persisted entity
     */
    public WorkedOrder save(WorkedOrder workedOrder) {
        log.debug("Request to save WorkedOrder : {}", workedOrder);
        return workedOrderRepository.save(workedOrder);
    }

    /**
     * Get all the workedOrders.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<WorkedOrder> findAll(Pageable pageable) {
        log.debug("Request to get all WorkedOrders");
        return workedOrderRepository.findAll(pageable);
    }

    /**
     * Get one workedOrder by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public WorkedOrder findOne(Long id) {
        log.debug("Request to get WorkedOrder : {}", id);
        return workedOrderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * Delete the workedOrder by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete WorkedOrder : {}", id);
        workedOrderRepository.deleteById(id);
    }
}
