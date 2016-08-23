// File name: arrivalEvent.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: July, 2013
// Revised on: July 3, 2013

package app;

//Class description: this event indicates the arrival at the bank of a new customer
//                   if the teller is idle  when the customer arrives, the customer
//                   enters the line and begins the transaction immediately; otherwise,
//                   the new customer must stand at the end of the line and wait for service.
//Class invariants: none
//Preconditions: none
//Postconditions: none

import interfaces.*;

public class arrivalEvent extends event{

	// constructor
	public arrivalEvent(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
		super.setKind(0);
	} // end of constructor
	
	/*Description: this method compares the arrival time of two events
	 * 
	 */
    public int compareTo(Listable anObject){
    	event anEvent = (event) anObject;
    	arrivalEvent myEvent0;
    	departureEvent myEvent1;
    	if (anEvent.getKind() == 0){
    		myEvent0 = (arrivalEvent) anEvent;
    		if (myEvent0.getArrivalTime() == this.getArrivalTime())
    			return 0; // objects match
    		else if (myEvent0.getArrivalTime() < this.getArrivalTime())
    			return 1; // otherObject < this object
    		return -1; // otherObject > this object
    	}else{
    		myEvent1 = (departureEvent) anEvent;
    		if (myEvent1.getDepartureTime() == this.getArrivalTime())
    			return 0; // objects match
    		else if (myEvent1.getDepartureTime() < this. getArrivalTime())
    			return 1; // otherObject < this object
    		return -1; // otherObject > this object
    	}
    }
}
