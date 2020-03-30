package kg.megacom.demoauction.controllers;

import kg.megacom.demoauction.model.dto.CustomerDto;
import kg.megacom.demoauction.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }
    @GetMapping("/get")
    public List<CustomerDto>getCustomers(){
        return customerService.getCustomerList();
    }

}
