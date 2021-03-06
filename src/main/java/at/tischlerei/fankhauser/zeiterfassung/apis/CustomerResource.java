package at.tischlerei.fankhauser.zeiterfassung.apis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.tischlerei.fankhauser.zeiterfassung.dtos.CustomerDTO;
import at.tischlerei.fankhauser.zeiterfassung.entities.Customer;
import at.tischlerei.fankhauser.zeiterfassung.services.CustomerService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * REST controller for managing Customer.
 */
@Controller
public class CustomerResource {
	private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    @Autowired
    private CustomerService customerService;
    
	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapper = mapperFactory.getMapperFacade();


    @PostMapping("/customers")
    public String createOrUpdate(CustomerDTO customerDTO) {
    	log.debug("REST request to save Customer : {}", customerDTO);

    	customerService.save(mapper.map(customerDTO, Customer.class));
        
        return "redirect:/customers";
    }

    /**
     * GET  /customers : get all the customers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of customers in body
     */
    @GetMapping("/customers")
    public String getAll(Model model) {
        log.debug("REST request to get a page of Customers");
        List<Customer> customers = customerService.findAll();
        
        model.addAttribute("customers", mapper.mapAsList(customers, CustomerDTO.class));
        return "customers";
    }
    
    @GetMapping("/customers/add")
    public String createProduct(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        return "customer";
    }

    /**
     * GET  /customers/:id : get the "id" customer.
     *
     * @param id the id of the customerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the customerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/customers/{id}")
    public String getById(Model model, @PathVariable Long id) {
        log.debug("REST request to get Customer : {}", id);
        
        model.addAttribute("customer", customerService.findOne(id));
        
        return "customer";
    }

    /**
     * DELETE  /customers/:id : delete the "id" customer.
     *
     * @param id the id of the customerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable Long id) {
        log.debug("REST request to delete Customer : {}", id);
        customerService.delete(id);
        
        return "redirect:/customers";
    }

//    /**
//     * POST  /customers : Create a new customer.
//     *
//     * @param customerDTO the customerDTO to create
//     * @return the ResponseEntity with status 201 (Created) and with body the new customerDTO, or with status 400 (Bad Request) if the customer has already an ID
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @PostMapping("/customers")
//    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) throws URISyntaxException {
//        log.debug("REST request to save Customer : {}", customerDTO);
//        if (customerDTO.getId() != null) {
//            throw new ValidationException("A new customer cannot already have an ID");
//        }
//        
//        Customer result = customerService.save(mapper.map(customerDTO, Customer.class));
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
//				.toUri();
//        
//        return ResponseEntity.created(location).body(mapper.map(result, CustomerDTO.class));
//    }
//
//    /**
//     * PUT  /customers : Updates an existing customer.
//     *
//     * @param customerDTO the customerDTO to update
//     * @return the ResponseEntity with status 200 (OK) and with body the updated customerDTO,
//     * or with status 400 (Bad Request) if the customerDTO is not valid,
//     * or with status 500 (Internal Server Error) if the customerDTO couldn't be updated
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @PutMapping("/customers")
//    public ResponseEntity<Void> updateCustomer(@RequestBody CustomerDTO customerDTO) throws URISyntaxException {
//        log.debug("REST request to update Customer : {}", customerDTO);
//        if (customerDTO.getId() == null) {
//            throw new ValidationException("Can't update Customer without ID");
//        }
//        customerService.save(mapper.map(customerDTO, Customer.class));
//        
//        return ResponseEntity.noContent().build();
//    }
//
//    /**
//     * GET  /customers : get all the customers.
//     *
//     * @param pageable the pagination information
//     * @return the ResponseEntity with status 200 (OK) and the list of customers in body
//     */
//    @GetMapping("/customers")
//    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
//        log.debug("REST request to get a page of Customers");
//        Page<Customer> page = customerService.findAll(pageable);
//        
//        return page.map(o -> mapper.map(o, CustomerDTO.class));
//    }
//
//    /**
//     * GET  /customers/:id : get the "id" customer.
//     *
//     * @param id the id of the customerDTO to retrieve
//     * @return the ResponseEntity with status 200 (OK) and with body the customerDTO, or with status 404 (Not Found)
//     */
//    @GetMapping("/customers/{id}")
//    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
//        log.debug("REST request to get Customer : {}", id);
//        Customer customer = customerService.findOne(id);
//        
//        return ResponseEntity.ok().body(mapper.map(customer, CustomerDTO.class));
//    }
//
//    /**
//     * DELETE  /customers/:id : delete the "id" customer.
//     *
//     * @param id the id of the customerDTO to delete
//     * @return the ResponseEntity with status 200 (OK)
//     */
//    @DeleteMapping("/customers/{id}")
//    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
//        log.debug("REST request to delete Customer : {}", id);
//        customerService.delete(id);
//        
//        return ResponseEntity.noContent().build();
//    }
}
