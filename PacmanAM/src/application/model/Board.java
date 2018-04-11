package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	
	private int numRows;
	private int numCols;
	private char [][] board;
	private int level;
	
	private int currentRow;
	private int currentCol;

	public Board( int rows, int cols, int level ) {
		this.numRows = rows;
		this.numCols = cols;
		this.level = level;
		
		this.board = new char[rows][cols];
	}
	
	// Method to read in the data from level files & create a Board object
	public static Board loadFromFile( String fileName ) {
		// open the file
		Scanner scan = null;
		Board b = null;
		ArrayList<String> eachRow = new ArrayList<String>();
		
		try {
			// do the reading
			scan = new Scanner( new File( fileName) );
			while( scan.hasNextLine() ) {
				eachRow.add( scan.nextLine() );
			}
			
			int numberOfRows = eachRow.size();
			int numberOfCols = eachRow.get(0).length();
			
			//TODO: Fix the level number to dynamically read from the file name
			b = new Board( numberOfRows, numberOfCols, 1 );
			// copy the file contents to the board model object
			for( int r=0; r<numberOfRows; r++ ) {
				for( int c=0; c<numberOfCols; c++ ) {
					char letter = eachRow.get(r).charAt(c);
					b.board[r][c] = letter;
					
					if( letter=='c' )
						b.updateCurrentLocation(r,c);
				}
			}
			
		}catch(IOException e) {
			//TODO: handle this exception!
			e.printStackTrace();
		}finally {
			if( scan!=null )
				scan.close();
		}
			
		return b;
	}
	
	public void updateCurrentLocation(int r, int c) {
		this.currentCol = c;
		this.currentRow = r;
	}
	
	
	public int getRows() {
		return this.numRows;
	}
	
	public int getCols() {
		return this.numCols;
	}
	
	public char getBoardLocation( int row, int col ) {
		return this.board[row][col];
	}
}
