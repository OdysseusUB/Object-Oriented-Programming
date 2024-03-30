/**
 * @author Ulysses Bueno
 * A class for Book
 */
package assg6_buenou19;

public class Book implements Comparable<Book> {

	private String isbn;
	private int year;
	private String title;
	private String author;
	private String publisher;
	
	/**
	 * A constructor for Book
	 * @param isbn The isbn for book
	 * @param title The title for book
	 * @param author The author for book
	 * @param publisher The publisher for book
	 * @param year The year for book
	 */
	public Book(String isbn, String title, String author, String publisher, int year) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
	}
	
	/**
	 * A method for getIsbn
	 * @return The isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * A method for getTitle
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * A method for getAuthor
	 * @return The author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * A method for getPublisher
	 * @return The publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * A method for getYear
	 * @return The year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * A method for setIsbn
	 * @param isbn The new isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * A method for setAuthor
	 * @param author The new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * A method for setPublisher
	 * @param publisher The new publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * A method for setYear
	 * @param year The new year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * A method for toString
	 * @return The new string
	 */
	@Override
	public String toString() {
		return isbn + '\n' + title + '\n' + author + '\n' + publisher + '\n' + year + '\n';
	}
	
	/**
	 * A method for equals
	 * @return false If the title of two books are not equal, or book does not exist
	 * @return true If the titles of two books are equal
	 */
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		else if (obj instanceof Book) {
			Book temp = (Book) obj;
			return temp.getTitle().equals(this.getTitle());
		}
		else
			return false;
	}

	/**
	 * A method for compareTo
	 */
	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.title);
	}
}
