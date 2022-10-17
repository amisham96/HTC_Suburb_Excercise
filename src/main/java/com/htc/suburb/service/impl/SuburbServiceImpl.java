package com.htc.suburb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.suburb.entity.Suburb;
import com.htc.suburb.entity.SuburbName;
import com.htc.suburb.repository.SuburbRepository;
import com.htc.suburb.service.SuburbService;

@Service
public class SuburbServiceImpl implements SuburbService {

	@Autowired
	SuburbRepository suburbRepository;

	@Override
	public List<Suburb> addsuburb(List<Suburb> suburb) {
		// TODO Auto-generated method stub
		return suburbRepository.saveAll(suburb);
	}

	@Override
	public List<Suburb> getSuburbWithPostcodeRange(long start, long end) {
		// TODO Auto-generated method stub
		List<Suburb> sorted_suburb = suburbRepository.findAll().stream()
				.filter(x -> x.getPostcode() >= start && x.getPostcode() <= end).sorted(new SuburbName()).toList();
		return sorted_suburb;
	}

}
