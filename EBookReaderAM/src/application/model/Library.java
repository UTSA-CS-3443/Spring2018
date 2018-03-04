package application.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private ArrayList<EBook> books;
	
	public Library() {
		this.books = new ArrayList<EBook>();
	}
	
	
	public void addBook( EBook book ) {
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
}
