package com.parkingLot;

public interface IConstants {

	public enum VehicleType{
		CAR,TRUCK,VAN,ELECTRIC,MOTORBIKE;
	}
	public enum AccountStatus{
		ACTIVE,BLOCKED,BANNED,NOACTIVITY;
	}
	public enum ParkingTicketStatus{
		ACTIVE,PAID,LOST;
	}
	
	public enum ParkingSpotType{
		 HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC;
	}
	
	
}
