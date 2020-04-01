package com.vikram.com.parkinglot;

import java.util.ArrayList;

public class ParkingLot {
	
	private ArrayList<Lot> parkingLots;
	private int nextAvailableSlot = 1;
	
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
			Status();
			break;
	
		case "registration_numbers_for_cars_with_colour":
			getRegistratioNumberForCars(parsedInstruction[1]);
			break;
	
		case "slot_numbers_for_cars_with_colour":
			getSlotNumberForCarsWithColor(parsedInstruction[1]);
			break;
	
		case "slot_number_for_registration_number":
			getSlotNumberForRegistration(parsedInstruction[1]);
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
		
		System.out.println("Created a parking lot with " + n + " slots");
	}
	
	public int getParkingLotSize() {
		return parkingLots.size();
	}
	
	public ArrayList<Lot> getParkingLots(){
		return parkingLots;
	}
	
	public int getNextAvailableSlot() {	
		return nextAvailableSlot;
	}
	
	public String ParkTheCar(String registrationNumber, String Color) {
		String message = "";
		
		if(!IsParkingFull()) {
			parkingLots.get(nextAvailableSlot - 1).setCarColor(Color);
			parkingLots.get(nextAvailableSlot - 1).setCarRegistration(registrationNumber);
			parkingLots.get(nextAvailableSlot - 1).setIsOccupied(true);
			parkingLots.get(nextAvailableSlot - 1).setLotNumber(nextAvailableSlot);
			
			setNextAvailableSlot(nextAvailableSlot);
			
			message = "Allocated slot number: " + (nextAvailableSlot - 1);
			System.out.println(message);
			
			return message;
		}			
		else {
			return "Parking is full";
		}		
	}
	
	public void setNextAvailableSlot(int p_nextAvailableSlot) {
		
		while (parkingLots.get(p_nextAvailableSlot - 1).getIsOccupied()) {
			nextAvailableSlot++;
			
			if(nextAvailableSlot > parkingLots.size() || !parkingLots.get(nextAvailableSlot - 1).getIsOccupied())
				break;
		}
	}
	
	public void unParkTheCar(int slotNumber) {
		parkingLots.get(slotNumber - 1).setCarColor("");
		parkingLots.get(slotNumber - 1).setCarRegistration("");
		parkingLots.get(slotNumber - 1).setIsOccupied(false);
		
		nextAvailableSlot = slotNumber;	
		
		System.out.println("Slot number "+ nextAvailableSlot +" is free");
	}
	
	public boolean IsParkingFull() {
		return !(nextAvailableSlot <= parkingLots.size());		
	}
	
	public void Status() {
		System.out.println("Slot No.	Registration No		Color");
		
		for (Lot lot : parkingLots) {
			System.out.println(lot.getLotNumer() +" 	" + lot.getCarRegistration() +"		"+ lot.getCarColor() );
		}
	}
	
	public String getRegistratioNumberForCars(String color) {
		String carsRegistrationNumber = "";
		
		for (Lot lot : parkingLots) {
			if(lot.getCarColor() ==  color)
				carsRegistrationNumber = carsRegistrationNumber + ", " + lot.getCarRegistration();
		}
		System.out.println(carsRegistrationNumber.substring(1).trim());
		
		return carsRegistrationNumber.substring(1).trim();
	}
	
	public String getSlotNumberForCarsWithColor(String color) {
		String slotNumber = "";
		
		for (Lot lot : parkingLots) {
			if(lot.getCarColor() ==  color)
				slotNumber = slotNumber + ", " + lot.getLotNumer();
		}
		System.out.println(slotNumber.substring(1).trim());
		
		return slotNumber.substring(1).trim();
	}
	
	public String getSlotNumberForRegistration(String registrationNumber) {
		String slotNumber = "";
		
		for (Lot lot : parkingLots) {
			if(lot.getCarRegistration() ==  registrationNumber)
				slotNumber = slotNumber + ", " + lot.getLotNumer();
		}
		System.out.println(slotNumber.substring(1).trim());
		
		return slotNumber.substring(1).trim();
	}
	
}
