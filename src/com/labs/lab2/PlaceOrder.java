package com.labs.lab2;

import java.util.Scanner;

public class PlaceOrder
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int q = 0;
        String d = "";
        double u = 0.00;

        System.out.print("Quantity: ");
        if(scan.hasNextInt())
        {
            q = scan.nextInt();
        }
        scan.nextLine();

        System.out.print("Description: ");
        if(scan.hasNextLine())
        {
            d = scan.nextLine();
        }

        System.out.print("Unit price: ");
        if(scan.hasNextDouble())
        {
            u = scan.nextDouble();
        }
        scan.nextLine();

        System.out.printf("Order for %d %s%n", q, d.toUpperCase());
        System.out.printf("Total price %14.2f%n", (u * q));
    }
}
