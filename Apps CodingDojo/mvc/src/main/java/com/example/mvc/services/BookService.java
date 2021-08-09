package com.example.mvc.services;

import com.example.mvc.models.Book;
import com.example.mvc.repositories.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    //Agregando el book al repositorio como una dependenciacopy
    private final BookRepository bookRepository;

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(((Optional<?>) optionalBook).isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

}
