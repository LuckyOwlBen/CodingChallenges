package pers.coding.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static int sherlockAndAnagrams(String s) {
		Map<String, Integer> dictionary = new HashMap<String,Integer>();
		for(int x = 0; x < s.length(); x++) {
			for(int y = x + 1; y < s.length(); y++) {
				String subString = s.substring(x,y);
				if(isAnagram(subString)) {
					dictionary.put(subString, dictionary.containsKey(subString) ? dictionary.get(subString) + 1 : 1);
				}
			}
		}
		return 0;
	}

	private static boolean isAnagram(String subString) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		List<String> queryList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int numQueries = scanner.nextInt();
		scanner.nextLine();
		for (int index = 0; index < numQueries; index++) {
			queryList.add(scanner.nextLine());
		}
		scanner.close();
		for(String s : queryList) {
			System.out.println(sherlockAndAnagrams(s));
		}
	}

}
