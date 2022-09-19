package pers.coding.main;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static String highestValuePalindrome(String str, int n, int k) {
		// Write your code here
		StringBuilder strB = new StringBuilder(str);
		HashSet<Integer> visitedStore = new HashSet<>(n / 2);
		for (int i = 0; i < n / 2; i++) {
			if (str.charAt(i) != str.charAt(n - i - 1)) {
				int max = Math.max(Integer.valueOf(str.charAt(i)), str.charAt(n - i - 1));
				strB.setCharAt(i, (char) max);
				strB.setCharAt(n - i - 1, (char) max);
				visitedStore.add(i);
				k = k - 1;
				if (k < 0) {
					System.out.println("-1");
					return "-1";
				}
			}
		}
		for (int i = 0; i < n / 2; i++) {
			if (k > 0) {
				if (visitedStore.contains(i)) {
					if (strB.charAt(i) == '9') {
						continue;
					} else {
						strB.setCharAt(i, '9');
						strB.setCharAt(n - i - 1, '9');
						k = k - 1;
					}
				} else if (k > 1) {
					if (strB.charAt(i) == '9') {
						continue;
					} else {
						strB.setCharAt(i, '9');
						strB.setCharAt(n - i - 1, '9');
						k = k - 2;
					}
				}
			}
		}
		if (k > 0 && n % 2 == 1) {
			strB.setCharAt(n / 2, '9');
		}
		System.out.println(strB.toString());
		return strB.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		String s = scanner.nextLine();
		scanner.close();
		System.out.println(highestValuePalindrome(s, n, k));
	}
}
