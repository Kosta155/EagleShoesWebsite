package ca.sheridancollege.oladega.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {

	 @PostMapping("/addFavourite")
	    public String handleAjaxRequest(@RequestParam String shoeName) {
	        // Process the data received from the client
	        System.out.println("Received shoeName: " + shoeName);
	        // Return a response if needed
	        return "Data received successfully";
	    }
	    
    
}