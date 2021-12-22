package com.mouritech.swiggy_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mouritech.swiggy_application.dto.ItemDto;
import com.mouritech.swiggy_application.dto.ItemDto2;
import com.mouritech.swiggy_application.dto.OfferDto;
import com.mouritech.swiggy_application.dto.OfferDto2;
import com.mouritech.swiggy_application.dto.RestaurentDto;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Offers;
import com.mouritech.swiggy_application.entity.Restaurent;
import com.mouritech.swiggy_application.entity.User;

@Service
public interface OfferService {
	Offers addToOffers(OfferDto offerDto, Restaurent restaurent);

	List<OfferDto2> listOfferRestaurants();

	//List<ItemDto2> readItems(String itemName);

	//Optional<Items> readItems(long itemId);

	//List<ItemDto2> getItemsByName(String itemName);

}
