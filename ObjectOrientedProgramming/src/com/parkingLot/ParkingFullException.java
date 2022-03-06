package com.parkingLot;

public class ParkingFullException extends Exception {
	private static final long serialVersionUID = 1L;

	public ParkingFullException() {
		super();
	}

	public ParkingFullException(String message) {
		super(message);
	}

	public ParkingFullException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParkingFullException(Throwable cause) {
		super(cause);
	}

	protected ParkingFullException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
