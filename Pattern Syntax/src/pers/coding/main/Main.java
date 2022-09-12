package pers.coding.main;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		for(; testCases > 0; testCases--) {
			String pattern = in.nextLine();
			//For some reason in.close at the bottom doesn't count.
			if(testCases == 1) {
				in.close();
			}
			try {
				Pattern suggestedPattern = Pattern.compile(pattern);
				System.out.println("Valid");
			} catch(Exception e) {
				System.out.println("Invalid");
			}
		}
		in.close();
	}
}
