package ca.sheridancollege.oladega.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.oladega.beans.Shoe;
import ca.sheridancollege.oladega.repristory.ShoeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class Shoe_Controller {
	
	private ShoeRepository shoeRepo;
	
	@GetMapping("/")
	public String getRootPage(Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    List<Shoe> shoes = shoeRepo.getAllAvailableShoes();	
	    model.addAttribute("username",username);
		model.addAttribute("shoes",shoes);
		return "index.html";
	}
	@GetMapping("/home/cartPage")
	public String getCartPage()
	{
		return "cart.html";
	}
	@GetMapping("/home/wishListPage")
	public String getwishListPage()
	{
		return "wishList.html";
	}
	@GetMapping("/home/profilePage")
	public String getprofilePage()
	{
		return "profilePage.html";
	}
	@GetMapping("/home/addressPage")
	public String getAddressPage()
	{
		return "address.html";
	}
	@GetMapping("/home/orderHistory")
	public String getOrderHistoryPage()
	{
		return "orderHistory.html";
	}
	@GetMapping("/home/paymentPage")
	public String getpaymentPage()
	{
		return "paymentPage.html";
	}
	
	
}
