package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.formdata.BookDataFormData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/insertBooks")
public class InsertBookController {

	private static final Logger LOG = LoggerFactory
			.getLogger(InsertBookController.class);

	private BookService bookService;

	@Autowired
	public InsertBookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		modelMap.put("bookDataFormData", new BookDataFormData());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("bookDataFormData") @Valid BookDataFormData bookDataFormData,
			BindingResult result) {

		bookDataFormData.setAlreadyExists(false);
		
		Book existingBook = bookService.findBookByIsbn(bookDataFormData.getIsbn());
		if(existingBook!=null){
			bookDataFormData.setAlreadyExists(true);
			return "redirect:error";
		}

		
		if (result.hasErrors()) {
			return "insertBooks";
		} else {
			bookService.createBook(bookDataFormData.getTitle(), bookDataFormData.getAuthor(),
					bookDataFormData.getEdition(), bookDataFormData.getIsbn(),
					Integer.parseInt(bookDataFormData.getYearOfPublication()), bookDataFormData.getDescription());
			LOG.debug("new book instance is created: " + bookDataFormData.getIsbn());
			return "redirect:bookList";
		}

	}

}
