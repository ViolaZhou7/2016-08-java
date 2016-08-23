// File name: MyQueue.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: July, 2013
// Revised on: July 3, 2013

package dataCollections;

import exceptions.EmptyQueueException;
import exceptions.QueueException;
import interfaces.MyQueueInterface;
import interfaces.Queueable;

//Class description: this class implements the queue by using an array(copy MyQueue_Array class to here)
//                   there is another way by using a linked-list(you can copy  MyQueue_LL class to here)
//****************************************************************************************************************
//***********Please change the class name inside the codes after copied, before executing this program!***********
//****************************************************************************************************************
//Class invariants: none
//Preconditions: the front is theCollection[0], the back is the end of this array
//Postconditions: none

public class MyQueue implements MyQueueInterface{
	
	// static constants
		final static int INITIAL_SIZE_OF_COLLECTION = 25;  // To be used if no initial size is given

	    // data members
		//private Account[] theAccounts;  // collection of objects
		private Queueable[] theCollection;
		private int numberOfObjects;   // current number of objects
	    
		// method members
		
		// Default constructor
		public MyQueue( )
		{
		  this(INITIAL_SIZE_OF_COLLECTION);	
		}// end default constructor
		
		//parameter constructor
		public MyQueue(int numberOfObjects )
		{
			theCollection = new Queueable[ numberOfObjects ]; 
			numberOfObjects = 0;

		} // end parameter constructor

		/*
		 * Description: inserts an object into the queue which is at end of this array
		 */	
		@Override
		public void enqueue(Queueable otherObject) throws QueueException {
			int count = numberOfObjects;
			if (numberOfObjects < INITIAL_SIZE_OF_COLLECTION){
				theCollection[numberOfObjects] = otherObject;
			}else{
				Queueable[] newCollection = new Queueable[theCollection.length*2]; 
				
				for(int i=0; i < theCollection.length; i++)
					newCollection[i] = theCollection[i];
				
				newCollection[numberOfObjects] = otherObject;
				theCollection = newCollection;
			}
			numberOfObjects++;
			
			if (count == numberOfObjects)
				throw new QueueException("This operation is not successful!");			
			
		}

		/*
		 * Description: remove an object from the queue which is at the beginning of this array
		 */	
		@Override
		public Queueable dequeue() throws QueueException, EmptyQueueException {
			int count = numberOfObjects;
			Queueable anObject = null;
			if (numberOfObjects <= 0)
				throw new EmptyQueueException("There is no element in the queue!");
			else{
				anObject = theCollection[0];
				for (int i=0;i<numberOfObjects-1;i++)
					    theCollection[i] = theCollection[i+1]; // shift the elements one position backward
				numberOfObjects--;
				
				if (count == numberOfObjects)
					throw new QueueException("This operation is not successful!");
				
				return anObject;    
						
			}
		}

		/*
		 * Description: remove all the elements from the queue
		 */	
		@Override
		public void dequeueAll() {
			theCollection = new Queueable[theCollection.length];
			numberOfObjects = 0;
		}

		/*
		 * Description: retrieve an element from the queue(but do not remove) which is at the beginning of this array
		 */	
		@Override
		public Queueable peek() throws QueueException, EmptyQueueException {
			int count = numberOfObjects;
			if (numberOfObjects <= 0) 
				throw new EmptyQueueException("There is no element in the queue!");
			Queueable front;
			front = theCollection[0];
			count--;
			if (count == numberOfObjects)
				throw new QueueException("This operation is not successful!");
					
			return front;
		}

		/*
		 * Description: check if the queue is empty
		 */	
		@Override
		public boolean isEmpty() {
			if (numberOfObjects <= 0)
				return true;
			
			return false;
		}
		
		/*
		 * Description: return the number of elements in the queue
		 */	
		@Override
		public int size() {
			return numberOfObjects;
		}

}
