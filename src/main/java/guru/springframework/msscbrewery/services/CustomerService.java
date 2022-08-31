package guru.springframework.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import guru.springframework.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

    public CustomerDto getCustomer(UUID uuid);

    CustomerDto save(CustomerDto customerDTO);

    void update(UUID customerId, CustomerDto customerDTO);

    void delete(UUID customerId);
}
