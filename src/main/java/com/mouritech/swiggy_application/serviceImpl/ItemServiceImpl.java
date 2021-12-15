package com.mouritech.swiggy_application.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.swiggy_application.dto.ItemDto;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Restaurent;
import com.mouritech.swiggy_application.exception.ResourceNotFoundException;
import com.mouritech.swiggy_application.repository.ItemsRepository;
import com.mouritech.swiggy_application.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public Items getItemsByItemName(String itemName) {
		Optional<Items> result = itemsRepository.findByItemName(itemName);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new ResourceNotFoundException("item name not found.");
		}
		// return result.isPresent() ? result.get() : throw new
		// ResourceNotFoundException("item name not found.");

	}

	@Override
	public Items findById(long theId) {
		Optional<Items> result = itemsRepository.findById(theId);
		Items items = null;
		if (result.isPresent()) {
			items = result.get();
		} else {
			throw new RuntimeException("Did not find product id-" + theId);
		}
		return items;
	}

	@Override
	public void addItem(ItemDto itemDto, Restaurent restaurent) {
		Items items = getItemFromDto(itemDto, restaurent);
		itemsRepository.save(items);

	}

	public static ItemDto getDtoFromItem(Items items) {
		ItemDto itemDto = new ItemDto(items);
		return itemDto;
	}

	public Items getItemFromDto(ItemDto itemDto, Restaurent restaurent) {
		Items items = new Items(itemDto, restaurent);
		return items;
	}

	@Override
	public List<ItemDto> listItems() {
		List<Items> items1 = itemsRepository.findAll();
		List<ItemDto> itemDtos = new ArrayList<>();
		/*
		 * for(Items items : items1) { ItemDto itemDto = getDtoFromItem(items);
		 * itemDtos.add(itemDto); }
		 */
		items1.forEach(item -> itemDtos.add(getDtoFromItem(item)));
		return itemDtos;
	}
}
