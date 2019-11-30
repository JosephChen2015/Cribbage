/** This class provides a single static main method to compute the value of
 * a given input hand alongside an additional start card (all in the form
 * of a String input array), which utilizes 7 other static methods to solve
 * each of the sub-problems of "One for his Nob", "Flushes", "Pairs", "Runs"
 * and "15s". It adds all of the solved sub-problems to the hand's value,
 * and prints out the hand's value at conclusion.
 * 
 * @author Anon
 *
 */
package com.project.peer_review.review2;

import java.util.Arrays;

public class HandValue_test2 {

    /** This main method computes the value of a given input hand alongside an
     * additional start card (all in the form of a String input array), which
     * utilizes 7 other static methods to solve each of the sub-problems of
     * "One for his Nob", "Flushes", "Pairs", "Runs" and "15s". It adds all
     * of the solved sub-problems to the hand's value, and prints out the
     * hand's value at conclusion.
     * 
     * @param args : an array of type String which refers to the initial input
     * hand and starting card given.
     */
    public static void main(String[] args) {

        int handValue = 0;

        final int POINTS_FOR_PAIR = 2;
        final int POINTS_FOR_FIFTEENS = 2;
        final char START_CARD_SUIT = args[4].charAt(1);

        // This constant is an array of integer card ordinal values of the hand.
        final int[] HAND_ORDINAL_VALUES = {
            cardOrdinalValue(args[0].charAt(0)),
            cardOrdinalValue(args[1].charAt(0)),
            cardOrdinalValue(args[2].charAt(0)),
            cardOrdinalValue(args[3].charAt(0)),
            cardOrdinalValue(args[4].charAt(0))
        };

        Arrays.sort(HAND_ORDINAL_VALUES);

        // This constant is an array of integer card face values of the hand.
        final int[] HAND_FACE_VALUES = {
            cardFaceValue(args[0].charAt(0)),
            cardFaceValue(args[1].charAt(0)),
            cardFaceValue(args[2].charAt(0)),
            cardFaceValue(args[3].charAt(0)),
            cardFaceValue(args[4].charAt(0))
        };

        handValue += oneForHisNobScore(args, START_CARD_SUIT);

        handValue += totalFlushScore(args, START_CARD_SUIT);

        handValue += POINTS_FOR_PAIR * pairCount(HAND_ORDINAL_VALUES);

        handValue += totalRunScore(HAND_ORDINAL_VALUES);

        handValue += POINTS_FOR_FIFTEENS * fifteensCount(HAND_FACE_VALUES, 0, args.length - 1, 0);

        System.out.println(handValue);
    }

    /** This method computes the card ordinal value of a given card number.
     *  A card ordinal number refer's to a card's value in ordered respect
     *  to other cards ('K' = 13; 'Q' = 12; 'J' = 11; 'T' = 10; 'A' = 1;
     *  all others = their numeric number).
     * 
     * @param cardNumber : a char value that indicates the Number of the 
     * card to be considered. A number in this case refers to the number 
     * of the card, with no consideration of the suit. E.g. 'A', 'K', 'T', '3'.
     * @return an integer value that is the ordinal value of the input card 
     * number.
     */
    private static int cardOrdinalValue(char cardNumber) {
        switch (cardNumber) {
            case 'K':
                return 13;
            case 'Q':
                return 12;
            case 'J':
                return 11;
            case 'T':
                return 10;
            case 'A':
                return 1;
            default:
                return Character.getNumericValue(cardNumber);
        }
    }

    /** This method computes the face ordinal value of a given card number. 
     * A card face value refers to the card's worth ('K'; 'Q'; 'J'; 'T' = 10; 
     * 'A' = 1; all others = their numeric number).
     * 
     * @param cardNumber : a char value that indicates the Number of the card 
     * to be considered. A number in this case refers to the number of the 
     * card, with no consideration of the suit. E.g. 'A', 'K', 'T', '3'.
     * @return an integer value that is the face value of the input card number.
     */
    private static int cardFaceValue(char cardNumber) {
        switch (cardNumber) {
            case 'K':
            case 'Q':
            case 'J':
            case 'T':
                return 10;
            case 'A':
                return 1;
            default:
                return Character.getNumericValue(cardNumber);
        }
    }

    /** This method computes if a "One for his nob" is present, and if so, 
     * returns the points provided for its presence.
     * 
     * @param args : an array of type String which refers to the initial input 
     * hand and starting card given.
     * @param START_CARD_SUIT: a char value indicating the suit of the start 
     * card of a given parameter args.
     * @return an integer value that indicates the total points received if a 
     * "One For His Nob" is present within the input array.
     */
    private static int oneForHisNobScore(String[] args, char START_CARD_SUIT) {
        final int ONE_FOR_HIS_NOB_REWARD = 1;

        // This operation confirms if each card in the hand of the input array 
        // is a Jack, and if the suit of that card is equal to the suit of the start card.
        for (int i = 0; i < 4; ++i) {
            if (args[i].charAt(0) == 'J' && args[i].charAt(1) == START_CARD_SUIT) {
                return ONE_FOR_HIS_NOB_REWARD;
            }
        }

        return 0;
    }

    /** This method computes the total score received if a Flush is present
     * within the input array of cards. It awards points if a flush is present 
     * within the hand, i.e. the first four cards of the input array, and awards 
     * an additional point if the start card if also of the same suit.
     * 
     * @param args : an array of type String which refers to the initial input 
     * hand and starting card given.
     * @param START_CARD_SUIT: a char value indicating the suit of the start 
     * card of a given parameter args.
     * @return an integer value that indicates the total score received if a 
     * flush is present within the input array.
     */
    private static int totalFlushScore(String[] args, char START_CARD_SUIT) {
        final int POINTS_FOR_FLUSH = 4;
        final int POINTS_FOR_MATCHING_START_CARD = 1;
        boolean flush = true;

        // This operation checks if each card's suit in the hand of the given 
        // input array are the same, and if they all are, a flush remains present.
        for (int i = 0; i < 3; ++i) {
            if (args[i].charAt(1) != args[i + 1].charAt(1)) {
                flush = false;
                break;
            }
        }

        if (flush) {
            if (args[0].charAt(1) == START_CARD_SUIT) {
                return POINTS_FOR_FLUSH + POINTS_FOR_MATCHING_START_CARD;
            } else {
                return POINTS_FOR_FLUSH;
            }
        } else {
            return 0;
        }
    }

    /** This method checks if a pair combination is present within the given
     * input array hand. A pair in this case is defined as two cards distinctly 
     * paired which have the same ordinal value, whereby a three of a kind 
     * results in  3 pairs.
     * 
     * @param HAND_ORDINAL_VALUES : An array of integer ordinal values of each 
     * card in a given hand.
     * @return an integer value of the total number of distinct pairs found 
     * within the input array hand.
     */
    private static int pairCount(int[] HAND_ORDINAL_VALUES) {
        int pairCount = 0;

        // This operation is responsible for counting the number of pairs 
        //present, by checking if each card within the input hand has the 
        // same ordinal value as all other cards within the hand.
        for (int i = 0; i < 4; ++i) {
            for (int j = i + 1; j < 5; ++j) {
                if (HAND_ORDINAL_VALUES[i] == HAND_ORDINAL_VALUES[j]) {
                    pairCount += 1;
                }
            }
        }
        return pairCount;
    }

    /** This method computes the total run score of a given hand from the 
     * input array of ordinal values of card in a given hand. It keeps 
     * track of a run multiples in a given input array, and the number of 
     * cards in each run, and multiples the two to provide the total run 
     * score. Note that a run in this case constitutes three or more 
     * consecutive ordinal values.
     * 
     * @param HAND_ORDINAL_VALUES : A sorted array of integer ordinal 
     * values of each card in a given hand.
     * @return an integer value of the total run score of the input array hand.
     */
    private static int totalRunScore(int[] HAND_ORDINAL_VALUES) {
        int cardsInRun = 1;
        int runs = 1;

        // This operation traverses through the sorted input array to check
        // if runs are present. It keeps track of run multiples where duplicate
        // values of card ordinal values may be present within a single run.
        for (int i = 0; i < 4; ++i) {
            if (HAND_ORDINAL_VALUES[i] + 1 == HAND_ORDINAL_VALUES[i + 1]) {
                cardsInRun += 1;

                // In each case a duplicate card ordinal value is found, if a 
                // duplicate has previously been found of the same ordinal value,
                // there is another run using that duplicate to distinguish itself.
                // Otherwise, there is a new set of duplicate values, which increases
                // the multiple of runs present.
            } else if (HAND_ORDINAL_VALUES[i] == HAND_ORDINAL_VALUES[i + 1]) {
                if (i > 0 && HAND_ORDINAL_VALUES[i] == HAND_ORDINAL_VALUES[i - 1]) {
                    runs += 1;
                } else {
                    runs *= 2;
                }

            } else if (cardsInRun > 2) {
                break;
            } else {
                cardsInRun = 1;
            }
        }

        if (cardsInRun > 2) {
            return runs * cardsInRun;
        } else {
            return 0;
        }
    }

    /** This method computes the total number of combinations within the given 
     * input array hand that equal to a sum of 15. It utilizes a recursive call 
     * of itself in order to split the initial input array into sub-arrays to 
     * find all possible sub-array combinations and their sums.
     * 
     * @param HAND_FACE_VALUES : An array of integer face values of each card 
     * in a given hand.
     * @param l : an integer value that refers to the left most index of the 
     * sub-array being considered.
     * @param r : an integer value that refers to the right most index of the 
     * sub-array being considered.
     * @param sum : an integer value that refers to the current sum of the 
     * sub-array being considered.
     * @return an integer value which indicates the total number of fifteen 
     * sum combinations found within the initial input array.
     */
    private static int fifteensCount(int[] HAND_FACE_VALUES, int l, int r, int sum) {

        // This statement ensures that every sub-array combination is evaluated. And if it does, it
    	// evaluates the sum of the sub array.
        if (r < l) {
            if (sum == 15) {
                return 1;
            } else {
                return 0;
            }
            // This operation splits the (sub)array into two sub-arrays, one that includes the value
            // of the <l>th card, and one that doesn't include it.
        } else {
            return fifteensCount(HAND_FACE_VALUES, l + 1, r, sum + HAND_FACE_VALUES[l]) +
                fifteensCount(HAND_FACE_VALUES, l + 1, r, sum);
        }
    }
}
