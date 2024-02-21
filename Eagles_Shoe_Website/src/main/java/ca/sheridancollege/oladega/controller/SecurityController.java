package ca.sheridancollege.oladega.controller;

import ca.sheridancollege.oladega.beans.User;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.oladega.repristory.SecurityReprisotory;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SecurityController {

	private SecurityReprisotory secRepo;
	@GetMapping("/login")
	public String loginPage()
	{
		return "loginPage.html";
	}
		
	@GetMapping("/accessDenied")
	public String accessDenied()
	{
		return "accessDenied.html";
	}
	
	@GetMapping("/home/registrationPage")
	public String registrationPage()
	{
		return "Registration.html";
	}
	
	@PostMapping("/register")
	public String processRegistrationPage(
			                             @RequestParam String firstname,
			                             @RequestParam String email,
										 @RequestParam String password,
										 Model model							 
			)
	{
		User checkUser = secRepo.findUserByEmail(email);
		if(checkUser != null)
		{
			model.addAttribute("annouce","This user already exist.");
			return "Registration.html";
		}
		else
		{
			
			secRepo.addNewUser(email,firstname, password);
				secRepo.assignUserRole(email, 2);
				System.out.println(email + firstname + password);
			return "redirect:/login";
			
		}
	}
}
