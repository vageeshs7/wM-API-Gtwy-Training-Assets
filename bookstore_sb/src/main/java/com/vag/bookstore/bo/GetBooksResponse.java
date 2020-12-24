package com.vag.bookstore.bo;

import com.vag.bookstore.dom.Book;

import java.util.List;

public class GetBooksResponse {
    private List<Book> bookList;
    private String server;

    public GetBooksResponse(List<Book> bookList, String server) {
        this.bookList = bookList;
        this.server = server;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
