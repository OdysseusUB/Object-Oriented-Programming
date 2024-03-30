/**
 * @author Ulysses Bueno
 * A class for LibraryApplication
 */
package assg6_buenou19;

import java.util.Scanner;

public class LibraryApplication {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		int choice;
		String input;
		
		BookCatalog bookCatalog = new BookCatalog();
		bookCatalog.loadData("assg6_catalog.txt");
		
		String title;
		String isbn;
		String author;
		String publisher;
		int year;
		
		/**
		 * A do/while loop to create menu exit options
		 */
		do {
			printMenu();
			input = kbd.nextLine();
			choice = Integer.parseInt(input);
			switch(choice) {
			
			case 1:
				bookCatalog.displayCatalog();
				break;
				
			case 2:
				System.out.println("Enter the title: ");
				input = kbd.nextLine();
				System.out.println(bookCatalog.searchForBook(input));
				break;
				
			case 3:
				System.out.println("Enter isbn: ");
				isbn = kbd.nextLine();
				System.out.println("Enter title: ");
				title = kbd.nextLine();
				System.out.println("Enter author: ");
				author = kbd.nextLine();
				System.out.println("Enter publisher: ");
				publisher = kbd.nextLine();
				System.out.println("Enter year: ");
				year = kbd.nextInt();
				kbd.nextLine();
				bookCatalog.addBook(isbn, title, author, publisher, year);
				break;
				
			case 4:
				System.out.println("Enter a title: ");
				title = kbd.nextLine();
				Book temp = bookCatalog.searchForBook(title);
				if (temp == null) {
					System.out.println("Book does not exist!");
				}
					else {
						do {
						System.out.println("Select an option to change: \n" +
					"1. Isbn\n 2. Author \n 3. Publisher \n 4. Year \n 0. Exit \n");
						
						input = kbd.nextLine();
						
						choice = Integer.parseInt(input);
						switch(choice) {
						case 1:
							System.out.println("Enter new isbn: ");
							isbn = kbd.nextLine();
							temp.setIsbn(isbn);
							break;
						case 2:
							System.out.println("Enter new author: ");
							author = kbd.nextLine();
							temp.setAuthor(author);
							break;
						case 3:
							System.out.println("Enter new publisher: ");
							publisher = kbd.nextLine();
							temp.setPublisher(publisher);
							break;
						case 4:
							System.out.println("Enter new year: ");
							year = kbd.nextInt();
							kbd.nextLine();
							temp.setYear(year);
							break;
							
						}
						
					} while (choice != 0);
					
				}
		
				break;
				
			case 5:
				System.out.println("Enter title of book to remove: ");
				title = kbd.nextLine();
				bookCatalog.removeBook(title);
				break;
				
			case 6:
				System.out.println("Enter publisher of books to find: ");
				publisher = kbd.nextLine();
				System.out.println(bookCatalog.getBooksByPublisher(publisher));
				break;
				
			case 7:
				bookCatalog.sortByTitle();
				break;
				
			case 8:
				bookCatalog.Save();
				break;
			}
			
			
		} while (choice != 9);
		
		if(choice == 9) {
			System.out.println("Goodbye!");
			bookCatalog.Save();
		}
		
		kbd.close();
	}
	
	/**
	 * A method for printMenu
	 */
	private static void printMenu() {
		System.out.print("1. Display all the books in the catalog\n" +
				"2. Search for a book\n" +
				"3. Add a new book\n" +
				"4. Update an existing book\n" +
				"5. Remove a book\n" +
				"6. Display books by a publisher\n" +
				"7. Sort all the books based on title\n" +
				"8. Save data\n" +
				"9. Exit\n\nSelect an option, then enter to continue: ");
	}
}
