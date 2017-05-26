package com.voice.app.Agent_Manager.utils;

import com.voice.app.Agent_Manager.util.interfaces.Range;

public class DoubleRange implements Range<Double>{
	private Double low;
	private Double high;
	
	/**
	 * Default Constructor
	 * @param low the lower value in this range
	 * @param high this higher value in this range
	 */
	public DoubleRange(Double low, Double high){
		this.low = low;
		this.high = high;
	}

	@Override
	public Double getLow() {
		return low;
	}

	@Override
	public Double getHigh() {
		return high;
	}

}
