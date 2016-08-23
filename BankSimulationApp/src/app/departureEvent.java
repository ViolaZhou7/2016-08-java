// File name: departureEvent.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: July, 2013
// Revised on: July 3, 2013

package app;

//Class description: this event indicates the departure from the bank of a customer who has
//                   completed a transaction.
//Class invariants: none
//Preconditions: none
//Postconditions: none

import interfaces.*;

public class departureEvent extends event{	
	private int departureTime;
	// constructor
	public departureEvent(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
		super.setKind(1);
	} // end of constructor

	/* Description: this method gets the departure time
	 * 
	 */
	public int getDepartureTime(){
		return departureTime;
	}
	
	/*Description: this method sets the departure time which calculated in the BSA class
	 * 
	 */
	public void setDepartureTime(int departure){
		departureTime = departure;
	}
	
	/*Description: this method compares the departure time to the arrival time and sorts them
	 * 
	 */
	public int compareTo(Listable anObject){
    	event anEvent = (event) anObject;
    	arrivalEvent myEvent0;
    	departureEvent myEvent1;
    	if (anEvent.getKind() == 0){
    		myEvent0 = (arrivalEvent) anEvent;
    		if (myEvent0.getArrivalTime() == this.getDepartureTime())
    			return 0; // objects match
    		else if (myEvent0.getArrivalTime() < this.getDepartureTime())
    			return 1; // otherObject < this object
    		return -1; // otherObject > this object
    	}else{
    		myEvent1 = (departureEvent) anEvent;
    		if (myEvent1.getDepartureTime() == this.getDepartureTime())
    			return 0; // objects match
    		else if (myEvent1.getDepartureTime() < this. getDepartureTime())
    			return 1; // otherObject < this object
    		return -1; // otherObject > this object
    	}
    }
}