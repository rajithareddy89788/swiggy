package com.mouritech.swiggy_application.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.swiggy_application.dto.ItemDto;
import com.mouritech.swiggy_application.dto.ItemDto2;
import com.mouritech.swiggy_application.dto.RestaurentDto;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Restaurent;
import com.mouritech.swiggy_application.entity.User;
import com.mouritech.swiggy_application.exception.ResourceNotFoundException;
import com.mouritech.swiggy_application.repository.ItemsRepository;
import com.mouritech.swiggy_application.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsRepository itemsRepository;
	@Autowired
	private ModelMapper modelMapper;
	 public  Items findByName(String itemName) {
			
			Optional<Items> result=itemsRepository.findByItemNames(itemName);
		Items items=null;
			if(result.isPresent())
			{
			items=result.get();
			}
			else
			{
				throw new RuntimeException("Did not find product id-"+itemName);
			}
			return items;
		}
	@Override
	public List<ItemDto2> readItems(String itemName) {
		return itemsRepository.findByItemName(itemName);
	}

	@Override
	public Optional<Items> readItems(long itemId) {
		return itemsRepository.findById(itemId);
	}

	@Override
	public List<ItemDto2> getItemsByName(String itemName) {
		return itemsRepository.findByItemName(itemName);
	}

	/*
	 * @Override public void addToItems(ItemDto itemDto, Restaurent restaurent) {
	 * 
	 * Items items = new Items(itemDto.getItemName(), itemDto.getPrice(),
	 * restaurent); itemsRepository.save(items);
	 * 
	 * }
	 */
	@Override
	public Items addToItems(ItemDto itemDto, Restaurent restaurent) {

		Items itemRequest = modelMapper.map(itemDto, Items.class);
		Items items = itemsRepository.save(itemRequest);

		ItemDto itemResponse = modelMapper.map(items, ItemDto.class);
		Items items1 = new Items(itemResponse, restaurent);
		return items1;

	}

	@Override
	public List<ItemDto2> listItems() {
		return itemsRepository.findAll().stream().map(post -> modelMapper.map(post, ItemDto2.class))
				.collect(Collectors.toList());
	}

}
