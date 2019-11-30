package com.tutorials.tut11;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendsList
{
    private static ArrayList<String> friends = new ArrayList<String>();

    public static void main(String[] args)
    {
        friends = new ArrayList<String>();
        Scanner scan = new Scanner(System.in); // Use "System.in" to create a string buffer, use "scan" to read from the buffer
        while(scan.hasNextLine())
        {
            String input = scan.nextLine(); // "next()" reads until the space and places the cursor before the space,  "nextLine()" reads including space and '\n' and places the cursor in the next line
            if(input.equals("add"))
            {
                 while(scan.hasNextLine())
                 {
                     String newFriend = scan.nextLine();
                     if(newFriend.isEmpty())
                     {
                         break;
                     }
                     friends.add(newFriend);
                 }
            }
            else if(input.equals("delete"))
            {
                int index = scan.nextInt(); // "nextInt()" just reads integer and places the cursor after the integer
                scan.nextLine();
                friends.remove(index - 1);
            }
            else if(input.equals("quit"))
            {
                System.out.println("Program quits!");
                System.exit(0);
            }
            else
            {
                System.out.println("Illegal input!");
                continue;
            }
            printAllFriends();
        }
    }

    private static void printAllFriends()
    {
        System.out.println("Friends list: ");
        for(int i = 0; i < friends.size(); i++)
        {
            System.out.println((i + 1) + ". " + friends.get(i));
        }
    }
}
