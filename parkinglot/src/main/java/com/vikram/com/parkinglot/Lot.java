package com.vikram.com.parkinglot;

public class Lot {
	private int lotNumber;
	private boolean isOccupied;
	private String carColor;
	private String carRegistration;
	
	public int getLotNumer()
    {
        return lotNumber;
    }

    public void setLotNumber(int propValue)
    {
    	lotNumber = propValue;
    }
    
    public boolean getIsOccupied() {
    	return isOccupied;
    }
    
    public void setIsOccupied(boolean propValue) {
    	isOccupied = propValue;
    }
    
    public String getCarColor() {
    	return carColor;
    }
    
    public void setCarColor(String propValue) {
    	carColor = propValue;
    }
    
    public String getCarRegistration() {
    	return carRegistration;
    }
    
    public void setCarRegistration(String propValue) {
    	carRegistration = propValue;
    }
    
}
