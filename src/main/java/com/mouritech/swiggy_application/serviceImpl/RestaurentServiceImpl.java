package com.mouritech.swiggy_application.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.swiggy_application.dto.RestaurentDto;
import com.mouritech.swiggy_application.entity.Restaurent;
import com.mouritech.swiggy_application.entity.User;
import com.mouritech.swiggy_application.repository.RestaurentRepository;
import com.mouritech.swiggy_application.service.RestaurentService;

@Service
public class RestaurentServiceImpl implements RestaurentService {
	@Autowired
	private RestaurentRepository restaurentRepository;

	@Override
	public void addToRestaurent(RestaurentDto restaurentDto, User users) {
		Restaurent restaurent = new Restaurent(restaurentDto.getRestaurentName(), restaurentDto.getRestaurentLocation(),
				users);
		restaurentRepository.save(restaurent);

	}

	@Override
	public List<Restaurent> listRestaurents() {
		return restaurentRepository.findAll();
	}

	@Override
	public Restaurent readRestaurent(String restaurentName) {
		return restaurentRepository.findByRestaurentName(restaurentName);
	}

	@Override
	public Optional<Restaurent> readRestaurent(long restaurentId) {
		return restaurentRepository.findById(restaurentId);
	}

	@Override
	public Restaurent getRestaurentByName(String restaurentName) {
		return restaurentRepository.findByRestaurentName(restaurentName);
	}

}
