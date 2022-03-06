package com.parkingLot;

import com.parkingLot.IConstants.VehicleType;

public abstract class Vehicle {
	private String licenseNumber;
	private final VehicleType type;
	private ParkingTicket ticket;

	public Vehicle(VehicleType type) {
		this.type = type;
	}

	public void assignTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}

	public class Car extends Vehicle {
		public Car() {
			super(VehicleType.CAR);
		}
	}

	public class Van extends Vehicle {
		public Van() {
			super(VehicleType.VAN);
		}
	}

	public class Truck extends Vehicle {
		public Truck() {
			super(VehicleType.TRUCK);
		}
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public ParkingTicket getTicket() {
		return ticket;
	}

	public void setTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}

	public VehicleType getType() {
		return type;
	}

}
