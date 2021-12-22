package com.mouritech.swiggy_application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.swiggy_application.common.ApiResponse;
import com.mouritech.swiggy_application.dto.ItemDto;
import com.mouritech.swiggy_application.dto.ItemDto2;
import com.mouritech.swiggy_application.dto.OfferDto;
import com.mouritech.swiggy_application.dto.OfferDto2;
import com.mouritech.swiggy_application.dto.RestaurentDto;
import com.mouritech.swiggy_application.dto.RestaurentDto2;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Restaurent;
import com.mouritech.swiggy_application.entity.User;
import com.mouritech.swiggy_application.repository.UserRepository;
import com.mouritech.swiggy_application.service.ItemService;
import com.mouritech.swiggy_application.service.OfferService;
import com.mouritech.swiggy_application.service.RestaurentService;
import com.mouritech.swiggy_application.serviceImpl.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/auth")
@Api(value = "")
public class RestaurentController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private RestaurentService restaurentService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/addrestaurents")
	public ResponseEntity<ApiResponse> addToRestaurent(@RequestBody RestaurentDto restaurentDto) {

		User users = userService.getUserByEmail(restaurentDto.getUserEmail());
		// System.out.println("product to add"+ product.getName());
		restaurentService.addToRestaurent(restaurentDto, users);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

	}
	/*@PostMapping("/additems")
	public ResponseEntity<ApiResponse> addToItems(@RequestBody ItemDto itemDto) {

	List<Restaurent >restaurent	= restaurentService.getRestaurentByName(itemDto.getRestaurentName());
		// System.out.println("product to add"+ product.getName());
		itemService.addToItems(itemDto, restaurent);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

	}*/
	@GetMapping("/items/{restaurentName}")
	public ResponseEntity<List<Restaurent>>getRestaurentByName(
			@PathVariable(name = "restaurentName") String restaurentName) {
		List<Restaurent> body = restaurentService.getRestaurentByName(restaurentName);
		return new ResponseEntity<List<Restaurent>>(body, HttpStatus.OK);
	}
	@GetMapping("/restaurents/{itemName}")
	public ResponseEntity<List<ItemDto2>>getItemsByName(
			@PathVariable(name = "itemName") String itemName) {
		List<ItemDto2 >body = itemService.getItemsByName(itemName);
		return new ResponseEntity<List<ItemDto2>>(body, HttpStatus.OK);
	}

	@GetMapping("/restaurents")
	public List<RestaurentDto2> getRestaurents() {
		List<RestaurentDto2> restaurant = restaurentService.listRestaurents();

		return restaurant;
	}
	/*@GetMapping("/items")
	public List<ItemDto2> getItems() {
		List<ItemDto2> items = itemService.listItems();

		return items;
	}*/
	
	@PostMapping("/additems")
	public ResponseEntity<ApiResponse> addItems(@RequestBody ItemDto itemDto) {
		Optional<Restaurent> restaurants = restaurentService.readRestaurent(itemDto.getRestaurentId());
		if (!restaurants.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "restaurent is invalid"),
					HttpStatus.CONFLICT);
		}
		Restaurent restaurent = restaurants.get();
		itemService.addToItems(itemDto, restaurent);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been added"), HttpStatus.CREATED);
	}
	@PostMapping("/addoffer")
	public ResponseEntity<ApiResponse> addOffer(@RequestBody OfferDto offerDto) {
		Optional<Restaurent> restaurants = restaurentService.readRestaurent(offerDto.getRestaurentId());
		if (!restaurants.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "restaurent is invalid"),
					HttpStatus.CONFLICT);
		}
		Restaurent restaurent = restaurants.get();
		offerService.addToOffers(offerDto, restaurent);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "offer has been added"), HttpStatus.CREATED);
	}
	@GetMapping("/offers")
	public List<OfferDto2> getOfferRestaurants() {
		List<OfferDto2> offers = offerService.listOfferRestaurants();

		return offers;
	}
	

}
