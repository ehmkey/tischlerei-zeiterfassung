package at.tischlerei.fankhauser.zeiterfassung.apis;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import at.tischlerei.fankhauser.zeiterfassung.dtos.EmployeeDTO;
import at.tischlerei.fankhauser.zeiterfassung.entities.Employee;
import at.tischlerei.fankhauser.zeiterfassung.services.EmployeeService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * REST controller for managing Employee.
 */
@Controller
public class EmployeeResource {
	private final Logger log = LoggerFactory.getLogger(EmployeeResource.class);

    @Autowired
    private EmployeeService employeeService;
    
	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapper = mapperFactory.getMapperFacade();

    @PostMapping("/employees")
    public String createOrUpdate(EmployeeDTO employeeDTO) {
    	log.debug("REST request to save Employee : {}", employeeDTO);

    	employeeService.save(mapper.map(employeeDTO, Employee.class));
        
        return "redirect:/employees";
    }

    /**
     * GET  /employees : get all the employees.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of employees in body
     */
    @GetMapping("/employees")
    public String getAll(Model model) {
        log.debug("REST request to get a page of Employees");
        List<Employee> employees = employeeService.findAll();
        
        model.addAttribute("employees", mapper.mapAsList(employees, EmployeeDTO.class));
        return "employees";
    }
    
    @GetMapping("/employees/add")
    public String createProduct(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "employee";
    }

    /**
     * GET  /employees/:id : get the "id" employee.
     *
     * @param id the id of the employeeDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the employeeDTO, or with status 404 (Not Found)
     */
    @GetMapping("/employees/{id}")
    public String getById(Model model, @PathVariable Long id) {
        log.debug("REST request to get Employee : {}", id);
        
        model.addAttribute("employee", employeeService.findOne(id));
        
        return "employee";
    }

    /**
     * DELETE  /employees/:id : delete the "id" employee.
     *
     * @param id the id of the employeeDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Long id) {
        log.debug("REST request to delete Employee : {}", id);
        employeeService.delete(id);
        
        return "redirect:/employees";
    }
}
