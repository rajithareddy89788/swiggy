package com.mouritech.swiggy_application.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.swiggy_application.dto.ItemDto2;
import com.mouritech.swiggy_application.dto.OfferDto;
import com.mouritech.swiggy_application.dto.OfferDto2;
import com.mouritech.swiggy_application.entity.Offers;
import com.mouritech.swiggy_application.entity.Restaurent;

import com.mouritech.swiggy_application.repository.OfferRepository;

import com.mouritech.swiggy_application.service.OfferService;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferRepository offerRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Offers addToOffers(OfferDto offerDto, Restaurent restaurent) {

		Offers offerRequest = modelMapper.map(offerDto, Offers.class);
		Offers offers = offerRepository.save(offerRequest);

		OfferDto offerResponse = modelMapper.map(offers, OfferDto.class);
		Offers offers1 = new Offers(offerResponse, restaurent);
		return offers1;

	}

	@Override
	public List<OfferDto2> listOfferRestaurants() {
		return offerRepository.findAll().stream().map(post -> modelMapper.map(post, OfferDto2.class))
				.collect(Collectors.toList());
	}

}
