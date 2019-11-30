/** This class is a abstract base class, providing three static methods to handle input cards and
 * a abstract method to calculate final scores.
 *
 * Name: Jingyin Chen
 * ID:   971159
 */
package com.project;

import java.util.Map;

public abstract class EvaluateBase
{
    /** This method uses the interface 'Map' to implement the mapping from face values to numeric values.
     * For each input card, using 'get' method to acquire corresponding numeric value.
     *
     * @param cardValues
     * @param handValues
     * @param args
     */
    protected static void getCardValues(Map<Character, Integer> cardValues, int[] handValues, String[] args)
    {
        cardValues.put('A', 1);
        cardValues.put('2', 2);
        cardValues.put('3', 3);
        cardValues.put('4', 4);
        cardValues.put('5', 5);
        cardValues.put('6', 6);
        cardValues.put('7', 7);
        cardValues.put('8', 8);
        cardValues.put('9', 9);
        cardValues.put('T', 10);
        cardValues.put('J', 10);
        cardValues.put('Q', 10);
        cardValues.put('K', 10);
        for(int i = 0; i < args.length; i++)
        {
            handValues[i] = cardValues.get(args[i].charAt(0));
        }
    }

    /** This method replaces the numeric values of 'J', 'Q', 'K' in order to
     * simplify getting scores of 'Pairs' and 'Runs'.
     *
     * @param handValues
     * @param args
     */
    protected static void replaceCardValues(int[] handValues, String[] args)
    {
        for(int i = 0; i < args.length; i++)
        {
            if(args[i].charAt(0) == 'J')
            {
                handValues[i] = 11;
            }
            else if(args[i].charAt(0) == 'Q')
            {
                handValues[i] = 12;
            }
            else if(args[i].charAt(0) == 'K')
            {
                handValues[i] = 13;
            }
        }
    }

    /** This method gets the suit of each input card.
     *
     * @param cardSuits
     * @param args
     */
    protected static void getCardSuits(char[] cardSuits, String[] args)
    {
        for(int i = 0; i < cardSuits.length; i++)
        {
            cardSuits[i] = args[i].charAt(1);
        }
    }

    protected abstract int getScores(String[] args);
}
