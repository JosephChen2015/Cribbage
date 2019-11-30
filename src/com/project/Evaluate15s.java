/** This class is a derived class from 'EvaluateBase', providing an overriding method 'getScores'
 * to calculate final scores, a private method to get the combinations of 15 scores.
 *
 * Name: Jingyin Chen
 * ID:   971159
 */
package com.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Evaluate15s extends EvaluateBase
{
    /** This method overrides the abstract method in the base class,
     * calls the inherited method 'getCardValues' to get the values
     * of a hand, passes the initial parameters to 'get15s',
     * then calculates the final scores using the output combinations
     * obtained in 'get15s'.
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

            boolean[] visited = new boolean[args.length];
            ArrayList<ArrayList<Integer>> combos = new ArrayList<>();
            get15s(handValues, visited, 0, 0, 15, combos);

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
     * The 'combos' is a dynamic array to store the combinations which get 15 scores.
     *
     * @param handValue
     * @param visited
     * @param n
     * @param sum
     * @param key
     * @param combos
     */
    protected void get15s(int[] handValue, boolean[] visited, int n,
                        int sum, int key, ArrayList<ArrayList<Integer>> combos)
    {
        // If 'sum' is larger than 15 then return.
        if(sum > key)
        {
            return;
        }

        // If 'sum' is equal to 15 then add each visited card to a combination.
        if(sum == key)
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

        /* For each unvisited card, add its value to the sum, mark it true in 'visited',
           then go to next card. If return from the recursion, mark it false in 'visited'
           and minus its value from the sum.
         */
        for(int i = n; i < handValue.length; i++)
        {
            if(!visited[i])
            {
                sum += handValue[i];
                visited[i] = true;
                get15s(handValue, visited, i+1, sum, key, combos);
                visited[i] = false;
                sum -= handValue[i];
            }
        }
    }
}
