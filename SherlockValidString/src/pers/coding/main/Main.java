package pers.coding.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static String isValid(String s) {
		Map<Character, Integer> distMap = new HashMap<Character, Integer>();
		for (int index = 0; index < s.length(); index++) {
			Character currentChar = s.charAt(index);
			distMap.put(currentChar,
					distMap.containsKey(currentChar) ? Integer.sum(1, distMap.get(currentChar).intValue()) : 1);
		}
		int threshold = distMap.get(s.charAt(0));
		boolean everyoneGetsOne = true;
		for (int value : distMap.values()) {
			int comparison = Integer.compare(value, threshold);
			if (comparison != 0) {
				if (everyoneGetsOne && (comparison == 1 || comparison == -1)) {
					everyoneGetsOne = false;
				} else {
					return "NO";
				}
			}
		}
		return "YES";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		System.out.println(isValid(input));
	}

}
