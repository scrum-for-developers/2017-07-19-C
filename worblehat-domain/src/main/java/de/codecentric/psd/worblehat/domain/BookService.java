package de.codecentric.psd.worblehat.domain;

import java.util.List;

/**
 * The interface of the domain service for books.
 */
public interface BookService {

	void returnAllBooksByBorrower(String string);

	void returnBookByBorrower(String borrower, String Book);
	
	void borrowBook(Book book, String borrower) throws BookAlreadyBorrowedException;

	Book findBookByIsbn(String isbn);

	List<Book> findAllBooks();

	Book createBook(String title, String author, String edition, String isbn, int yearOfPublication, String description);

	boolean bookExists(String isbn);

	void deleteAllBooks();
}
