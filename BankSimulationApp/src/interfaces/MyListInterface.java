// File name: MyListInterface.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: May 2013
// Revised on: May 30, 2013

package interfaces;

import exceptions.ElementAlreadyInListException;
import exceptions.ElementNotInListException;
import exceptions.EmptyListException;

public interface MyListInterface {
	
	public int size();
    // size( ) : integer
 	// Description: Returns the number of elements currently stored in the list.
 	// Postcondition: Returns 0 if empty otherwise returns the number of elements.
    
    public void insert(Listable otherObject) throws ElementAlreadyInListException;
    // insert( element: Listable ) : void
 	// Description: Inserts an element into the list.
    // Precondition: "element" is not already in the list. This is to say: no duplication allowed.
 	// Postcondition: "element" has been added to the list.
 	// Exception: Throws an ElementAlreadyInListException if "element" is already in the list.
 	
	public void delete(Listable otherObject) throws EmptyListException, ElementNotInListException;
	// delete( element: Listable ) : void
	// Description: Deletes this element from the list.
	// Precondition: List is not empty.
	// Postcondition: If "element" is found in the list, it is deleted from the list. 
	//                If "element" is not found in the list, an exception is thrown.
	// Exception: Throws an EmptyListException if list is empty.
	// Exception: Throws an ElementNotInListException if "element" is not found in the list.
		
	public Listable retrieve(Listable otherObject) throws EmptyListException, ElementNotInListException;
	// retrieve( element: Listable ) : Listable
	// Description: Returns this element.
	// Precondition: List is not empty.
	// Postcondition: If "element" is found in the list, it is returned but not deleted from the list.
	//                If "element" is not found in the list, an exception is thrown.
	// Exception: Throws an EmptyListException if list is empty.
	// Exception: Throws an ElementNotInListException if "element" is not found in the list.
		
	public void deleteAll();
	// deleteAll( ) : void 
	// Description: Deletes all the elements from the list. 
	// Postcondition: List is empty.
		
	public String toString();
	// toString( ) : String
	// Description: Outputs all elements.
	// Postcondition: A string containing all elements (their information) is returned.
		
}
