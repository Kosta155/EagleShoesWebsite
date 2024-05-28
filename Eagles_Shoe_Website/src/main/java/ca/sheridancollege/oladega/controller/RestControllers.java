package ca.sheridancollege.oladega.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.oladega.beans.Shoe;
import ca.sheridancollege.oladega.repristory.ShoeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class RestControllers {

	
	private ShoeRepository shoeRepo;

	 @PostMapping("/addFavourite")
	    public String handleAjaxRequest(@RequestParam String shoeName) {
	        // Process the data received from the client
	        System.out.println("Received shoeName: " + shoeName);
	        // Return a response if needed
	        return "Data received successfully";
	    }
	 
	 
	 @PostMapping("/favorites/save")
	 public ResponseEntity<Void> saveFavorites(@RequestBody List<Shoe> favoriteShoes) {
		 
		 System.out.println("Saving" + favoriteShoes);
		 List<Integer> favoriteShoeIds = new ArrayList<>();
	        for (Shoe shoe : favoriteShoes) {
	            favoriteShoeIds.add(shoe.getShoeId());
	        }

		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  String username = authentication.getName();
          shoeRepo.saveFavoritesForUser(username, favoriteShoeIds);
          return ResponseEntity.ok().build();
          }
	 
	 @PostMapping("/favorites/saveEmpty")
	 public ResponseEntity<Void> saveFavoritesEmpty() {
		 
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  String username = authentication.getName();
          shoeRepo.emptyFavoritesForUser(username);
          return ResponseEntity.ok().build();
          }
	 
	 @GetMapping("/getFavorites")
	    public ResponseEntity<List<Shoe>> getFavorites() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    String username = authentication.getName();
	        List<Shoe> favorites = shoeRepo.getFavoritesByUserId(username);
	        return ResponseEntity.ok(favorites);
	    }
	 
	    
   
}