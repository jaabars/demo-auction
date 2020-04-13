package kg.megacom.demoauction.services.impl;

import kg.megacom.demoauction.database.CustomerRepository;
import kg.megacom.demoauction.mappers.ClassMapper;
import kg.megacom.demoauction.model.dto.CustomerDto;
import kg.megacom.demoauction.model.entity.Customer;
import kg.megacom.demoauction.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer= ClassMapper.INSTANCE.customerDtoToCustomerDto(customerDto);
        customer=customerRepository.save(customer);
        customerDto=ClassMapper.INSTANCE.customerToCustomerDto(customer);
        return customerDto;
    }

    @Override
    public List<CustomerDto> getCustomerList() {
        List<Customer>customerList=customerRepository.findAll();
        return ClassMapper.INSTANCE.customerListToCustomerDtoList(customerList);
    }
}
