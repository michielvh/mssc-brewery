package guru.springframework.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO getCustomer(UUID uuid) {
        return new CustomerDTO().builder()
                .uuid(uuid)
                .name("random")
                .build();
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
         return CustomerDTO.builder()
                .uuid(UUID.randomUUID())
                .build();
    }

    @Override
    public void update(UUID customerId, CustomerDTO customerDTO) {
        //update
    }

    @Override
    public void delete(UUID customerId) {
        log.debug("Deleting a customer...");

    }
}
