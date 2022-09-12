package com.coding.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    String s = scan.next();
	    int k = scan.nextInt();
	    scan.close();
	    System.out.println(getSmallestAndLargest(s, k));
	}

	private static String getSmallestAndLargest(String s, int k) {
	    List<String> resultSet = determinePossibleResults(s, k);
	    return buildResultString(resultSet);
	}
	
	private static String buildResultString(List<String> resultSet) {
		String smallest = resultSet.get(0);
		String largest = resultSet.get(resultSet.size() - 1);
		for(String currentElement : resultSet) {
			if(smallest.compareTo(currentElement) > 0) {
				smallest = currentElement;
			} else if(largest.compareTo(currentElement) < 0) {
				largest = currentElement;
			}
		}
		return smallest + "\n" + largest;
	}

	private static List<String> determinePossibleResults(String s, int k) {
		List<String> resultSet = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
	        for(int j = i + 1; j <= s.length(); j++) {
	        	String word = s.substring(i,j);
	        	if(word.length() == k) {
	        		resultSet.add(word);
	        	}
	        }
	    }
		return resultSet;
	}
}
