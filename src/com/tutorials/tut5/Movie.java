package com.tutorials.tut5;

public class Movie
{
    private final String title;
    private final int rank;
    private final int runTime;
    private final Character character;

    public Movie(String title, int rank, int runTime, Character character) {
        this.title = title;
        this.rank = rank;
        this.runTime = runTime;
        this.character = character;
    }

    public String getTitle() {
        return title;
    }

    public int getRank() {
        return rank;
    }

    public float getRunTime() {
        return runTime;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return rank + ". " +  title + "  " + runTime + " minutes " + '\n'
                + character.toString() + '\n';
    }

    public boolean equals(Movie m)
    {
        if (getTitle().equals(m.getTitle()) && getRank() == m.getRank() && getRunTime() == m.getRunTime() && getCharacter().equals(m.getCharacter()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
