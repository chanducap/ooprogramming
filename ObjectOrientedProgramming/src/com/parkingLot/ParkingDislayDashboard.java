package com.parkingLot;

import com.parkingLot.ParkingSpot.Compactspot;
import com.parkingLot.ParkingSpot.Electricspot;
import com.parkingLot.ParkingSpot.Handicappedspot;
import com.parkingLot.ParkingSpot.Largespot;
import com.parkingLot.ParkingSpot.MotorBikespot;

public class ParkingDislayDashboard {
	private String id;
	private Handicappedspot handicappedspot;
	private Compactspot compactspot;
	private Largespot largespot;
	private MotorBikespot motorbikespot;
	private Electricspot electricSpot;

	public void showEmptySpotNumber() {
		String message = "";
		if (handicappedspot.Isfree()) {
			message += "Free Handicapped: " + handicappedspot.getNumber();
		} else {
			message += "Handicapped is full";
		}
		message += System.lineSeparator();

		if (compactspot.Isfree()) {
			message += "Free compactspot: " + compactspot.getNumber();
		} else {
			message += "compactspot is full";
		}
		message += System.lineSeparator();

		if (largespot.isFree()) {
			message += "Free largespot " + largespot.getNumber();
		} else {
			message += "largespot is full";
		}
		message += System.lineSeparator();
		if (motorbikespot.isFree()) {
			message += "Free motorbikespot " + motorbikespot.getNumber();
		} else {
			message += "motorbikespot is full";
		}
		message += System.lineSeparator();

		if (electricSpot.isFree()) {
			message += "Free electricSpot " + electricSpot.getNumber();
		} else {
			message += "electricSpot is full";
		}
		message += System.lineSeparator();

	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Handicappedspot getHandicappedspot() {
		return handicappedspot;
	}

	public void setHandicappedspot(Handicappedspot handicappedspot) {
		this.handicappedspot = handicappedspot;
	}

	public Compactspot getCompactspot() {
		return compactspot;
	}

	public void setCompactspot(Compactspot compactspot) {
		this.compactspot = compactspot;
	}

	public Largespot getLargespot() {
		return largespot;
	}

	public void setLargespot(Largespot largespot) {
		this.largespot = largespot;
	}

	public MotorBikespot getMotorbikespot() {
		return motorbikespot;
	}

	public void setMotorbikespot(MotorBikespot motorbikespot) {
		this.motorbikespot = motorbikespot;
	}

	public Electricspot getElectricSpot() {
		return electricSpot;
	}

	public void setElectricSpot(Electricspot electricSpot) {
		this.electricSpot = electricSpot;
	}


}
