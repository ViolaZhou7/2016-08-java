// File name: QueueException.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: July 2013
// Revised on: July 3, 2013

package exceptions;

//Class Description: this exception is thrown when the operation is not successful

public class QueueException extends Exception
{
	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	// Default constructor
    public QueueException( ) 
    {
    } // end of constructor
    
    // Parameterized constructor
    public QueueException( String msg )
    {
    	// Question: where is msg stored? Check out Exception class in Java API
        super( msg );
        
    } // end of constructor
} // end of QueueException class
