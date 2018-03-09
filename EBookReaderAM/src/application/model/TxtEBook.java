package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtEBook extends EBook {

	public TxtEBook(String file) {
		super(file);
	}

	public void parseBookInfo( String fileName ) {
		Scanner scan = null;

		try {
			scan = new Scanner( new File( fileName ) );
			if( scan.hasNextLine() ) {
				String line = scan.nextLine();
				
				// format: Project Gutenberg's The Adventures of Sherlock Holmes, by Arthur Conan Doyle
				line = line.substring( line.indexOf("'s") );
				String[] tokens = line.split(", by ");
				this.setAuthor( tokens[1] );
				this.setTitle( tokens[0].replaceAll("'s", "") );
				// TODO: Update this to recover gracefully if the file is not formatted as expected!
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if( scan!=null )
				scan.close();
		}
	}
	
}
