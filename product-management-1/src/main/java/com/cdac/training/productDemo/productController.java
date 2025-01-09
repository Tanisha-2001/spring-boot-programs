package com.cdac.training.productDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class productController {

    private List<Book> bookList = new ArrayList<>();

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookList;
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book) {
        bookList.add(book);
        return book;
    }
}
