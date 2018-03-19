package application.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private String libraryPath;
	private ArrayList<EBook> books;
	
	public Library( String fullPath ) {
		this.books = new ArrayList<EBook>();
		this.libraryPath = fullPath;
		
		if( fullPath!=null )
			loadBookInformation();
	}
	
	public void loadBookInformation() {
		File dir = new File( this.libraryPath );
		File[] books = dir.listFiles();
		
		for( File book : books ) {
			if( book.isFile() )
				addBook( EBook.loadBook( book ) );
		}
	}
	
	
	public void addBook( EBook book ) {
		if( book!=null )
			this.books.add( book );
	}

	/**
	 * @return the books
	 */
	public ArrayList<EBook> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(ArrayList<EBook> books) {
		this.books = books;
	}
	
	
	public static void main( String[] args ) {
		Library lib = new Library( "" );
	}
}
