// File name: event.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: July, 2013
// Revised on: July 3, 2013

package app;

import interfaces.Listable;
import interfaces.Queueable;

//Class description: this class gets the arrival time and process time of a transaction
//                   and determines the kind of an event
//Class invariants: none
//Preconditions: none
//Postconditions: none

public class event implements Listable, Queueable{

	private int arrivalTime; // the arrival time of one customer
	private int processTime; // the time used for a transaction of one customer
	private int kind;
	
	public event(int arrive, int process){
		arrivalTime = arrive;
		processTime = process;
	}
	
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	
	public int getProcessTime(){
		return processTime;
	}
	
	
	public void setKind(int kindOfEvent){
		kind = kindOfEvent;
	}
	
	public int getKind(){
		return kind;
	}
	
	public int compareTo(Listable anObject){
		event anEvent = (event) anObject;
		if (anEvent.getKind() == 0)
			return 0;
		else
			return 1;	
	}
}