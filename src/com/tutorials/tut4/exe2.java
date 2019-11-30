package com.tutorials.tut4;

public class exe2
{
    public static void main(String[] args)
    {
        Boolean ret = isAFavourite("Thor");
        System.out.println(ret);
    }

    private static boolean isAFavourite(String s)
    {
        String movies = "The Avengers, Iron Man, Guardians of the Galaxy, Thor, Captain America";

        if(s.isEmpty())
        {
            return false;
        }
        else
        {
            for(int i = 0; i < movies.split(", ").length; i++)
            {
                if(movies.split(", ")[i].contains(s))
                {
                    return true;
                }
                else
                {
                    continue;
                }
            }
            return false;
        }
    }
}
