package com.tutorials.tut9;

public class Book extends Item
{
    private String author;

    public Book(String circulationCode, String title, String author) {
        super(circulationCode, title, 21);
        this.author = author;
    }

    public String getCirculationCode() {
        return super.getCirculationCode();
    }

    public void setCirculationCode(String circulationCode) {
        super.setCirculationCode(circulationCode);
    }

    public String getTitle() {
        return super.getTitle();
    }

    public void setTitle(String title) {
        super.setTitle(title);
    }

    public int getBorrowedDays() {
        return super.getBorrowedDays();
    }

    public void setBorrowedDays(int borrowedDays) {
        super.setBorrowedDays(borrowedDays);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return  "circulationCode='" + getCirculationCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", borrowedDays=" + getBorrowedDays() + '\'' +
                ", author='" + getAuthor() + '\'' +
                '}';
    }
}
