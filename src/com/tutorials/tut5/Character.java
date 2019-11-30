package com.tutorials.tut5;

public class Character
{
    private final String name;
    private final String actorName;
    private final float rating;
    private final String movieName;

    public Character(String name, String actorName, float rating, String movieName) {
        this.name = name;
        this.actorName = actorName;
        this.rating = rating;
        this.movieName = movieName;
    }

    public String getName() {
        return name;
    }

    public String getActorName() {
        return actorName;
    }

    public float getRating() {
        return rating;
    }

    public String getMovieName() {
        return movieName;
    }

    @Override
    public String toString() {
        return "Main character: " + "name \'" + name + '\'' +
                "  actorName \'" + actorName + '\'' +
                "  rating " + rating + ", " +
                "  movieName '" + movieName + '\'';
    }

    public boolean equals(Character c)
    {
        if (getName().equals(c.getName()) && getActorName().equals(c.getActorName())
                && getRating() == c.getRating() && getMovieName().equals(c.getMovieName()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
