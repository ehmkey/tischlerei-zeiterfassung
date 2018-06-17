package at.tischlerei.fankhauser.zeiterfassung.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.tischlerei.fankhauser.zeiterfassung.entities.Employee;
import at.tischlerei.fankhauser.zeiterfassung.repositories.EmployeeRepository;

/**
 * Service Implementation for managing Employee.
 */
@Service
@Transactional
public class EmployeeService {
	private final Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Save a Employee.
	 *
	 * @param employee
	 *            the entity to save
	 * @return the persisted entity
	 */
	public Employee save(Employee employee) {
		log.debug("Request to save Employee : {}", employee);
		return employeeRepository.save(employee);
	}

	/**
	 * Get all the Employees.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		log.debug("Request to get all Employees");
		return employeeRepository.findAll();
	}

	/**
	 * Get one Employee by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Transactional(readOnly = true)
	public Employee findOne(Long id) {
		log.debug("Request to get Employee : {}", id);
		return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	/**
	 * Delete the Employee by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	public void delete(Long id) {
		log.debug("Request to delete Employee : {}", id);
		if (!employeeRepository.existsById(id)) {
			log.debug("Employee with ID {} doesn't exist. Skip deleting", id);
			return;
		}
		
		employeeRepository.deleteById(id);
	}
}
