package guru.springframework.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomer(UUID uuid) {
        return new CustomerDto().builder()
                .uuid(uuid)
                .name("random")
                .build();
    }

    @Override
    public CustomerDto save(CustomerDto customerDTO) {
         return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .build();
    }

    @Override
    public void update(UUID customerId, CustomerDto customerDTO) {
        //update
    }

    @Override
    public void delete(UUID customerId) {
        log.debug("Deleting a customer...");

    }
}
