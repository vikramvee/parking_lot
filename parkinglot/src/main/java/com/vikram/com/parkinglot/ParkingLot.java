package com.vikram.com.parkinglot;

import java.util.ArrayList;

public class ParkingLot {
	
	private ArrayList<Lot> parkingLots;
	private int nextAvailableSlot = 0;
	
	public void CreateLots(int n) {
		parkingLots = new ArrayList<Lot>();
		
		for (int i = 0; i < n; i++) {
			parkingLots.add(new Lot());
		}
	}
	
	public int GetParkingLots() {
		return parkingLots.size();
	}
	
	public String ParkTheCar(String registrationNumber, String Color) {
		if(!IsParkingFull()) {
			parkingLots.get(nextAvailableSlot).setCarColor(Color);
			parkingLots.get(nextAvailableSlot).setCarRegistration(registrationNumber);
			parkingLots.get(nextAvailableSlot).setIsOccupied(true);
			nextAvailableSlot++;
			
			return "Park the car at slot number " + nextAvailableSlot;
		}			
		else {
			return "Parking is full";
		}		
	}
	
	public boolean IsParkingFull() {
		return !(nextAvailableSlot < parkingLots.size());		
	}
	
	
	
}
