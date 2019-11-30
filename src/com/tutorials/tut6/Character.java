package com.tutorials.tut6;

public class Character
{
    private String name;
    private String actorName;
    private float rating;
    private String movieName;

    public Character(String name, String actorName, float rating, String movieName) {
        this.name = name;
        this.actorName = actorName;
        this.rating = rating;
        this.movieName = movieName;
    }

    public Character(Character orig) {
        this.name = orig.name;
        this.actorName = orig.actorName;
        this.rating = orig.rating;
        this.movieName = orig.movieName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Main character: " + "name \'" + name + '\'' +
                "  actorName \'" + actorName + '\'' +
                "  rating " + rating + ", " +
                "  movieName '" + movieName + '\'';
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || this.getClass() != o.getClass() || !super.equals(o))
        {
            return false;
        }
        Character c = (Character) o;
        return  (this.name.equals(c.name) && this.actorName.equals(c.actorName)
                && this.rating == c.rating && this.movieName.equals(c.movieName));
    }
}
