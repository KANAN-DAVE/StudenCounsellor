package com.tsv.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsv.implementation.dao.UserRepository;
import com.tsv.implementation.dto.UserLoginDTO;
import com.tsv.implementation.model.User;
import com.tsv.implementation.service.DefaultUserService;



@Controller

@RequestMapping("/login")
public class LoginController {
	@Autowired
	private DefaultUserService userService;

	@Autowired
	UserRepository userRepo;

    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }

	@GetMapping	//Redirect to login
	public String login()
	{
		return "login";
	}

	@PostMapping		//after submit will input will have mail and password
	public String loginUser(@ModelAttribute("user") UserLoginDTO userLoginDTO) {
		System.out.println("UserDTO" + userLoginDTO);
		userService.loadUserByUsername(userLoginDTO.getUsername());
		return "redirect:/dashboard";
	}
}
