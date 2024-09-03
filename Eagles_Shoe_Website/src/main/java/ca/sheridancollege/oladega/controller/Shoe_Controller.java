package ca.sheridancollege.oladega.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.oladega.beans.Shoe;
import ca.sheridancollege.oladega.beans.User;
import ca.sheridancollege.oladega.beans.Address;
import ca.sheridancollege.oladega.beans.Order;
import ca.sheridancollege.oladega.repristory.SecurityReprisotory;
import ca.sheridancollege.oladega.repristory.ShoeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class Shoe_Controller {
	
	private ShoeRepository shoeRepo;
	private SecurityReprisotory secRepo;

	//Root Page
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
	public String getwishListPage(Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    List<Shoe> shoes = shoeRepo.getFavoritesByUserId(username);	
	    System.out.println(shoes);
	    model.addAttribute("username",username);
		model.addAttribute("shoes",shoes);
		return "wishList.html";
	}
	@GetMapping("/home/profilePage")
	public String getprofilePage(Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
		User user = secRepo.findUserByEmail(username);
		List <Address> address = new ArrayList<>();
		address = shoeRepo.getAddressesByEmail(username);
	    if(address != null)
	    {
		model.addAttribute("address",address.get(0));
	    }
		model.addAttribute("user" ,user);
		return "profilePage.html";
	}
	@GetMapping("/home/addressPage")
	public String getAddressPage(Model model)
	{
		
		List <Address> address = new ArrayList<>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
		address = shoeRepo.getAddressesByEmail(username);
	    model.addAttribute("addresses",address);
		return "address.html";
	}
	@PostMapping("/submitAddress")
	public String submitAddressPage(
			  
			@RequestParam String streetaddress,
            @RequestParam String unitno,
			@RequestParam String city,
			@RequestParam String province,
			@RequestParam String postalcode)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
		Address address = new Address(1,streetaddress+ " " +unitno,city, province, "Canada",postalcode.toUpperCase(),username);
		shoeRepo.addAddress(address);
		return "redirect:/home/addressPage";
	}
	@GetMapping("/home/orderHistory")
	public String getOrderHistoryPage(Model model)
	{
		List <Order> orders = new ArrayList<>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
		orders = shoeRepo.getOrdersByEmail(username);
	    model.addAttribute("orders",orders);
		return "orderHistory.html";
	}
	@GetMapping("/home/selectedShoe")
	public String getSelectedShoePage(Model model)
	{
		List<Shoe> shoes = shoeRepo.getAllAvailableShoes();	
		model.addAttribute("shoes",shoes);
		return "selectedShoe.html";
	}
	@GetMapping("/home/paymentPage")
	public String getpaymentPage()
	{
		return "paymentPage.html";
	}
	
	
	@GetMapping(value = {"/deleteAddress/{id}"})
    public String processDelete(@PathVariable int id, Model model)
    {
        Address address = shoeRepo.getAddressById(id);
        shoeRepo.deleteAddress(address);
        return "redirect:/home/addressPage";
    }
	
	
	
}
