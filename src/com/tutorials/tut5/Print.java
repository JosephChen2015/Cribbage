package com.tutorials.tut5;

public class Print
{
    public static void main(String[] args)
    {
        Character c1 = new Character("Black Widow", "Scarlett Johansson", 10.0f, "The Avengers1");
        Movie m1 = new Movie("The Avengers1", 1, 128, c1);
        System.out.println(m1.toString());

        Character c2 = new Character("Black Widow", "Scarlett Johansson", 10.0f, "The Avengers1");
        Movie m2 = new Movie("The Avengers1", 1, 128, c2);
        System.out.println(m2.toString());

        System.out.println(m1.equals(m2));
    }
}
