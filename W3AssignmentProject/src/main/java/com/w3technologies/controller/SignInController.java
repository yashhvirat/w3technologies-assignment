package com.w3technologies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.w3technologies.model.Product;
import com.w3technologies.model.User;
import com.w3technologies.repository.ProductRepository;
import com.w3technologies.repository.UserRepository;

@Controller
public class SignInController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/signin")
	public String showSignInForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("error", null);
		return "signin";
	}

	@PostMapping("/signin")
	public String signIn(@RequestParam String email, @RequestParam String password,
			@RequestParam(defaultValue = "0") int pageNo, Model model) {
		User existingUser = userRepository.findByEmail(email);

		if (existingUser == null) {
			model.addAttribute("error", "Email not found. Please sign up.");
			model.addAttribute("showSignUpButton", true);
			return "signin";
		} else if (!existingUser.getPassword().equals(password)) {
			model.addAttribute("error", "Wrong password. Please check it.");
			return "signin";
		} 

		productRepository.save(new Product(1, "Redmi Mobile Phone", "2023/09/06", 1));
		productRepository.save(new Product(2, "Washing Machine", "2023/07/04", 1));
		productRepository.save(new Product(3, "Refrigrator", "2023/01/23", 1));
		productRepository.save(new Product(4, "Samsung Earphones", "2023/03/06", 2));
		productRepository.save(new Product(5, "USB Cables", "2023/03/02", 3));
		productRepository.save(new Product(6, "Samsung Mobile Phone", "2023/10/05", 1));
		productRepository.save(new Product(7, "Sony TV", "2023/07/29", 1));
		productRepository.save(new Product(8, "Speakers", "2023/01/16", 2));
		productRepository.save(new Product(9, "Home Theatre", "2023/05/07", 1));
		productRepository.save(new Product(10, "ASUS Laptop", "2022/12/05", 1));
		productRepository.save(new Product(11, "Curtains", "2022/02/07", 2));
		productRepository.save(new Product(12, "Shoes", "2022/10/10", 1));
		productRepository.save(new Product(13, "T-Shirts", "2023/11/16", 2));
		productRepository.save(new Product(14, "Bag", "2023/01/22", 1));
		productRepository.save(new Product(15, "Books", "2023/02/06", 4));
		productRepository.save(new Product(16, "Pillows", "2022/06/8", 4));
		productRepository.save(new Product(17, "Air Conditioner", "2023/04/11", 1));
		productRepository.save(new Product(18, "Suitcase", "2022/11/01", 1));
		productRepository.save(new Product(19, "Keyboard", "2023/01/01", 1));
		productRepository.save(new Product(20, "Mattress", "2022/9/9", 2));
		productRepository.save(new Product(21, "Utensils", "2023/10/07", 6));
		productRepository.save(new Product(22, "Pants", "2023/09/04", 4));
		productRepository.save(new Product(23, "Lights", "2023/01/23", 3));
		productRepository.save(new Product(24, "Ceiling Fan", "2023/10/05", 1));
		productRepository.save(new Product(25, "Helmet", "2023/10/05", 1));
		productRepository.save(new Product(26, "Plants", "2023/10/05", 4));
		productRepository.save(new Product(27, "Charger", "2023/07/29", 1));
		productRepository.save(new Product(28, "Painting", "2023/01/16", 2));
		productRepository.save(new Product(29, "Remote", "2023/05/07", 1));
		productRepository.save(new Product(30, "Dell Laptop", "2022/12/18", 1));

		return "redirect:/mainPage/1?sortField=id&sortDir=asc";
	}
}
