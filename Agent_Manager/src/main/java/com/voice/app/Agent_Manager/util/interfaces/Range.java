package com.voice.app.Agent_Manager.util.interfaces;

public interface Range<T> {
	
	/**
	 * Return lower value in this range
	 * @return the lower value in this range
	 */
	public T getLow();
	
	/**
	 * Return higher value in this range
	 * @return the higher value in this range
	 */
	public T getHigh();
}
