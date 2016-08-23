// File name: ZeroOrNegativeAmountOfMoneyException.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: May 2013
// Revised on: May 30, 2013

package exceptions;

// Class Description 
//   This exception is thrown when the amount of money to
//   be either deposited or withdrawn is 0.0 or negative

public class ZeroOrNegativeAmountOfMoneyException extends java.lang.Exception 
{  
    /**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	// Default constructor
    public ZeroOrNegativeAmountOfMoneyException( ) 
    {
    	// Question: why do we provide an empty default constructor?
    	
    } // end of constructor
    
    // Parameterized constructor
    public ZeroOrNegativeAmountOfMoneyException(String msg) 
    {
        super( msg );
        
    } // end of constructor

} // end of ZeroOrNegativeAmountOfMoneyException class