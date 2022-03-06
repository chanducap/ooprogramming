package com.parkingLot;

import java.util.HashMap;

import com.parkingLot.IConstants.VehicleType;

public class Parkinglot {
	private String name;
	private Address address;
	// private ParkingRate rate;

	private int compactspotcount;
	private int largespotcount;
	private int motorbikespotcount;
	private int electricspotcount;
	private final int maxCompactSpotcount;
	private final int maxLargecount;
	private final int maxMotorbikecount;
	private final int maxElectriccount;

	// private HashMap<String,Entrancepanel> entrancePanels;
	// private HashMap<String,Exitpanel> exitPanels;
	private HashMap<String, ParkingFloor> parkingFloor;
	  // all active parking tickets, identified by their ticketNumber
	private HashMap<String, ParkingTicket> activeTicket;
	  // singleton ParkingLot to ensure only one object of ParkingLot in the system,
	  // all entrance panels will use this object to create new parking ticket: getNewParkingTicket(),
	  // similarly exit panels will also use this object to close parking tickets 
	private static Parkinglot parkinglot = null;
	  // private constructor to restrict for singleton
	private Parkinglot() {

		// 1. initialize variables: read name, address and parkingRate from database
		// 2. initialize parking floors: read the parking floor map from database,
		// this map should tell how many parking spots are there on each floor. This
		// should also initialize max spot counts too.
		// 3. initialize parking spot counts by reading all active tickets from database
		// 4. initialize entrance and exit panels: read from database

	}
	  // static method to get the singleton instance of ParkingLot
	public static Parkinglot getinstance() {
		if (parkinglot == null) {
			parkinglot = new Parkinglot();
		}
		return parkinglot;
	}
	// note that the following method is 'synchronized' to allow multiple entrances
	  // panels to issue a new parking ticket without interfering with each other
	public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
		// if(this.isFull())
		if (this.isFull(vehicle.getType())) {
			throw new ParkingFullException();
		}
		ParkingTicket ticket = new ParkingTicket();
		vehicle.assignTicket(ticket);
		// ticket.savetoDatabase();
		this.increaseParkingspot(vehicle.getType());
		activeTicket.put(ticket.getTicket(), ticket);
		return ticket;
	}

	public boolean isFull() {
		for (String key : parkingFloor.keySet()) {
			{
				if (!parkingFloor.get(key).isFull()) {
					return false;
				}
			}
			return true;
		}
	}

	public boolean isFull(VehicleType type) {
		 // trucks and vans can only be parked in LargeSpot
		if (type == VehicleType.TRUCK || type == VehicleType.VAN)
			return largespotcount >= maxLargecount;
			  // motorbikes can only be parked at motorbike spots
		if (type == VehicleType.MOTORBIKE)
			return motorbikespotcount >= maxMotorbikecount;
			 // cars can be parked at compact or large spots
		if (type == VehicleType.CAR)
			return (compactspotcount + largespotcount) >= (maxCompactSpotcount + maxLargecount);
		    // electric car can be parked at compact, large or electric spots
			return (compactspotcount + largespotcount + electricspotcount) >= (maxCompactSpotcount + maxLargecount
				+ maxElectriccount);
	}

	  // increment the parking spot count based on the vehicle type
	private boolean increaseParkingspot(VehicleType type) {
		if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
			largespotcount++;
		} else if (type == VehicleType.MOTORBIKE) {
			motorbikespotcount++;
		} else if (type == VehicleType.CAR) {
			if (compactspotcount < maxCompactSpotcount) {
				compactspotcount++;
			} else {
				largespotcount++;
			}
		} else if (type == VehicleType.ELECTRIC) {
			if (electricspotcount < maxElectriccount) {
				electricspotcount++;
			} else if (compactspotcount < maxCompactSpotcount) {
				compactspotcount++;
			} else {
				largespotcount++;
			}
		}
return true;
	}

}
