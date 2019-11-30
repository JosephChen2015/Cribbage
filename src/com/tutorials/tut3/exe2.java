package com.tutorials.tut3;

public class exe2
{
    public static void main(String[] args)
    {
        String[][] matrix = new String[11][11];
        matrix[0][0] = "*";
        for(int i = 1; i <= 10; i++)
        {
            matrix[0][i] = String.valueOf(i);
            matrix[i][0] = String.valueOf(i);
        }

        for(int row = 1; row <= 10; row++)
        {
            for(int col = 1; col <= 10; col++)
            {
                matrix[row][col] = String.valueOf(Integer.parseInt(matrix[0][col]) * Integer.parseInt(matrix[row][0]));
            }
        }

        for(int row = 0; row <= 10; row++)
        {
            for (int col = 0; col <= 10; col++)
            {
                if(row == 0 && col == 0)
                {
                    System.out.print("   " + matrix[row][col] + " |");
                    continue;
                }
                if(Integer.parseInt(matrix[row][col]) < 10)
                {
                    System.out.print("   " + matrix[row][col] + " |");
                    continue;
                }
                if(col == 10)
                {
                    System.out.println("  " + matrix[row][col] + " ");
                    continue;
                }
                System.out.print("  " + matrix[row][col] + " |");
            }
            if(row < 10)
            {
                System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            }
        }
    }
}