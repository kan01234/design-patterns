package com.dotterbear.proxy.pattern;

public class BookProxy implements BookInterface {

    private String content;

    private Book book;

    public BookProxy(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        if (book == null)
            book = new Book(content);
        return book.getContent();
    }

    @Override
    public int getNumOfChapter() {
        if (book == null)
            book = new Book(content);
        return book.getNumOfChapter();
    }

    @Override
    public int getNumOfPage() {
        if (book == null)
            book = new Book(content);
        return book.getNumOfPage();
    }

    public Book getBook() {
        return book;
    }
}