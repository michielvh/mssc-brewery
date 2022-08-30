package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDTO;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService service){
        this.customerService=service;
    }

    @GetMapping(path = "{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId")UUID customerId){
        return new ResponseEntity<CustomerDTO>(customerService.getCustomer(customerId), HttpStatus.OK);
    }
}
