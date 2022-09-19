package pers.coding.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// [^>]*
		Scanner in = new Scanner(System.in);
		int numTestCases = Integer.parseInt(in.nextLine());
		List<String> testCases = new ArrayList<String>();
		while (numTestCases > 0) {
			testCases.add(in.nextLine());
			numTestCases--;
		}
		in.close();
		List<String> results = new ArrayList<>();
		for (String testCase : testCases) {
			do {
				int frontTagIndex = testCase.indexOf(">") + 1;
				StringBuilder frontTag = new StringBuilder(testCase.substring(0, frontTagIndex));
				String restofString = testCase.substring(frontTagIndex, testCase.length());
				frontTag.insert(testCase.indexOf("<") + 1, "/");
				if (restofString.contains(frontTag)) {
					testCase = restofString.replaceFirst(frontTag.toString(), "");
					if (!testCase.contains(frontTag)) {
						int splitIndex = testCase.contains("<") ? testCase.indexOf("<") : testCase.length();
						results.add(testCase.substring(0, splitIndex));
						testCase = testCase.substring(splitIndex, testCase.length());
					}
				} else {
					results.add("None");
					break;
				}
			} while (testCase.contains(">"));
		}
		for(String result: results) {
			System.out.println(result);
		}
	}
}
