package com.htc.suburb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htc.suburb.config.ResponseHandler;
import com.htc.suburb.entity.Suburb;
import com.htc.suburb.exception.SuburbApplicationException;
import com.htc.suburb.service.SuburbService;

@RestController
@RequestMapping("/suburb")
public class SuburbController {

	@Autowired
	SuburbService suburbService;

	@PostMapping("/addsuburb")
	public List<Suburb> addSuburb(@RequestBody List<Suburb> suburb) throws SuburbApplicationException {
		return suburbService.addsuburb(suburb);
	}

	@GetMapping("/getsuburbswithpostcode")
	public ResponseEntity<Object> getSuburbWithPostcode(@RequestParam long startpostcoderange,
			@RequestParam long endpostcoderange) {
		List<Suburb> data = suburbService.getSuburbWithPostcodeRange(startpostcoderange, endpostcoderange);

		String str = "";
		for (Suburb list : data) {
			str += list.getSuburbName();
		}

		return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, data, str.length());
	}

}