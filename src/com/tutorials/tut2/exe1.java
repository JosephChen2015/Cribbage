package com.tutorials.tut2;

import java.util.Scanner;

public class exe1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        System.out.println("Length = " + line.length());
        System.out.println("First word = " + line.split(" ")[0]); // Splits this string around matches of the given regular expression
        System.out.print("The rest of words = ");
        for(int i = 1; i <= line.split(" ").length - 1; i++)
        {
            System.out.print(line.split(" ")[i] + " ");
        }
        System.out.println();
    }
}
