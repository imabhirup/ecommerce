package com.ecommerce.service;

import com.ecommerce.dao.entity.Customer;
import com.ecommerce.dao.entity.CustomerRepository;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {
    @Autowired
    private CustomerRepository customerRepository;
    public void save(final Customer customer) {
        customerRepository.save(customer);
    }

    public boolean isCustomerExist(String email) {
        return customerRepository.findByEmail(email).size() > 0;
    }
}
