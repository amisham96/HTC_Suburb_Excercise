package com.htc.suburb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.suburb.entity.Suburb;

@Service
public interface SuburbService {

	List<Suburb> addsuburb(List<Suburb> suburb);

	List<Suburb> getSuburbWithPostcodeRange(long start, long end);

}
