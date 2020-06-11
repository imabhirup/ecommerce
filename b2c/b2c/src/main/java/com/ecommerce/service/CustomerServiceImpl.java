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
    @Autowired
    private SessionService sessionService;
    public void save(final Customer customer) {
        customerRepository.save(customer);
    }

    public boolean isCustomerExist(String email) {
        return customerRepository.findByEmail(email).size() > 0;
    }

    public boolean isCustomerAuthenticated(String email, String pwd) {
        if (customerRepository.findByEmail(email).size() == 1) {
            Customer cust = customerRepository.findByEmail(email).stream().findFirst().get();
            if (cust.getPassword().equals(pwd)) {
                sessionService.getCurrentSession().setAttribute("customer", cust);
                return true;
            }
        }
        return false;
    }

    public Customer getCurrentCustomer() {
        return (Customer) sessionService.getCurrentSession().getAttribute("customer");
    }
}
