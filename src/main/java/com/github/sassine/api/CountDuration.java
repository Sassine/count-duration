package com.github.sassine.api;

import  static java.time.Duration.between;
import  static java.time.Instant.now;
import  static java.util.Optional.ofNullable;

import java.time.Instant;

public class CountDuration {

	private  Instant start;
	private  Instant stop;

	
	/** Method start time **/
	public CountDuration start() {
		start = now();
		return this;
	}
	
	/** Method stop time **/
	public  void stop() {
		stop = now();
	}
	
	/** Method Clear stop old time **/
	public  void clearStop() {
		stop = null;
	}
	
	/** Method start time and clear old stop time **/
	public  void restart() {
		start = now();
		stop = null;
	}

	/**
	 * Method result Between time start and now
	 * 
	 * @return long - Between time start and now or stopped count in Seconds
	 **/
	public  long betweenSeconds() {
		return between(start, getStopTime()).toSeconds();
	}

	/**
	 * Method result Between time start and now
	 * 
	 * @return long - Between time start and now or stopped count in Millis
	 **/
	public  long betweenMillis() {
		return between(start, getStopTime()).toMillis();
	}
	
	/**
	 * Method result Between time start and now
	 * 
	 * @return long - Between time start and now or stopped count in Minutes
	 **/
	public  long betweenMinutes() {
		return between(start, getStopTime()).toMinutes();
	}
	
	/**
	 * Method result Between time start and now
	 * 
	 * @return long - Between time start and now or stopped count in Hours
	 **/
	public  long betweenHours() {
		return between(start, getStopTime()).toHours();
	}
	
	private Instant getStopTime() {
		return ofNullable(stop).orElse(now());
	}
}
