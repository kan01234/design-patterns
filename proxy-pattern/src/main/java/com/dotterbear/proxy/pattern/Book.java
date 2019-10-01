package com.dotterbear.proxy.pattern;

public class Book implements BookInterface {

    private String content;

    private int numOfPage;

    private int numOfChapter;

    public Book (String content) {
        this.content = content;
        init();
    }

    private void init() {
        System.out.println("expensive init action from book");
        numOfPage = (int) ((Math.random() * 100) + 1);
        numOfChapter = (int) ((Math.random() * 10) + 1);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }

    public int getNumOfChapter() {
        return numOfChapter;
    }

    public void setNumOfChapter(int numOfChapter) {
        this.numOfChapter = numOfChapter;
    }

}