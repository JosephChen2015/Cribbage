package com.project.peer_review.review3;

/****
 * CourseName: COMP90041
 * Title: Java Poject
 * Description: this is a Java main program for the Game of Cribbage that receives 5 cards on the command
 * line and will print out only the number of points the hand comprising the first four of
 * those cards would score if the fifth card were the start card.
 */

public class HandValue_test3
{
    static String[] value = new String[5];//String array for value of cards
    static String[] suit = new String[5];//String array for suit of cards
    static int[] sum = new int[35];//int array to save the sum for each iteration when doing the combinations
    static int score = 0; //initialize the score
    //static String[]numberOnCard= new String[12];
    //static int []realnumber=new int[12];

    /**
     * one for his nob", get one point if the hand contains the jack of the same suit
     * as the start card
     * @return current score
     */
    public static int oneForHisNob() {
        for (int i = 0; i < suit.length - 1; i++) {
            if (value[i].compareTo("J") == 0 && suit[i].compareTo(suit[4]) == 0) {
                score++;
                //System.out.println(score);
            }
        }
        return score;
    }

    /**
     * 4 point is scored if all the cards in the hand are of the same suit and 1 more will be scored
     * if all cards have same suit
     * @return current score
     */
    public static int flush() {
        //4 point is scored if all the cards in the hand are of the same suit and 1 more will be scored
        // if all cards have same suit
        if (suit[0].compareTo(suit[1]) == 0 && suit[1].compareTo(suit[2]) == 0 && suit[2].compareTo(suit[3]) == 0) {
            score = score + 4;
        }

        //all cards are the same suit
        if (suit[0].compareTo(suit[1]) == 0 && suit[1].compareTo(suit[2]) == 0 && suit[2].compareTo(suit[3]) == 0 && suit[3].compareTo(suit[4]) == 0) {
            score = score + 1;
            // System.out.println("score is " + score);
        }
        return score;
    }

    /**
     * 2 points are scored for each combinations of card that add to 15
     * @return current score
     */
    public static int addtoFifteen() {
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == 15) {
                score = score + 2;//for each element in the array"sum" is equal to 15, score+2
            }
        }
        return score;
        // System.out.println("score is " + score);
    }

    /**
     * save the sum for each iteration when doing the combinations
     * author:Peter Schachte <schachte@unimelb.edu.au>
     */
    public static void countSum() {
        int index = 0;
        //converting the String array "value" to an int array called "intValue"
        Integer[] intValue = new Integer[5];
        for (int i = 0; i < value.length; i++) {
            intValue[i] = Integer.parseInt(value[i]);
            // System.out.println(intValue[i]);
        }
        //Integer[] values = new Integer[intValue.length];
        Integer[][] lines = Combinations.<Integer>combinations(intValue);
        for (Integer[] line : lines) {
            sum[index] = 0;
            for (int str : line) {
                sum[index] = sum[index] + str;
            }
            index++;
        }
    }

    /**
     * in this method, we will turn the card value JKQT to 10, and A to 1.
     */
    public static void convertToNumber() {
        for (int i = 0; i < value.length; i++) {
            if (value[i].contains("J") || value[i].contains("Q") || value[i].contains("K") || value[i].contains("T")) {
                value[i] = "10";
                //System.out.println(value[i]);
            } else if (value[i].contains("A")) {
                value[i] = "1";
                //System.out.println(value[i]);·
            }
        }
    }



    /**
     * in this method, we will calculating "pair"
     * @return score after calculating "pair"
     */
    public static int pair(){
        for (int i = 0; i < value.length - 1; i++) {
            for (int j = i + 1; j < value.length; j++) {
                if (value[i].compareTo(value[j]) == 0)
                    score = score + 2;
            }
        }
        return score;
    }

    /**
     * in this method, we will calculating "run"
     * @return score after calculating "run"
     */
    public static int run(){ //未排序，有问题
        int runScore, tempScore = 0;
        int times = 1;
        int[] runArrayLength = new int[30];
        for (int i = 0; i < value.length; i++) {
            Integer[] intValue = new Integer[5];
            for (int j = 0; j < value.length; j++) {
                intValue[j] = Integer.parseInt(value[j]);
                // System.out.println(intValue[i]);
            }
            runArrayLength[intValue[i]] = runArrayLength[intValue[i]] + 1;
        }
        for (int j = 1; j < runArrayLength.length; j++) {
            if (runArrayLength[j] >= 1) {
                times *= runArrayLength[j];
                if (runArrayLength[j - 1] >0&& runArrayLength[j] > 0 && runArrayLength[j + 1] > 0) {
                    if (tempScore > 2) {
                        tempScore++;
                    } else {
                        tempScore = 3;
                    }
                }
            }
        }
        runScore = times * tempScore;
        return score = score + runScore;
    }


    public static void main(String[] args) {
        HandValue_test3 test = new HandValue_test3();
        //*********************FriendsEditor area*************************** C D H S
        //String[] cardTest = {"KH", "JH", "QH", "AH", "1H"};  // 1 nob, 1 flush
        //String[] cardTest = {"AC", "3H", "KH", "7H", "2D"};  //1 run, 1 15
        //String[] cardTest = {"AH", "3H", "KH", "JH", "2H"};
        //String[] cardTest = {"7H", "9S", "8C", "7C", "8H"};
        //{"7C", "QH", "2C", "JC", "9H"};   value 0
        //{"AS", "3H", "KH", "7H", "KS"};   value 2, 1 pair
        //{"AS", "3H", "KH", "7H", "2D"};   value 5, 1 run,1 15
        //{"2S", "3H", "KH", "3S", "4H"};   value 12, 2runs, 1pair, 2 15s
        //{"6C", "7C", "8C", "9C", "8S"};   value 20, 2runs, 1pair, 3 15s,flush
        //{"7H", "9S", "8C", "7C", "8H"};   value 24, 4runs, 2pair, 4 15s,
        //{"5H", "5S", "5C", "JD", "5D"};   value 29, 8 15s, 6pair, 1nob
        //*********************************************************

        //we put every first index of every commandline parameter into an array called "value"
        for (int j = 0; j < 5; j++) {
            value[j] = args[j].valueOf(args[j].charAt(0));
            //  System.out.println(value[j]);
        }
        //we put every second index of every commandline parameter into an array called "suit"
        for (int k = 0; k < 5; k++) {
            suit[k] = args[k].valueOf(args[k].charAt(1));
            // System.out.println(suit[k]);
        }

        test.oneForHisNob();    //count the points for oneForHisNob
        test.pair();            //count the points for pair
        test.convertToNumber(); //convert A to 1, JKQT to 10
        test.flush();           //count the points for flush
        test.countSum();        //count the sum and save it in array called "sum"
        test.addtoFifteen();    //count the points for addtoFifteen
        test.run();             //count the points for run

        System.out.println(score); //print out the final score


    }

}

