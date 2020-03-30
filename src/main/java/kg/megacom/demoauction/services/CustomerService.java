package kg.megacom.demoauction.services;

import kg.megacom.demoauction.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto saveCustomer(CustomerDto customerDto);
    List<CustomerDto> getCustomerList();
}
