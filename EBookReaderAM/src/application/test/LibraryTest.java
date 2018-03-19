package application.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.model.EBook;
import application.model.Library;

class LibraryTest {

	ArrayList<EBook> books;
	Library lib;
	
	@BeforeEach
	void setUp() throws Exception {
		books = new ArrayList<EBook>();
		lib = new Library(null);
	}

	@After
	void tearDown() throws Exception {
	}

	@Test
	void testLoadBookInformation() {
		fail("Not yet implemented"); //TODO
	}

	@Test
	void testAddBook() {
		fail("Not yet implemented");	//TODO
	}

	@Test
	void testGetBooks() {
		fail("Not yet implemented");	//TODO
	}

	@Test
	void testSetBooks() {
		
		//TEST 1: Setting the books to null
		lib.setBooks(null);
		
		//         Expected result: books are null..
		if( lib.getBooks()!=null )
			fail("Library - setBooks - should have been reset to null");
		
		//TEST 2: Setting the books to an ArrayList of books
		lib.setBooks( books );
				
		//        Expected result: books are not null and size=0
		if( lib.getBooks()==null || lib.getBooks().size()!=0 )
			fail("Library - setBooks - ArrayList is null or invalid size");
	}

}
