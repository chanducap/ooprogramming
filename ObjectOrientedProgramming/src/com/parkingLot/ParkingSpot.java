package com.parkingLot;

import com.parkingLot.IConstants.ParkingSpotType;
import com.parkingLot.IConstants.VehicleType;

public abstract class ParkingSpot {
	private String number;
	private boolean free;
	private Vehicle vehicle;
	private final ParkingSpotType type;

	public boolean Isfree() {
		return true;
	}

	public ParkingSpot(ParkingSpotType type) {
		this.type = type;
	}

	public boolean assignVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		free = false;
		return true;
	}

	public boolean removevehicle() {
		this.vehicle = null;
		free = true;
		return true;
	}

	public class Handicappedspot extends ParkingSpot {
		public Handicappedspot() {
			super(ParkingSpotType.HANDICAPPED);

		}
	}

	public class Compactspot extends ParkingSpot {
		public Compactspot() {
			super(ParkingSpotType.COMPACT);

		}
	}

	public class Largespot extends ParkingSpot {
		public Largespot() {
			super(ParkingSpotType.LARGE);

		}
	}

	public class MotorBikespot extends ParkingSpot {
		public MotorBikespot() {
			super(ParkingSpotType.MOTORBIKE);

		}
	}

	public class Electricspot extends ParkingSpot {
		public Electricspot() {
			super(ParkingSpotType.ELECTRIC);

		}
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpotType getType() {
		return type;
	}

}
