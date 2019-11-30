package com.tutorials.tut11;

import java.util.ArrayList;
import java.util.Scanner;

/** Allow entry and editing of a list of friends' names
 *
 * @author Peter Schachte <schachte@unimelb.edu.au>
 */
public class FriendEditor {

    /** Holds the list of friends
     */
    private static ArrayList<String> names = new ArrayList<String>();

    /** Read from the keyboard
     */
    private static Scanner keyboard = new Scanner(System.in);

    /** The possible editor commands
     */
    private enum Command {
        ENTER, DELETE, MOVE, QUIT
    };

    /** Separator printed before and after showing all names
     */
    private static final String BAR_STRING = "--------------------";

    /***************************************************************
     *                          Main Control                       *
     ***************************************************************/

    /** Main method
     *
     * @param args No command line arguments for this program
     */
    public static void main(String[] args) {
        System.out.print(
                "Welcome tothe Friend Editor; type E to enter some names.");
        while (true) {
            printNames();
            Command cmd = getCommand();
            if (cmd == Command.QUIT)
                break;
            doCommand(cmd);
        }
    }

    /** Prompt for and read in the user's command
     *
     * @return the command the user specified
     */
    private static Command getCommand() {
        while (true) {
            System.out.print("\nEnter, Delete, or Move names, or Quit [EDMQ]: ");
            String cmd = keyboard.nextLine();
            switch (cmd.trim().toLowerCase().charAt(0)) {
                case 'e':
                    return Command.ENTER; // break;
                case 'd':
                    return Command.DELETE; // break;
                case 'm':
                    return Command.MOVE; // break;
                case 'q':
                    return Command.QUIT; // break;
            }
            System.out.println("Please type one of the characters specified");
        }
    }

    /** Execute the user's command
     *
     * @param command the command to execute
     */
    private static void doCommand(Command command) {
        switch (command) {
            case ENTER:
                enterNames();
                break;
            case DELETE:
                deleteName();
                break;
            case MOVE:
                moveName();
                break;
        }
    }

    /***************************************************************
     *                          The Commands                       *
     ***************************************************************/

    /** Read as many names as the user want to edit, and insert them into
     *  the list.
     */
    private static void enterNames() {
        String line;
        int count = names.size() + 1;
        while (true) {
            System.out.printf("%3d: ", count);
            line = keyboard.nextLine();
            if (line.isEmpty())
                break;
            names.add(line);
            ++count;
        }
    }

    /** Delete the name at the position the user specifies.
     */
    private static void deleteName() {
        int position = getPosition("Enter position number of name to delete: ");
        if (position > 0 && position <= names.size()) {
            names.remove(position - 1);
        } else {
            System.out.println("Invalid position number");
        }
    }

    /** Move the name at the position the user specifies to follow the
     * position the user specifies.
     */
    private static void moveName() {
        int from = getPosition("Enter position number of name to move: ");
        int to   = getPosition(
                "Enter position number to move after (0 for start): ");
        if (from > 0 && from <= names.size() && to >= 0 && to <= names.size()) {
            String name = names.remove(from-1);
            // removing the element renumbered all following elements, so
            // we need to compensate if to > from
            names.add((to>from ? to-1 : to), name);
        } else {
            System.out.println("Invalid position number");
        }
    }

    /***************************************************************
     *                           Helper Code                       *
     ***************************************************************/

    /** Display the whole list of names
     */
    private static void printNames() {
        int line = 1;
        System.out.println();
        System.out.println(BAR_STRING);
        for (String name : names) {
            System.out.printf("%3d:  %s\n", line, name);
            line++;
        }
        System.out.println(BAR_STRING);

    }

    /** Read in a position number from the user
     *
     * @param prompt the prompt to show the user
     * @return the position number entered by the user, or a negative number
     *         if the user did not enter a valid position number
     */
    private static int getPosition(String prompt) {
        int position;
        System.out.print(prompt);
        String line = keyboard.nextLine();
        try {
            position = Integer.parseInt(line);
        } catch (Exception e) {
            position = -1;
        }
        return position;
    }
}
