package com.vikram.com.parkinglot;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Please enter 1 for file input or 2 for command line inputs" );
        getInputMethod();
    }

	private static void getInputMethod() {
		String inputFormat = System.console().readLine();
        switch (inputFormat) {
        
        //Read from file
		case "1":
			String fileLocation = "/home/adam/Desktop/Songs/parking-lot-1.4.2/parking_lot/functional_spec/fixtures/file_input.txt";
			List<String> parkingInstructions = readInputFromFile(fileLocation);
			readTheInstructionAndOperate(parkingInstructions);
			break;
		//Read from console	
		case "2":

		default:
			break;
		}
	}

	private static void readTheInstructionAndOperate(List<String> parkingInstructions) {
		// TODO Auto-generated method stub
		
	}

	public static List<String> readInputFromFile(String fileName) {
		// TODO Auto-generated method stub
		List<String> lines = Collections.emptyList(); 
	    try
	    { 
	      lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
	    } 
	  
	    catch (IOException e) 
	    { 
	  
	      // do something 
	      e.printStackTrace(); 
	    } 
	    return lines; 
	}
}

