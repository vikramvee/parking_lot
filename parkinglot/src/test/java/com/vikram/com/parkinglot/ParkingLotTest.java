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
	
}
