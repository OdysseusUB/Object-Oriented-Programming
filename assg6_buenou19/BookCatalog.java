/**
 * @author Ulysses Bueno
 * A class for BookCatalog
 */
package assg6_buenou19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookCatalog extends LibraryApplication implements BookCatalogInterface {

	private String filename;
	private ArrayList<Book> books;

	public BookCatalog() {
		books = new ArrayList<>();
	}

	/**
	 * A method for loadData
	 * @param filename The name of file to load
	 */
	@Override
	public void loadData(String filename) {
		this.filename = filename;
		try {
			Scanner scanner = new Scanner(new File(this.filename));
			while (scanner.hasNext()) {
				String isbn = scanner.nextLine();
				String title = scanner.nextLine();
				String author = scanner.nextLine();
				String publisher = scanner.nextLine();
				int year = Integer.parseInt(scanner.nextLine());
				
				if(scanner.hasNextLine()) {
					scanner.nextLine();
				}
			
				Book bk = new Book(isbn, title, author, publisher, year);
				books.add(bk);
			}
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found.");
		}
	}

	/**
	 * A method for displayCatalog
	 */
	public void displayCatalog() {
		for (Book bk : books) {
			System.out.println(bk);
		}
	}

	/**
	 * A method searchForBook
	 * @param title The title of book to look for
	 */
	public Book searchForBook(String title) {
		for (Book bk : books) {
			if (bk.getTitle().equals(title)) {
				return bk;
			}
		}
		return null;
	}
	
	/**
	 * A method for addBook
	 * @param isbn The isbn of book to add
	 * @param title The title of book to add
	 * @param author The author of book to add
	 * @param publisher The publisher of book to add
	 * @param year The year of book to add
	 */
	public boolean addBook(String isbn, String title, String author, String publisher, int year) {
		Book temp = searchForBook(title);
		if (temp == null) {
			books.add(new Book(isbn, title, author, publisher, year));
			return true;
		} else {
			System.out.println("Book already exists!");
			return false;
		}
	}

	/**
	 * A method for updateBook
	 * @param isbn The isbn of book to update
	 * @param title The title of book to search for
	 * @param author The author of book to update
	 * @param publisher The publisher of book to update
	 * @param year The year of book to update
	 */
	public boolean updateBook(String isbn, String title, String author, String publisher, int year) {
		Book temp = searchForBook(title);
		if (temp == null) {
			System.out.println("Book does not exist");
			return false;
		} else
			for (Book bk : books)
				if (bk.getTitle().equals(temp.getTitle())) {
					bk.setAuthor(author);
					bk.setIsbn(isbn);
					bk.setPublisher(publisher);
					bk.setYear(year);
				}
		return true;
	}

	
	 /**
	  * A method for removeBook
	  * @param title The title of book to remove
	  */
	public boolean removeBook(String title) {
		Book temp = searchForBook(title);
		if (temp != null) {
			books.remove(temp);
			System.out.println("Success!");
			return true;
		}
		System.out.println("Error removing book");
		return false;
	}

	/**
	 * A method for getBooksByPublisher
	 * @param publisher The publisher of books to search for
	 */
	public ArrayList<Book> getBooksByPublisher(String publisher) {
		ArrayList<Book> searchForBooks = new ArrayList<>();
		for (Book bk : books)
			if (bk.getPublisher().equals(publisher)) {
				searchForBooks.add(bk);
			}
		return searchForBooks;
	}

	/**
	 * A method for sortByTitle
	 */
	public void sortByTitle() {
		Collections.sort(books);
		System.out.println("Success!");
	}

	/**
	 * A method for Save
	 */
	public void Save() {
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			PrintWriter printWriter = new PrintWriter(writer);
			for (Book bk : books) {
				printWriter.print(bk.getIsbn() + '\n');
				printWriter.print(bk.getTitle() + '\n');
				printWriter.print(bk.getAuthor() + '\n');
				printWriter.print(bk.getPublisher() + '\n');
				printWriter.print(bk.getYear() + '\n');
				printWriter.print('\n');
				printWriter.print('\n');
			}
			printWriter.close();
		} catch (IOException ex) {
			System.out.println("Error with file.");
		}
	}

}
