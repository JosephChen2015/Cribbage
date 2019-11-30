package com.tutorials.tut9;

public class DVD extends Item
{
    private int releaseYear;

    public DVD(String circulationCode, String title, int releaseYear) {
        super(circulationCode, title, 7);
        this.releaseYear = releaseYear;
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return  "circulationCode='" + getCirculationCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", borrowedDays=" + getBorrowedDays() + '\'' +
                ", releaseYear=" + getReleaseYear() +
                '}';
    }
}
