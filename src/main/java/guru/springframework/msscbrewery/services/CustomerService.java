package guru.springframework.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import guru.springframework.msscbrewery.web.model.CustomerDTO;


public interface CustomerService {

    public CustomerDTO getCustomer(UUID uuid);
}
