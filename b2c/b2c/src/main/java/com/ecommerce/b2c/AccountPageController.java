package com.ecommerce.b2c;

import com.ecommerce.dao.entity.Customer;
import com.ecommerce.dao.entity.CustomerRepository;
import com.ecommerce.form.LoginForm;
import com.ecommerce.service.CustomerServiceImpl;
import com.ecommerce.service.SessionService;
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
public class AccountPageController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

	@GetMapping("/create-account")
	public String register(Model model) {
		model.addAttribute("registerForm", new RegisterForm());
		model.addAttribute("loginForm", new LoginForm());
		return "createaccount";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute LoginForm loginForm, Model model) {
		if (customerServiceImpl.isCustomerAuthenticated(loginForm.getEmail(),
				loginForm.getPwd())) {
			return "redirect:/";
		}
		model.addAttribute("error", "Email Id or Password is incorrect" );
		model.addAttribute("registerForm", new RegisterForm());
		model.addAttribute("loginForm", new LoginForm());
		return "createaccount";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute RegisterForm registerForm, Model model) {
		model.addAttribute("loginForm", new LoginForm());
		if (customerServiceImpl.isCustomerExist(registerForm.getEmailId())) {
			model.addAttribute("error", "Customer exists with id " +registerForm.getEmailId() );
			model.addAttribute("registerForm", new RegisterForm());
			return "createaccount";
		}
        Customer customer = new Customer(registerForm.getEmailId(), registerForm.getFirstName(),
				registerForm.getLastName(),
				registerForm.getPwd(), registerForm.getPhoneNumber());
		customerServiceImpl.save(customer);
		model.addAttribute("registerForm", new RegisterForm());
		model.addAttribute("successMsg", "Customer Registered successfully with id "
				+ registerForm.getEmailId() );
		return "createaccount";
	}

}