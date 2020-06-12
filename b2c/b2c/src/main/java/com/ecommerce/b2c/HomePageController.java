package com.ecommerce.b2c;

import com.ecommerce.dao.entity.Customer;
import com.ecommerce.data.CustomerData;
import com.ecommerce.service.CustomerServiceImpl;
import com.ecommerce.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomePageController {

	@Autowired
	private CustomerServiceImpl customerService;

	@GetMapping("/")
	public String greeting(Model model) {
		Customer customer = customerService.getCurrentCustomer();
		boolean isLoggedIn = false;
		CustomerData customerData = new CustomerData();
		if (null != customer) {
			isLoggedIn = true;
			customerData.setFirstname(customer.getFirstname());
			customerData.setLastname(customer.getLastname());
		}
		model.addAttribute("customerName", customerData.getFirstname()
				+ " " + customerData.getLastname());
		model.addAttribute("isLoggedIn", isLoggedIn);
		return "homepage";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response,
						 Model model) {
		model.addAttribute("isLoggedIn", false);
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}

}