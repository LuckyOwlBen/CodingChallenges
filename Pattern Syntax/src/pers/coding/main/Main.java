package pers.coding.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<String> masterList = new ArrayList<>();
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			masterList.add(in.nextLine());
			testCases--;
		}
		in.close();
		for (String pattern : masterList) {
			try {
				@SuppressWarnings("unused")
				Pattern suggestedPattern = Pattern.compile(pattern);
				System.out.println("Valid");
			} catch (Exception e) {
				System.out.println("Invalid");
			}
		}
	}
}
