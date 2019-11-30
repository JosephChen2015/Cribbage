package com.tutorials.tut4;

public class exe1
{
    public static void main(String[] args)
    {
        printMovies();
        System.out.println("---------------------------------");
        printMovies(1, "The Avengers");
        printMovies(2, "Iron Man");
        printMovies(3, "Guardians of the Galaxy");
        printMovies(4, "Thor");
        printMovies(5, "Captain America");
        System.out.println("---------------------------------");
        printMovies("The Avengers, Iron Man, Guardians of the Galaxy, Thor, Captain America");
    }

    private static void printMovies()
    {
        String[] movies = {"The Avengers", "Iron Man", "Guardians of the Galaxy", "Thor", "Captain America"};

        for(int i = 0; i < movies.length; i++)
        {
            System.out.println((i + 1) + ". " + movies[i]);
        }
    }

    private static void printMovies(int rank, String name)
    {
        System.out.println(rank + ". " + name);
    }

    private static void printMovies(String movies)
    {
        for(int i = 0; i < movies.split(",").length; i++)
        {
            if(i == 0)
            {
                System.out.println((i + 1) + ". " + movies.split(",")[i]);
            }
            else
            {
                System.out.println((i + 1) + "." + movies.split(",")[i]);
            }
        }
    }
}
