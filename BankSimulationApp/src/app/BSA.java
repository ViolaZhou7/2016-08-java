// File name: BSA.java
// Author: Yanping Zhou
// Std Number: 301215739
// Lab Number: D106
// Created on: July, 2013
// Revised on: July 3, 2013

package app;

import java.io.*;
import java.util.Scanner;
import dataCollections.*;
import exceptions.*;

//Class description: this class performs the simulation are to determine the times at which
//                   the events occur and to process the events when they do occur.
//Class invariants: none
//Preconditions: none
//Postconditions: none

public class BSA {
	private MyQueue bankQueue;
	private MyFlexibleList eventList;
	private arrivalEvent first;
	private int currentTime;
	private static double totalTime = 0;
	private static int numberOfCustomers = 0;
	

	/*Description: main method to start and end simulating
	 * 
	 */
	public static void main(String[] args) throws EmptyListException, QueueException, FileNotFoundException{
		BSA bankSimulate = new BSA();
		try {
			System.out.println("Simulation begins:");
			bankSimulate.simulate();
		} catch (EmptyQueueException e) {
			
			System.out.print(e);
		}
		
		System.out.println("The average waiting time is "+ totalTime/numberOfCustomers + ".");
		System.out.println("The number of custumers is " + numberOfCustomers + ".");
		System.out.println("Simulation ends.");
		
	}
	
	
	/*Description: this method calls the read input function and operates on the events;
	 *             (calculates the total waiting time)
	 */
	public void simulate() throws FileNotFoundException, EmptyQueueException, EmptyListException, QueueException{
		FileInputStream file = new FileInputStream(".\\src\\Input\\inputFile.txt");
		Scanner in = new Scanner(file);
		
		bankQueue = new MyQueue();
	    eventList = new MyFlexibleList();
	    
		first = readInput(in); // read the first element in the text file
		eventList.insert(first); // insert it into the flexible list
		while (eventList.size() != 0){
			event newEvent = eventList.retrieve();
			if (newEvent.getKind() == 0){ // 0 means arrival event, 1 means departure event
				processArrival(newEvent, in);
				numberOfCustomers++;
			}else{
                arrivalEvent temp = (arrivalEvent)bankQueue.peek();
				
				totalTime += currentTime - temp.getArrivalTime() - temp.getProcessTime();
				processDeparture(newEvent);
			}
			
		}		
	}
	
	
	/*Description: this method reads the input from the text file
	 * 
	 */
	public arrivalEvent readInput(Scanner in) {
		int myArrivalTime = in.nextInt();
		int myProcessTime = in.nextInt();
		currentTime = myArrivalTime;
		return new arrivalEvent(myArrivalTime, myProcessTime);
	}

	/*Description: this method gets the arrival event, out prints it and generates a departure event if 
	 *             there is no event in the queue before enqueue the current event; then reads the next input
	 */
	public void processArrival(event newEvent, Scanner in) throws QueueException, EmptyListException{
		int count = bankQueue.size();
		bankQueue.enqueue(newEvent);
		System.out.println("Processing an arrival event at time: " + newEvent.getArrivalTime());
		eventList.delete(); 
		
		if (count == 0){
			departureEvent temp = new departureEvent(newEvent.getArrivalTime(), newEvent.getProcessTime());		
			
			currentTime = temp.getArrivalTime() + temp.getProcessTime();
			temp.setDepartureTime(currentTime);
			eventList.insert(temp);
		}
		if (in.hasNextLine()){
			int myArrivalTime = in.nextInt();
			int myProcessTime = in.nextInt();
			arrivalEvent temp = new arrivalEvent(myArrivalTime, myProcessTime);
			eventList.insert(temp);
		}
		
	}
	
	/*Description: this methods out prints the departure event if there exists
	 * 
	 */
	public void processDeparture(event newEvent) throws QueueException, EmptyQueueException, EmptyListException{
		bankQueue.dequeue();
		eventList.delete();
		System.out.println("Processing a departure event at time: " + currentTime);
		if (bankQueue.size() != 0){
			event temp = (event)bankQueue.peek();
			departureEvent departureTemp = new departureEvent(temp.getArrivalTime(), temp.getProcessTime());
			currentTime += temp.getProcessTime();
			departureTemp.setDepartureTime(currentTime);
			eventList.insert(departureTemp);
		}
	}

}
