// File name: MyFlexibleList.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: May 2007
// Revised on: July 4th, 2013

package dataCollections;

import app.event;
import exceptions.ElementNotInListException;
import exceptions.EmptyListException;
import interfaces.Listable;
import interfaces.MyListInterface;
import dataCollections.Node;

//Class Description: this class implements MyListInterface
//                   it models a reference-based list
// Class Invariants: none 
// Preconditions: none
// Postconditions: none

public class MyFlexibleList implements MyListInterface{

    
	private int numberOfObjects;   // current number of objects
	
	//define a double headed linked list
    private Node head;
    private Node tail;
    
    // method members
	
	// Default constructor
	public MyFlexibleList( )
	{
	  head = null;
	  tail = null;
	  numberOfObjects = 0;
	}// end default constructor
	
	
	/*
	 * Description: returns the number of objects in the linked list
	 */	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfObjects;
	} // end of size method
	
	/*
	 * Description: Inserts an element into the linked list
	 */
	@Override
	public void insert(Listable otherObject){
		int compareToReturnValue;
		event anEvent = (event)otherObject;
		
		if(head == null && tail == null){
			Node newNode = new Node(otherObject, null, null);
			head = newNode;
			tail = newNode;
		}else{
			Listable theEvent = (Listable)head.getElement();
			compareToReturnValue = theEvent.compareTo(anEvent);
			if (compareToReturnValue == 0){
				if(anEvent.getKind() == 0){
					Node newNode = new Node(otherObject, head, null);
					head.setPrevious(newNode);
					head = newNode;
				}else{
					Node newNode = new Node(otherObject, null, head);
					head.setNext(newNode);
					tail = newNode;
				}
			}else if (compareToReturnValue == -1){ // theEvent < anEvent(otherObject)
				Node newNode = new Node(otherObject,null,head);
				head.setNext(newNode);
				tail = newNode;
			}else{ // theEvent > anEvent(otherObject)
				Node newNode = new Node(otherObject,head,null);
				head.setPrevious(newNode);
				head = newNode;
			}
				
		}
		numberOfObjects++; 
	
	} // end of insert method

	/*
	 * Description: This method finds and returns the desired element without deleting it
	 *              from the linked list
	 */
	@Override
	public Listable retrieve(Listable otherObject) throws EmptyListException, ElementNotInListException{
		// TODO Auto-generated method stub
		Listable anObject = null;
		Node aNode = head;
        
		if (numberOfObjects <= 0)
			// There are no elements - May be better to throw an exception
			//System.out.println("\nThere are no elements!\n");
			throw new EmptyListException("There is no element in the list!");
		else{
			// Search for the element. When found, display it and stop searching.
			while (aNode != null){
				if(otherObject.compareTo((Listable)aNode.getElement()) == 0){ // find the object
					System.out.println("Event found!\n" + aNode.getElement().toString());
					anObject = (Listable)aNode.getElement();
					break;	
				}	
				aNode = aNode.getNext();
			}
			if (aNode == null) //trace to the end of this linked list, element not found
				// If the element was not found - May be better to throw an exception
				//System.out.println("\nElement not found!\n");
				throw new ElementNotInListException("This element is not in the list!");
			
		}
		
		return anObject;
	} // end of retrieve method


	/*
	 * Description: This method finds and deletes the desired element
	 *              from the linked list
	 */
	@Override
	public void delete(Listable otherObject) throws EmptyListException, ElementNotInListException {
		// TODO Auto-generated method stub
		Node aNode = head;
		Node previousOfDeleted; //declare the object just before the deleted one
		Node nextOfDeleted; //declare the object just after the deleted one 
		  
		if (numberOfObjects <= 0)
			// There are no elements - May be better to throw an exception
			//System.out.println("\nThere are no elements!");
			throw new EmptyListException("There is no element in the list!");
		else {
			while (aNode != null){
				if (otherObject.compareTo((Listable)aNode.getElement()) == 0){ // find the object
					System.out.println("Event found!\n" + aNode.getElement().toString());
					System.out.println("Event to be deleted is:\n" + aNode.getElement().toString());
					previousOfDeleted = aNode.getPrevious();
					nextOfDeleted = aNode.getNext();
					
					if (previousOfDeleted != null && nextOfDeleted != null){
						previousOfDeleted.setNext(nextOfDeleted);
					    nextOfDeleted.setPrevious(previousOfDeleted);
					} else if (previousOfDeleted != null && nextOfDeleted == null){
						tail = previousOfDeleted;
						tail.setNext(null);
					} else if (previousOfDeleted == null && nextOfDeleted != null){
						head = nextOfDeleted;
						head.setPrevious(null);
					} else{
						head = null;
						tail = null;
					}
					numberOfObjects--;
					break;
				}
				
				aNode = aNode.getNext();
			}			
				
			if (aNode == null) //trace to the end of this linked list, account not found
				// If the element was not found - May be better to throw an exception
				//System.out.println("\nElement not found!\n");
				throw new ElementNotInListException("This element is not in the list!");
			
		}
		
		return;
	} // end of delete method

	/*
	 * Description: Transforms into a string all the objects in the linked list
	 * Postcondition: The string containing all the information is returned
	 */	
	public String toString( )
	{
		String theString = "";
		
		if ( numberOfObjects <= 0 )
			// No elements to display
			theString = "\nThere are no events!";        
		else {
			Node aNode = head;
			theString += "\nDisplaying all events:\n";
			while (aNode != null){
				theString += aNode.getElement()+"\n";
				aNode = aNode.getNext();
			}
			
		}

		return theString;

	} // end of toString method

	/*
	 * Description: This method deletes all the elements
	 *              from the linked list
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		head = null;
		tail = null;
		numberOfObjects =0;
	} // end of deleteAll method
	
	/*Description: always return the head from the linked list
	 * 
	 */
	public event retrieve() throws EmptyListException{
		if (numberOfObjects <= 0)
			throw new EmptyListException("There is no element in the list!");
		return (event)head.getElement();
	}

	public void delete() throws EmptyListException{
		if (numberOfObjects <= 0)
			throw new EmptyListException("There is no element in the list!");
		else if(numberOfObjects == 1){
			head = null;
			tail = null;
		}else{
			head=head.getNext();
			head.setPrevious(null);
		}
		numberOfObjects --;
	}
	
} // end of MyList class