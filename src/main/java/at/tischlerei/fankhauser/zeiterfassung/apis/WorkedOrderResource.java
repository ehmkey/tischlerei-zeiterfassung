package at.tischlerei.fankhauser.zeiterfassung.apis;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import at.tischlerei.fankhauser.zeiterfassung.dtos.WorkedOrderDTO;
import at.tischlerei.fankhauser.zeiterfassung.entities.WorkedOrder;
import at.tischlerei.fankhauser.zeiterfassung.services.WorkedOrderService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * REST controller for managing WorkedOrder.
 */
@RestController
@RequestMapping("/api")
public class WorkedOrderResource {
	private final Logger log = LoggerFactory.getLogger(WorkedOrderResource.class);

	@Autowired
	private WorkedOrderService workedOrderService;

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapper = mapperFactory.getMapperFacade();

	public WorkedOrderResource(WorkedOrderService workedOrderService) {
		this.workedOrderService = workedOrderService;
	}

	/**
	 * POST /worked : Create a new workedOrder.
	 *
	 * @param workedOrderDTO
	 *            the workedOrderDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         workedOrderDTO, or with status 400 (Bad Request) if the workedOrder
	 *         has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/worked")
	public ResponseEntity<WorkedOrderDTO> createWorkedOrder(@Valid @RequestBody WorkedOrderDTO workedOrderDTO) {
		log.debug("REST request to save WorkedOrder : {}", workedOrderDTO);
		if (workedOrderDTO.getId() != null) {
			throw new ValidationException("A new workedOrder cannot already have an ID");
		}

		WorkedOrder result = workedOrderService.save(mapper.map(workedOrderDTO, WorkedOrder.class));

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();

		return ResponseEntity.created(location).body(mapper.map(result, WorkedOrderDTO.class));
	}

	/**
	 * PUT /worked : Updates an existing workedOrder.
	 *
	 * @param workedOrderDTO
	 *            the workedOrderDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         workedOrderDTO, or with status 400 (Bad Request) if the
	 *         workedOrderDTO is not valid, or with status 500 (Internal Server
	 *         Error) if the workedOrderDTO couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/worked")
	public ResponseEntity<WorkedOrderDTO> updateWorkedOrder(@Valid @RequestBody WorkedOrderDTO workedOrderDTO) {
		log.debug("REST request to update WorkedOrder : {}", workedOrderDTO);
		if (workedOrderDTO.getId() == null) {
			throw new ValidationException("Can't update Worked Order without ID");
		}

		workedOrderService.save(mapper.map(workedOrderDTO, WorkedOrder.class));
		return ResponseEntity.noContent().build();
	}

	/**
	 * GET /worked : get all the workedOrders.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of workedOrders
	 *         in body
	 */
	@GetMapping("/worked")
	public Page<WorkedOrderDTO> getAllWorkedOrders(Pageable pageable) {
		log.debug("REST request to get a page of WorkedOrders");
		Page<WorkedOrder> page = workedOrderService.findAll(pageable);

		return page.map(w -> mapper.map(w, WorkedOrderDTO.class));
	}

	/**
	 * GET /worked/:id : get the "id" workedOrder.
	 *
	 * @param id
	 *            the id of the workedOrderDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         workedOrderDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/worked/{id}")
	public ResponseEntity<WorkedOrderDTO> getWorkedOrder(@PathVariable Long id) {
		log.debug("REST request to get WorkedOrder : {}", id);
		WorkedOrder workedOrder = workedOrderService.findOne(id);
		return ResponseEntity.ok(mapper.map(workedOrder, WorkedOrderDTO.class));
	}

	/**
	 * DELETE /worked/:id : delete the "id" workedOrder.
	 *
	 * @param id
	 *            the id of the workedOrderDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/worked/{id}")
	public ResponseEntity<Void> deleteWorkedOrder(@PathVariable Long id) {
		log.debug("REST request to delete WorkedOrder : {}", id);
		workedOrderService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
