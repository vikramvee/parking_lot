package com.vikram.com.parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.Assert;

public class ParkingLotTest {
	
	
	@Test
	public void CreateParkingLot() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(5);
		
		assertEquals(5, parkingLot.getParkingLotSize());
		
	}
	
	@Test
	public void ParkTheCar() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(5);
		
		assertEquals("Allocated slot number: 1", parkingLot.ParkTheCar("KA 03 MN 9502", "Grey"));
		assertEquals("Allocated slot number: 2", parkingLot.ParkTheCar("KA 03 MN 9503", "Grey"));
	}
	
	@Test
	public void IsParkingFull() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(3);
		
		parkingLot.ParkTheCar("KA 03 MN 9502", "Grey");
		parkingLot.ParkTheCar("KA 03 MN 9504", "Grey");
		parkingLot.ParkTheCar("KA 03 MN 9505", "Grey");
		
		assertEquals(true, parkingLot.IsParkingFull());
	}
	
	@Test
	public void nextAvailableSlot()
	{
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(5);
		
		parkingLot.ParkTheCar("KA 03 MN 9502", "Grey");
		parkingLot.ParkTheCar("KA 03 MN 9503", "Grey");
		
		assertEquals(3, parkingLot.getNextAvailableSlot());
		
		parkingLot.ParkTheCar("KA 03 MN 9503", "Grey");
		parkingLot.ParkTheCar("KA 03 MN 9503", "Grey");
		
		assertEquals(5, parkingLot.getNextAvailableSlot());
	}
	
	@Test
	public void unParkTheCar()
	{
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(5);
		
		parkingLot.ParkTheCar("KA 03 MN 9502", "White");
		parkingLot.ParkTheCar("KA 03 MN 9503", "Grey");	
		parkingLot.ParkTheCar("KA 03 MN 9504", "Grey");
		parkingLot.ParkTheCar("KA 03 MN 9505", "White");
		parkingLot.ParkTheCar("KA 03 MN 9506", "White");
		
		parkingLot.unParkTheCar(3);
		
		assertEquals(3, parkingLot.getNextAvailableSlot());
	}
	
	@Test
	public void getRegistratioNumberForCars() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(5);
		
		parkingLot.ParkTheCar("KA 03 MN 9502", "White");
		parkingLot.ParkTheCar("KA 03 MN 9503", "Grey");	
		parkingLot.ParkTheCar("KA 03 MN 9504", "Grey");
		parkingLot.ParkTheCar("KA 03 MN 9505", "White");
		parkingLot.ParkTheCar("KA 03 MN 9506", "White");
		
		parkingLot.unParkTheCar(5);
		
		parkingLot.ParkTheCar("KA 03 MN 9507", "Grey");
		
		assertEquals("KA 03 MN 9503, KA 03 MN 9504, KA 03 MN 9507", parkingLot.getRegistratioNumberForCars("Grey"));
	}
	
	@Test
	public void getSlotNumberForCarsWithColor() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(5);
		
		parkingLot.ParkTheCar("KA 03 MN 9502", "White");
		parkingLot.ParkTheCar("KA 03 MN 9503", "Grey");	
		parkingLot.ParkTheCar("KA 03 MN 9504", "Grey");
		parkingLot.ParkTheCar("KA 03 MN 9505", "White");
		parkingLot.ParkTheCar("KA 03 MN 9506", "White");
		
		parkingLot.unParkTheCar(5);
		
		parkingLot.ParkTheCar("KA 03 MN 9507", "Grey");
		
		assertEquals("1, 4", parkingLot.getSlotNumberForCarsWithColor("White"));
	}
	
	@Test
	public void getSlotNumberForRegistration() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(5);
		
		parkingLot.ParkTheCar("KA 03 MN 9502", "White");
		parkingLot.ParkTheCar("KA 03 MN 9503", "Grey");	
		parkingLot.ParkTheCar("KA 03 MN 9504", "Grey");
		parkingLot.ParkTheCar("KA 03 MN 9505", "White");
		parkingLot.ParkTheCar("KA 03 MN 9506", "White");
		
		parkingLot.unParkTheCar(5);
		
		parkingLot.ParkTheCar("KA 03 MN 9507", "Grey");
		
		assertEquals("5", parkingLot.getSlotNumberForRegistration("KA 03 MN 9507"));
	}
	
	@Test
	public void parkingLotParser() {
		ParkingLot parkingLot = new ParkingLot();
		//parkingLot.CreateLots(0);
		
		
		
		  assertEquals("Created a parking lot with 6 slots",
		  parkingLot.ParkingLotParser("create_parking_lot 6"));
		  assertEquals("Allocated slot number: 1",
		  parkingLot.ParkingLotParser("park KA-01-HH-1234 White"));
		  assertEquals("Allocated slot number: 2",
		  parkingLot.ParkingLotParser("park KA-01-HH-9999 White"));
		  assertEquals("Allocated slot number: 3",
		  parkingLot.ParkingLotParser("park KA-01-BB-0001 Black"));
		  assertEquals("Allocated slot number: 4",
		  parkingLot.ParkingLotParser("park KA-01-HH-7777 Red"));
		  assertEquals("Allocated slot number: 5",
		  parkingLot.ParkingLotParser("park KA-01-HH-2701 Blue"));
		  assertEquals("Allocated slot number: 6",
		  parkingLot.ParkingLotParser("park KA-01-HH-3141 Black"));
		  assertEquals("Slot number 4 is free",
		  parkingLot.ParkingLotParser("leave 4"));
		 
		 
		
		String Message = "Slot No.	Registration No		Colour" + System.lineSeparator();
		
		  Message = Message + "1	KA-01-HH-1234	White"+ System.lineSeparator();
		  Message = Message + "2	KA-01-HH-9999	White"+ System.lineSeparator();
		  Message = Message + "3	KA-01-BB-0001	Black"+ System.lineSeparator();
		  Message = Message + "5	KA-01-HH-2701	Blue"+ System.lineSeparator();
		  Message = Message + "6	KA-01-HH-3141	Black" +  System.lineSeparator();
		 
		 
			 
	    assertEquals(Message, parkingLot.Status());
	}
	
}
