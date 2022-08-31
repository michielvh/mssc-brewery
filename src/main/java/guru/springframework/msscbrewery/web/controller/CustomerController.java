package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sun.net.httpserver.Headers;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService service){
        this.customerService=service;
    }

    @GetMapping(path = "{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")UUID customerId){
        return new ResponseEntity<CustomerDto>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.save(customerDto);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Location","api/v1/customer/" +savedCustomer.getUuid().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDTO){
        customerService.update(customerId,customerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.delete(customerId);
    }
}
