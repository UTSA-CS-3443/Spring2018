package application.model;

public abstract class EBook implements Comparable<EBook>{

	private String author;
	private String title;
	private int numberOfPages;
	
	public abstract void parseFile( String fileName );
	
	public int getPageCount() {
		return this.numberOfPages;
	}
	
	public int compareTo( EBook book ) {
		return this.title.compareTo( book.title );
	}
}
