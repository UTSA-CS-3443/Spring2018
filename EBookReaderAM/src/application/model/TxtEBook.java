package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TxtEBook extends EBook {

	public void parseFile( String fileName ) {
		try {
			Scanner scan = new Scanner( new File( fileName ) );
			
			while( scan.hasNextLine() ) {
				String line = scan.nextLine();
				System.out.println( line );      //TODO: Fix this later!
			}
			
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch( IOException e ) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
