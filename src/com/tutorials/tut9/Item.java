package com.tutorials.tut9;

public abstract class Item
{
    private String circulationCode;
    private String title;
    private int borrowedDays;

    public Item(String circulationCode, String title, int borrowedDays) {
        this.circulationCode = circulationCode;
        this.title = title;
        this.borrowedDays = borrowedDays;
    }

    public String getCirculationCode() {
        return circulationCode;
    }

    public void setCirculationCode(String circulationCode) {
        this.circulationCode = circulationCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBorrowedDays() {
        return borrowedDays;
    }

    public void setBorrowedDays(int borrowedDays) {
        this.borrowedDays = borrowedDays;
    }

    @Override
    public abstract String toString();
}
