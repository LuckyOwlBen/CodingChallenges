package pers.coding.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean aIsBigger = a.length() > b.length();
        String big =  aIsBigger ? a : b;
        String little = aIsBigger ? b : a;
        boolean ret = isAnagram(big, little);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );

	}

	private static boolean isAnagram(String a, String b) {
		String formattedA = a.toLowerCase();
		String formattedB = b.toLowerCase();
		Map<Character, Integer> aMap = mapCharFrequency(formattedA);
		Map<Character, Integer> bMap = mapCharFrequency(formattedB);
		Set<Character> aKeySet = aMap.keySet();
		boolean result = true;
		for(Character aKey : aKeySet) {
			int aValue = 0;
			int bValue = 1;
			if(bMap.containsKey(aKey)) {
				aValue = aMap.get(aKey);
				bValue = bMap.get(aKey);
			}
			boolean valuesMatch = (aValue == bValue);
			if(!valuesMatch) {
				return false;
			}
		}
		return result;
	}

	private static Map<Character, Integer> mapCharFrequency(String a) {
		Map<Character, Integer> standinMap = new HashMap<Character, Integer>();
		char[] aCharArray = a.toCharArray();
		for(char currentChar: aCharArray) {
			if(standinMap.containsKey(currentChar)) {
				standinMap.put(currentChar, standinMap.get(currentChar) + 1);
			} else {
				standinMap.put(currentChar, 1);
			}
		}
		return standinMap;
	}
}
