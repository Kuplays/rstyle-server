package com.kuplays.rstyle.controllers;

import com.kuplays.rstyle.entities.BookEntity;
import com.kuplays.rstyle.entities.UserEntity;
import com.kuplays.rstyle.repositories.BookRepository;
import com.kuplays.rstyle.repositories.UserRepository;
import com.kuplays.rstyle.utilities.BookOperationResponse;
import com.kuplays.rstyle.utilities.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://rstyle-lib.herokuapp.com")
public class RootController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    /*
    fetch route that returns all books using GET.
    Inserted a pause for 1 sec for demonstration purposes.
    @return Iterable collection of books in JSON format.
     */
    @GetMapping("/")
    public Iterable<BookEntity> index() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bookRepository.findAll();
    }

    /*
    Delete route using DELETE.
    @param id an id of the book to delete. It will be
    passed from front-end part.
    @return regular response with OK.
     */
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        bookRepository.deleteById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    /*
    Update route using PUT.
    @param id an ID of the record to update. Comes from front-end
    part.
    @param bookDetails holds new values to overwrite current book
    @return BookEntity response.
     */
    @PutMapping("/books/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody BookEntity bookDetails) {
        BookEntity fetchedEntity = bookRepository.findByGivenId(id);
        fetchedEntity.setTitle(bookDetails.getTitle());
        fetchedEntity.setAuthorName(bookDetails.getAuthorName());
        fetchedEntity.setYearRead(bookDetails.getYearRead());
        fetchedEntity.setType(bookDetails.getType());

        final BookEntity updatedBook = bookRepository.save(fetchedEntity);


        return ResponseEntity.ok(updatedBook);
    }

    /*
    Adding new book route using POST.
    @param newBook book data to set as new book. Comes
    from front-end part.
    @return custom bookOperations response of the operation.
     */
    @PostMapping("/books")
    public BookOperationResponse getBooks(@RequestBody BookEntity newBook) {
        BookOperationResponse response = new BookOperationResponse("ADD", "");

        if (newBook != null) {
            bookRepository.save(new BookEntity(newBook.getTitle(), newBook.getAuthorName(), newBook.getYearRead(), newBook.getType()));
            response.setMessage("ADD_SUCCESS");
        } else {
            response.setMessage("ADD_FAILURE");
        }
        return response;
    }

    /*
    Login route using POST.
    @param loginData data object which holds
    username and password
    @return custom login response with token and allowed state.
     */
    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserEntity loginData) {
        System.out.println(loginData.toString());
        LoginResponse loginResponse = new LoginResponse("", "", false);
        UserEntity userData = userRepository.findByName(loginData.getUserName());

        if (userData != null) {
            if (userData.getUserPassword().compareTo(loginData.getUserPassword()) == 0) {
                loginResponse.setAllowed(true);
                loginResponse.setResponseToken("token");
            } else {
                loginResponse.setErrorMessage("INVALID_CREDENTIALS");
            }
        } else {
            loginResponse.setErrorMessage("INVALID_CREDENTIALS");
        }

        return loginResponse;
    }
}
