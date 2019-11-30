/** This class is a derived class from 'EvaluateBase', providing an overriding method 'getScores'
 * to calculate final scores, a private method to get the combinations of pairs.
 *
 * Name: Jingyin Chen
 * ID:   971159
 */
package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EvaluatePairs extends EvaluateBase
{
    /** This method overrides the abstract method in the base class,
     * calls the inherited method 'getCardValues' and 'replaceCardValues'
     * to get the values of a hand, then sorts it; passes the initial
     * parameters to 'getPairs', then calculate the final scores using
     * the output combinations obtained in 'getPairs'.
     *
     * @param args
     * @return
     */
    @Override
    public int getScores(String[] args)
    {
        if(args != null)
        {
            int[] handValues = new int[args.length];
            Map<Character, Integer> cardValues = new HashMap<>();
            super.getCardValues(cardValues, handValues, args);
            super.replaceCardValues(handValues, args);
            Arrays.sort(handValues);

            ArrayList<ArrayList<Integer>> combos = new ArrayList<>();
            boolean[] visited = new boolean[args.length];
            getPairs(handValues, visited, 0, 0, handValues[0], combos);

            if(combos != null)
            {
                return (combos.size()) * 2;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return -1;
        }
    }

    /** This method uses a recursion in a for-loop to ensure that starting from
     * the first card, all combinations of different cards can be obtained.
     * The 'visited' is an array of flags to indicate if the card is visited.
     * The 'key' is the current value to be compared. The 'combos' is a dynamic
     * array to store the combinations which get pairs.
     *
     * @param handValue
     * @param visited
     * @param n
     * @param count
     * @param key
     * @param combos
     */
    private void getPairs(int[] handValue, boolean[] visited, int n,
                          int count, int key, ArrayList<ArrayList<Integer>> combos)
    {
        // If two cards have the same value then add each visited card to a combination.
        if(count == 2)
        {
            ArrayList<Integer> combo = new ArrayList<>();
            for(int j = 0; j < n; j++)
            {
                if(visited[j])
                {
                    combo.add(handValue[j]);
                }
            }
            combos.add(combo);
            return;
        }

        // If all cards are traversed then return.
        if(n == handValue.length)
        {
            return;
        }

        /* For each unvisited card, if its value is equal to the 'key', increase the counter
           by 1, mark it true in 'visited',then go to next card. If return from the recursion,
           mark it false in 'visited' and decrease the counter by 1. If no card has the same
           value, manually set the next 'key'.
         */
        for(int i = n; i < handValue.length; i++)
        {
            if(!visited[i] && (handValue[i] == key))
            {
                count++;
                visited[i] = true;
                getPairs(handValue, visited, i+1, count, handValue[i], combos);
                visited[i] = false;
                count--;
            }

            if(count == 0)
            {
                if(i < handValue.length -1)
                {
                    key = handValue[i+1];
                }
                else
                {
                    key = handValue[i];
                }
            }
        }
    }
}
