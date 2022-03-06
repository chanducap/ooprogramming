package com.parkingLot;

import java.util.HashMap;

import com.parkingLot.IConstants.ParkingSpotType;
import com.parkingLot.ParkingSpot.Compactspot;
import com.parkingLot.ParkingSpot.Electricspot;
import com.parkingLot.ParkingSpot.Handicappedspot;
import com.parkingLot.ParkingSpot.Largespot;
import com.parkingLot.ParkingSpot.MotorBikespot;

public class ParkingFloor {
	private String name;
	private HashMap<String, Handicappedspot> handicappedspot;
	private HashMap<String, Compactspot> compactspot;
	private HashMap<String, Largespot> largespot;
	private HashMap<String, MotorBikespot> motorBike;
	private HashMap<String, Electricspot> electricSpot;
	private ParkingDislayDashboard displayboard;

	public ParkingFloor(String name) {
		this.name = name;
	}

	public void addParkingspot(ParkingSpot spot) {
		switch (spot.getType()) {
		case HANDICAPPED:
			handicappedspot.put(spot.getNumber(), (Handicappedspot) spot);
			break;
		case COMPACT:
			compactspot.put(spot.getNumber(), (Compactspot) spot);
			break;
		case LARGE:
			largespot.put(spot.getNumber(), (Largespot) spot);
			break;
		case MOTORBIKE:
			motorBike.put(spot.getNumber(), (MotorBikespot) spot);
			break;
		case ELECTRIC:
			electricSpot.put(spot.getNumber(), (Electricspot) spot);
			break;
		default:
			System.out.println("wrong parking spot");

		}
	}

	public void assignVehicleSpot(Vehicle vehicle, ParkingSpot spot) {
		spot.assignVehicle(vehicle);
		switch (spot.getType()) {
		case HANDICAPPED:
			updateDisplayBoardForHandicapped(spot);
			break;
		case COMPACT:
			updateDisplayBoardForHandicapped(spot);
			break;
		case LARGE:
			updateDisplayBoardForHandicapped(spot);
			break;
		case MOTORBIKE:
			updateDisplayBoardForHandicapped(spot);
			break;
		case ELECTRIC:
			updateDisplayBoardForHandicapped(spot);
			break;
		default:
			System.out.println("wrong vehicle spot");

		}
	}

	private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
		if (this.displayboard.getHandicappedspot().getNumber() == spot.getNumber()) {
		    // find another free compact parking and assign to displayBoard ??? Not sure why it is written like this
			  for (String key : handicappedspot.keySet()) {
			        if (handicappedspot.get(key).isFree()) {
			          this.displayboard.setHandicappedspot(handicappedspot.get(key));
			        }
			      }
			      this.displayboard.showEmptySpotNumber();
		}

	}

	private void updateDisplayBoardForCompact(ParkingSpot spot) {
	    if (this.displayboard.getCompactspot().getNumber() == spot.getNumber()) {
	      // find another free compact parking and assign to displayBoard ??? Not sure below code	
	      for (String key : compactspot.keySet()) {
	        if (compactspot.get(key).isFree()) {
	          this.displayboard.setCompactspot(compactspot.get(key));
	        }
	      }
	      this.displayboard.showEmptySpotNumber();
	    }
	  }
	
	
	
}
