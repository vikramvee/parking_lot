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
		
		assertEquals(5, parkingLot.GetParkingLots());
		
	}
	
	@Test
	public void ParkTheCar() {
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.CreateLots(5);
		
		assertEquals("Park the car at slot number 1", parkingLot.ParkTheCar("KA 03 MN 9502", "Grey"));
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
	
}