package com.vikram.com.parkinglot;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void readInputFile() {
    	assertEquals(15, App.readInputFromFile("/home/adam/Desktop/Songs/parking-lot-1.4.2/parking_lot/functional_spec/fixtures/file_input.txt").size());
    }
}

