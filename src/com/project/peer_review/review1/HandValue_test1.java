package com.project.peer_review.review1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class provide for calculating handvalue 
 *
 * Created by SHuhao Zhou and Peter Schachte
 * StudentID : 949045
 *
 * @author Shuhao Zhou <shuhaoz1@student.unimelb.edu.au> Peter Schachte schachte@unimelb.edu.au
 */

public class HandValue_test1 {

	private static String[] ranks;
	private static String[] suits;
	private static String[][] ranksCombination;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] card = new String[5];
		card[0] = scan.next();
		card[1] = scan.next();
		card[2] = scan.next();
		card[3] = scan.next();
		card[4] = scan.next();

		ranks = new String[5];
		suits = new String[5];

		for (int i = 0; i < 5; i++) {
		// Break the given input to rank and the suit
			ranks[i] = card[i].substring(0, 1);
			suits[i] = card[i].substring(1);
		}
		ranksCombination = Combinations.combinations(ranks);

		int result = 0;
		// result = scoreFifteens(suits, ranks) +scorePairs(suits, ranks) +scoreFlushes(suits, ranks)
		// +scoreRuns(suits, ranks) +oneForHisNob(suits, ranks);
		result = scoreFifteens(suits, ranks) + oneForHisNob(suits, ranks) + scoreFlushes(suits, ranks) + scoreRuns(suits, ranks)
				+ scorePairs(suits, ranks);
		System.out.println(result);
		System.out.println("F15 " + scoreFifteens(suits, ranks));
		System.out.println("oneForHisNob " + oneForHisNob(suits, ranks));
		System.out.println("scoreFlushes" + scoreFlushes(suits, ranks));
		System.out.println("scoreRuns " + scoreRuns(suits, ranks));
		System.out.println("scorePairs " + scorePairs(suits, ranks));
	}

	// calculate the value if score fifteens
	public static int scoreFifteens(String[] suits, String[] r) {
		int valueMax = 15;
		int result = 0;
		for (String[] ranks : ranksCombination) {
			int tempScore = 0;
			for (String rank : ranks) {
				tempScore += getString(rank).faceValue();
			}
			if (tempScore == valueMax) {
				result += 2;
			}
		}

		return result;
	}
	// calculate the value if score pairs

	public static int scorePairs(String[] suits, String[] ranks) {
		int[] a = new int[8];
		for (int i = 0; i < 5; i++) {
			if (ranks[i].equals("J")) {
				a[i] = 11;
			} else if (ranks[i].equals("Q")) {
				a[i] = 12;
			} else if (ranks[i].equals("K")) {
				a[i] = 13;
			} else if (ranks[i].equals("A")) {
				a[i] = 1;
			} else if (ranks[i].equals("T")) {
				a[i] = 10;
			} else {
				a[i] = Integer.parseInt(ranks[i]);
			}
		}
		for (int j = 5; j < 8; j++) {
			a[j] = 100;
		}
		int count = 0;
		Arrays.sort(a);
		// this is for FriendsEditor use for(int i=0;i<8;i++) {
		// this is for FriendsEditor use System.out.println(a[i]);}
		for (int i = 0; i < 4; i++) {
			if (a[i] == a[i + 1]) {
				if (a[i] == a[i + 3]) {
					count = count + 6;
					// this is for FriendsEditor use System.out.println("count +6");
					break;
				} else {
					if (a[i] == a[i + 2]) {
						count = count + 3;
						// this is for FriendsEditor use System.out.println("count +3");
					} else {
						count++;
						// this is for FriendsEditor use System.out.println("count +1");
					}
				}
			}
			// this is for FriendsEditor use System.out.println(i);
		}

		return count * 2;
	}

	// to calculate runs. for example, , card rank 2,3,4,5,6 means 11111
	//2,3,4,7,9 means 11100, 2,3,4,5,7 means 11110,2,3,4,4,7 means 1120, 2,3,4,4,4 means 113,etc.

	public static int scoreRuns(String[] suits, String[] ranks) {

		int[] a = new int[5];
		for (int i = 0; i < 5; i++) {
			if (ranks[i].equals("J")) {
				a[i] = 11;
			} else if (ranks[i].equals("Q")) {
				a[i] = 12;
			} else if (ranks[i].equals("K")) {
				a[i] = 13;
			} else if (ranks[i].equals("A")) {
				a[i] = 1;
			} else if (ranks[i].equals("T")) {
				a[i] = 10;
			} else {
				a[i] = Integer.parseInt(ranks[i]);
			}
		}
		Arrays.sort(a);
		// for (int i = 0; i < 5; i++) {
		// System.out.println(a[i]);
		// }
		// 11111
		if ((a[1] == a[0] + 1) && (a[2] == a[0] + 2) && (a[3] == a[0] + 3) && (a[4] == a[0] + 4)) {
			return 5;
		}
		// 1112
		if ((a[1] == a[0] + 1) && (a[2] == a[0] + 2) && (a[3] == a[0] + 3) && (a[4] == a[3])) {
			return 8;
		}
		// 11110
		if ((a[1] == a[0] + 1) && (a[2] == a[0] + 2) && (a[3] == a[0] + 3) && (a[4] != a[3]) && (a[4] != a[3] + 1)) {
			return 4;
		}
		// 113
		if ((a[1] == a[0] + 1) && (a[2] == a[0] + 2) && (a[3] == a[2]) && (a[4] == a[3])) {
			return 9;
		}
		// 1120
		if ((a[1] == a[0] + 1) && (a[2] == a[1] + 1) && (a[3] == a[2]) && (a[4] != a[3] + 1) && (a[4] != a[3])) {
			return 6;
		}
		// 11100
		if ((a[1] == a[0] + 1) && (a[2] == a[1] + 1) && (a[3] != a[2] + 1) && (a[3] != a[2])) {
			return 3;
		}
		// 01111
		if ((a[1] != a[0] + 1) && (a[1] != a[0]) && (a[2] == a[1] + 1) && (a[3] == a[2] + 1) && (a[4] == a[3] + 1)) {
			return 4;
		}
		// 0112
		if ((a[1] != a[0] + 1) && (a[1] != a[0]) && (a[2] == a[1] + 1) && (a[3] == a[1] + 2) && (a[4] == a[3])) {
			return 6;
		}
		// 01110
		if ((a[1] != a[0] + 1) && (a[1] != a[0]) && (a[2] == a[1] + 1) && (a[3] == a[2] + 1) && (a[4] != a[3] + 1)
				&& (a[4] != a[3])) {
			return 3;
		}
		// 00111
		if ((a[2] != a[1] + 1) && (a[2] != a[1]) && (a[3] == a[2] + 1) && (a[4] == a[3] + 1)) {
			return 3;
		}
		// 1210
		if ((a[1] == a[0] + 1) && (a[2] == a[1]) && (a[3] == a[2] + 1) && (a[4] != a[3] + 1) && (a[4] != a[3])) {
			return 6;
		}
		// 122
		if ((a[1] == a[0] + 1) && (a[2] == a[1]) && (a[3] == a[2] + 1) && (a[4] == a[3])) {
			return 12;
		}
		// 0121
		if ((a[1] != a[0] + 1) && (a[1] != a[0]) && (a[2] == a[1] + 1) && (a[3] == a[2]) && (a[4] == a[3] + 1)) {
			return 6;
		}
		// 2110
		if ((a[1] == a[0]) && (a[2] == a[1] + 1) && (a[3] == a[2] + 1) && (a[4] != a[3] + 1) && (a[4] != a[3])) {
			return 6;
		}
		// 2111
		if ((a[1] == a[0]) && (a[2] == a[1] + 1) && (a[3] == a[2] + 1) && (a[4] == a[3] + 1)) {
			return 8;
		}
		// 212
		if ((a[1] == a[0]) && (a[2] == a[1] + 1) && (a[3] == a[2] + 1) && (a[4] == a[3])) {
			return 12;
		}
		// 221
		if ((a[1] == a[0]) && (a[2] == a[1] + 1) && (a[3] == a[2]) && (a[4] == a[3] + 1)) {
			return 12;
		}
		// 0211
		if ((a[1] != a[0] + 1) && (a[1] != a[0]) && (a[2] == a[1]) && (a[3] == a[2] + 1) && (a[4] == a[3] + 1)) {
			return 6;
		}
		// 131
		if ((a[1] == a[0] + 1) && (a[2] == a[1]) && (a[3] == a[2]) && (a[4] == a[3] + 1)) {
			return 12;
		}
		// 311
		if ((a[1] == a[0]) && (a[2] == a[1]) && (a[3] == a[2] + 1) && (a[4] == a[3] + 1)) {
			return 12;
		}

		return 0;
	}
    // calculate the value for runs
	public static boolean checkscoreRuns(int[] a) {
		int checkValue = a[0];
		int checkCount = 1;

		for (int i = 1; i < a.length; i++) {
			if (a[i] == checkValue + 1) {
				checkCount += 1;
			}
			checkValue = a[i];
		}

		if (checkCount == a.length) {
			return true;
		}

		return false;

	}
	// calculate flushes
	public static int scoreFlushes(String[] suits, String[] ranks) {
		if ((suits[0].equals(suits[1])) && (suits[1].equals(suits[2])) && (suits[2].equals(suits[3]))) {
			if (suits[3].equals(suits[4])) {
				return 5;
			}
			return 4;
		}
		return 0;
	}
	// calculate one for his nob
	public static int oneForHisNob(String[] suits, String[] ranks) {

		String b = "J";
		for (int i = 0; i < 4; i++) {
			if ((suits[i].equals(suits[4])) && (ranks[i].equals(b))) {
				return 1;

			}
		}
		return 0;
	}
	//
	public static CribbageRank getString(String str) {
		for (CribbageRank crib : CribbageRank.values()) {
			if (crib.abbrev() == str.charAt(0)) {
				return crib;
			}
		}
		return null;
	}
}