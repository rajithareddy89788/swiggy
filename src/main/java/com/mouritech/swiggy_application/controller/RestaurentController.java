package com.mouritech.swiggy_application.controller;

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
import com.mouritech.swiggy_application.dto.RestaurentDto;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Restaurent;
import com.mouritech.swiggy_application.entity.User;
import com.mouritech.swiggy_application.repository.UserRepository;
import com.mouritech.swiggy_application.service.ItemService;
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

	@GetMapping("/getitems/{restaurentName}")
	public ResponseEntity<Restaurent> getRestaurentByName(
			@PathVariable(name = "restaurentName") String restaurentName) {
		Restaurent body = restaurentService.getRestaurentByName(restaurentName);
		return new ResponseEntity<Restaurent>(body, HttpStatus.OK);
	}

	@GetMapping("/items/{itemName}")
	public Items getItemsDetailsByName(@PathVariable String itemName) {
		Items items = itemService.getItemsByItemName(itemName);

		return items;
	}

	@PostMapping("/additems")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody ItemDto itemDto) {
		Optional<Restaurent> optionalCategory = restaurentService.readRestaurent(itemDto.getRestaurentId());
		if (!optionalCategory.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "restaurent is invalid"),
					HttpStatus.CONFLICT);
		}
		Restaurent restaurent = optionalCategory.get();
		itemService.addItem(itemDto, restaurent);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been added"), HttpStatus.CREATED);
	}

}
