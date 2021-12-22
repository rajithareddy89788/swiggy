package com.mouritech.swiggy_application.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.swiggy_application.dto.ItemDto2;
import com.mouritech.swiggy_application.dto.RestaurentDto;
import com.mouritech.swiggy_application.dto.RestaurentDto2;
import com.mouritech.swiggy_application.entity.Restaurent;
import com.mouritech.swiggy_application.entity.User;
import com.mouritech.swiggy_application.repository.RestaurentRepository;
import com.mouritech.swiggy_application.service.RestaurentService;

@Service
public class RestaurentServiceImpl implements RestaurentService {
	@Autowired
	private RestaurentRepository restaurentRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public void addToRestaurent(RestaurentDto restaurentDto, User users) {
		Restaurent restaurent = new Restaurent(restaurentDto.getRestaurentName(), restaurentDto.getRestaurentLocation(),
				users);
		restaurentRepository.save(restaurent);

	}

	

	@Override
	public List<Restaurent> readRestaurent(String restaurentName) {
		return restaurentRepository.findByRestaurentName(restaurentName);
	}

	@Override
	public Optional<Restaurent> readRestaurent(long restaurentId) {
		return restaurentRepository.findById(restaurentId);
	}

	@Override
	public List<Restaurent> getRestaurentByName(String restaurentName) {
	
		return restaurentRepository.findByRestaurentName(restaurentName);
	}



	@Override
	public List<RestaurentDto2> listRestaurents() {
		return restaurentRepository.findAll().stream().map(post -> modelMapper.map(post, RestaurentDto2.class))
				.collect(Collectors.toList());
	}

}
