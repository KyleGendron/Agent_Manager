package com.voice.app.Agent_Manager.utils;

import java.util.Date;

import com.voice.app.Agent_Manager.util.interfaces.Range;

public class DateRange implements Range<Date>{
	private Date low, high;
	
	/**
	 * Default Constructor
	 */
	public DateRange(Date low, Date high){
		this.low = low;
		this.high = high;
	}
	
	@Override
	public Date getLow() {
		return low;
	}

	@Override
	public Date getHigh() {
		return high;
	}
}
