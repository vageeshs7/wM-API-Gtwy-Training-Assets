package com.vag.bookstore.controllers;

import com.vag.bookstore.bo.GetBooksResponse;
import com.vag.bookstore.dom.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookstoreRestController {

    private List<Book> bookList;
    private String server;

    @PostConstruct
    private void init(){
        bookList = new ArrayList<>();
        Book book = new Book("147852", "Mahabharata", "Tale of Dharma", "Vyasa", 5000);
        bookList.add(book);

        book = new Book("789456", "Ramayana", "Tale of Dharma", "Walmiki", 6000);
        bookList.add(book);

        book = new Book("258741", "Clash of Titans", "Adventure", "Augustus", 3000);
        bookList.add(book);

        try {
            server = InetAddress.getLocalHost().getHostName() + "|" + InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetBooksResponse getAllBooks(){
        GetBooksResponse response = new GetBooksResponse(bookList, server);
        return response;
    }
}
