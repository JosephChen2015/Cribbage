package com.tutorials.tut6;

public class Movie
{
    private String title;
    private int rank;
    private int runTime;
    private Character character;

    public Movie(String title, int rank, int runTime, Character character) {
        this.title = title;
        this.rank = rank;
        this.runTime = runTime;
        this.character = new Character(character);
    }

    public Movie(Movie orig) {
        this.title = orig.title;
        this.rank = orig.rank;
        this.runTime = orig.runTime;
        this.character = new Character(orig.character);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public float getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public Character getCharacter() {
        return new Character(character);
    }

    public void setCharacter(Character character) {
        this.character = new Character(character);
    }

    @Override
    public String toString() {
        return rank + ". " +  title + "  " + runTime + " minutes " + '\n'
                + character.toString() + '\n';
    }

    public boolean equals(Object o)
    {
        if( o == null || this.getClass() != o.getClass() || !super.equals(o))
        {
            return false;
        }
        Movie m = (Movie) o;
        return (this.title.equals(m.title) && this.rank == m.rank && this.runTime == m.runTime
                && this.character.equals(m.character));
    }
}
