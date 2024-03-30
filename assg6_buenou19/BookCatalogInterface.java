/**
 * An interface for Book
 * @author Ulysses Bueno
 */
package assg6_buenou19;

import java.util.ArrayList;

public interface BookCatalogInterface {

	/**
	 * A method used to load the data 
	 * @param filename
	 */
	public void loadData(String filename);
	
	/**
	 * A method to display the catalog
	 */
	public void displayCatalog();
	
	/**
	 * A method to search for a book
	 * @param title The title to search for the book by
	 */
	public Book searchForBook(String title);
	
	/**
	 * A method to add a book
	 * @param isbn The isbn of the new book
	 * @param title The title of the new book
	 * @param author The author of the new book
	 * @param publisher The author of the new book
	 * @param year The year of the new book
	 */
	public boolean addBook(String isbn, String title, String author, String publisher, int year);
	
	/**
	 * A method to update the book
	 * @param isbn The isbn to change of the selected book
	 * @param title The title to change of the selected book
	 * @param author The author to change of the selected book
	 * @param publisher The publisher to change of the selected book
	 * @param year The year to change of the selected book
	 */
	public boolean updateBook(String isbn, String title, String author, String publisher, int year);
	
	/**
	 * A method to remove a book
	 * @param title The title of the book to remove
	 */
	public boolean removeBook(String title);
	
	/**
	 * A method to search for books by a certain publisher
	 * @param publisher The publisher to to search for books by
	 */
	public ArrayList<Book> getBooksByPublisher(String publisher);
	
	/**
	 * A method to sort books in order by their titles
	 */
	public void sortByTitle();
	
	/**
	 * A method to save the changes
	 */
	public void Save();
}

