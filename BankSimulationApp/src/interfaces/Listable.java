// File name: Listable.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: May 2013
// Revised on: May 30, 2013

package interfaces;

public interface Listable {
	public String toString( );
	// Postcondition: concatenates the value of the object's 
	// data members into a string and return this string.
	public int compareTo( Listable otherObject );
	// Description: decides whether this object is equal to, > than or < than otherObject
	// Postcondition: returns 0 if both objects match (are equal)
	// returns 1 if this object > otherObject
	// returns -1 if this object < otherObject
}
