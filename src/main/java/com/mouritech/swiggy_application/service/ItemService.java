package com.mouritech.swiggy_application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mouritech.swiggy_application.dto.ItemDto;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Restaurent;

@Service
public interface ItemService {
	Items getItemsByItemName(String itemName);

	Items findById(long theId);

	void addItem(ItemDto itemDto, Restaurent restaurent);

	List<ItemDto> listItems();
}
