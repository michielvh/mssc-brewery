package guru.springframework.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import guru.springframework.msscbrewery.web.model.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO getCustomer(UUID uuid) {
        return new CustomerDTO().builder()
                .uuid(uuid)
                .name("random")
                .build();
    }
}
