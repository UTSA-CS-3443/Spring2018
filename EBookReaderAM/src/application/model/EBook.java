package application.model;

import java.io.File;

public abstract class EBook implements Comparable<EBook>{

	private String author;
	private String title;
	private int numberOfPages;
	private int bookmarkPage;
	private String filePath;
	
	public EBook( String file ) {
		this.setFilePath(file);
		parseBookInfo(file);
	}
	
	public abstract void parseBookInfo( String fileName );
	
	public static EBook loadBook( File bookFile ) {
		
		if( bookFile.getName().endsWith(".txt") ) {
			TxtEBook txt = new TxtEBook( bookFile.toString() );
			return txt;
		}else
			return null;
	}
	
	public String toString() {
		return this.getAuthor() + " - " + this.getTitle() + "(" + this.getBookmarkPage() + ")";
	}
	
	public int getPageCount() {
		return this.numberOfPages;
	}
	
	public int compareTo( EBook book ) {
		return this.title.compareTo( book.title );
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	/**
	 * @return the bookmarkPage
	 */
	public int getBookmarkPage() {
		return bookmarkPage;
	}

	/**
	 * @param bookmarkPage the bookmarkPage to set
	 */
	public void setBookmarkPage(int bookmarkPage) {
		this.bookmarkPage = bookmarkPage;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
