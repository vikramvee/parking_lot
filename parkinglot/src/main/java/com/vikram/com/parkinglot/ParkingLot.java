package com.vikram.com.parkinglot;

import java.util.ArrayList;

public class ParkingLot {
	
	private ArrayList<Lot> parkingLots;
	private int nextAvailableSlot = 0;
	
	public void ParkingLotParser(String instructionUnParsed) {
		String[] parsedInstruction = instructionUnParsed.split("");
		String instruction = parsedInstruction[0];
		switch (instruction) {
		case "create_parking_lot":
			CreateLots(Integer.parseInt(parsedInstruction[1]));
			break;
		case "park":
			ParkTheCar(parsedInstruction[1], parsedInstruction[2]);
			break;
			
		case "leave":
			unParkTheCar(Integer.parseInt(parsedInstruction[1]));
			break;
	
		case "status":
			
			break;
	
		case "registration_numbers_for_cars_with_colour":
			
			break;
	
		case "slot_numbers_for_cars_with_colour":
			
			break;
	
		case "slot_number_for_registration_number":
			
			break;

		default:
			break;
		}
		
	}
	
	public void CreateLots(int n) {
		parkingLots = new ArrayList<Lot>();
		
		for (int i = 0; i < n; i++) {
			parkingLots.add(new Lot());
		}
	}
	
	public int getParkingLotSize() {
		return parkingLots.size();
	}
	
	public ArrayList<Lot> getParkingLots(){
		return parkingLots;
	}
	
	public int getNextAvailableSlot() {
		nextAvailableSlot = nextAvailableSlot + 1;
		return nextAvailableSlot;
	}
	
	public String ParkTheCar(String registrationNumber, String Color) {
		if(!IsParkingFull()) {
			parkingLots.get(nextAvailableSlot).setCarColor(Color);
			parkingLots.get(nextAvailableSlot).setCarRegistration(registrationNumber);
			parkingLots.get(nextAvailableSlot).setIsOccupied(true);
			
			setNextAvailableSlot(nextAvailableSlot);
			
			return "Park the car at slot number " + nextAvailableSlot;
		}			
		else {
			return "Parking is full";
		}		
	}
	
	public void setNextAvailableSlot(int p_nextAvailableSlot) {
		
		while (parkingLots.get(p_nextAvailableSlot).getIsOccupied()) {
			nextAvailableSlot++;
			
			if(nextAvailableSlot > parkingLots.size() || !parkingLots.get(nextAvailableSlot).getIsOccupied())
				break;
		}
	}
	
	public void unParkTheCar(int slotNumber) {
		parkingLots.get(slotNumber - 1).setCarColor("");
		parkingLots.get(slotNumber - 1).setCarRegistration("");
		parkingLots.get(slotNumber - 1).setIsOccupied(false);
		
		nextAvailableSlot = slotNumber;		
	}
	
	public boolean IsParkingFull() {
		return !(nextAvailableSlot < parkingLots.size());		
	}
	
	
	
}
