package com.htc.suburb.entity;

import java.util.Comparator;

public class SuburbName implements Comparator<Suburb> {

	@Override
	public int compare(Suburb o1, Suburb o2) {
		// TODO Auto-generated method stub
		return o1.getSuburbName().compareTo(o2.getSuburbName());
	}

}
