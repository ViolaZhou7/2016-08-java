// File name: MyQueueInterface.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: July, 2013
// Revised on: July 3, 2013

package interfaces;

import exceptions.EmptyQueueException;
import exceptions.QueueException;

//class invariants: FIFO or LILO

public interface MyQueueInterface {
	public void enqueue( Queueable otherObject) throws QueueException;
	// enqueue( element: Queueable ) : void
	// Adds an element to the queue.
	// Throws QueueException when the operation is not successful, if needed!
	
	public Queueable dequeue( ) throws QueueException, EmptyQueueException;
	// dequeue( ) : Queueable
	// Removes an element from the queue. It also returns it.
	// Precondition: Queue is not empty.
	// Throws EmptyQueueException if queue is empty.
	// Throws QueueException when the operation is not successful, if needed!
	
	public void dequeueAll( );
	// dequeueAll( ) : void
	// Removes all elements from the queue.
	// Postcondition: isEmpty( ) returns true
	
	public Queueable peek( ) throws QueueException, EmptyQueueException;
	// peek( ) : Queueable
	// Retrieves an element from the queue and returns it.
	// Precondition: Queue is not empty.
	// Postcondition: the queue is unchanged.
	// Throws EmptyQueueException if queue is empty.
	// Throws QueueException when the operation is not successful, if needed!
	
	public boolean isEmpty( );
	// isEmpty( ) : boolean
	// Returns true if the queue is empty, otherwise returns false
	
	public String toString( );
	// toString( ) : String
	// Description: Returns the content of the Queue in a string.

	public int size();
	//size() : int
	//return the number of elements in the queue
}
