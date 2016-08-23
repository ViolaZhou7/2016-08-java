// File name: EmptyListException.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: May 2013
// Revised on: May 30, 2013

package exceptions;

//Class Description 
//This exception is thrown when the list is empty

public class EmptyListException extends Exception
{
	 /**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	// Default constructor
    public EmptyListException( ) 
    {
    } // end of constructor
    
    // Parameterized constructor
    public EmptyListException( String msg )
    {
    	// Question: where is msg stored? Check out Exception class in Java API
        super( msg );
        
    } // end of constructor
} // end of EmptyListException class 
