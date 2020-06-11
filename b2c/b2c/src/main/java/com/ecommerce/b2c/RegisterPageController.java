package com.ecommerce.b2c;

import com.ecommerce.dao.entity.Customer;
import com.ecommerce.dao.entity.CustomerRepository;
import com.ecommerce.service.CustomerServiceImpl;
import main.java.com.ecommerce.form.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterPageController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("registerForm", new RegisterForm());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute RegisterForm registerForm, Model model) {
		if (customerServiceImpl.isCustomerExist(registerForm.getEmailId())) {
			model.addAttribute("error", "Customer exists with id " +registerForm.getEmailId() );
			model.addAttribute("registerForm", new RegisterForm());
			return "register";
		}
        Customer customer = new Customer(registerForm.getEmailId(), registerForm.getFirstName(),
				registerForm.getLastName(),
				registerForm.getPwd(), registerForm.getPhoneNumber());
		customerServiceImpl.save(customer);
		model.addAttribute("registerForm", new RegisterForm());
		return "register";
	}

}