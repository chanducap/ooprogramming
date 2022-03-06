package com.parkingLot;

public class Admin extends Account {

	public boolean addParkingFloor(ParkingFloor floor) {
		return true;
	}

	public boolean addParkingSpot(String floor, ParkingSpot spot) {
		return true;
	}

	public boolean removeParkingSpot(String floor, ParkingSpot spot) {
		return true;
	}

	public boolean addParkingDisplayBoard(String floor, ParkingSpot spot) {
		return true;
	}

	// public bool addEntrancePanel(EntrancePanel entrancePanel);
	// public bool addEntrancePanel(ExitPanel exitPanel);
	
}

