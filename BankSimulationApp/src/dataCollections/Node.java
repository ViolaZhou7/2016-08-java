// File name: Node.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: June 2013
// Revised on: June 13, 2013

package dataCollections;

//Class Description: this node class defines a double linked model 

//Class Invariants:none

public class Node {
	// data members
	private Object element; 
	private Node next;
	private Node previous;

	// default constructor
	public Node() {
		this(null, null,null);
	} //end of default constructor
	
    // parameter constructor
	public Node(Object newElement){
      this(newElement, null, null);
	} // end of parameter constructor
	
	// parameter constructor
	public Node(Object newElement, Node nextNode, Node previousNode){
		element = newElement;
		next = nextNode;
		previous = previousNode;
	} // end of parameter constructor
    
	//setters
	public void setElement(Object newElement){
		element = newElement;		
	}
	
	public void setNext(Node nextNode){
		next = nextNode;
	}
	
	public void setPrevious(Node previousNode){
		previous = previousNode;
	}
	
	//getters
	public Object getElement(){
		return element;
	}
	
	public Node getNext(){
		return next;
	}
	
	public Node getPrevious(){
		return previous;
	}	
}
