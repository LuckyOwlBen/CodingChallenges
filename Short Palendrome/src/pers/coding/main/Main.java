package pers.coding.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		int result = Result.shortPalindrome(s);
		System.out.println(String.valueOf(result));
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}

class Result {

	/*
	 * Complete the 'shortPalindrome' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */

	public static int shortPalindrome(String s) {
		final Double tenToTheNineth = Math.pow(10, 9) + 7;
		// s = removeSingulars(s);
		// Map<String, Integer> memoizer = hardCalculatePalendromes(s);
		Map<String, Integer> memoizer = betterCalculatePalendromes(s);
		return memoizer.values().stream().mapToInt(Integer::intValue).sum() % tenToTheNineth.intValue();
	}

	private static Map<String, Integer> betterCalculatePalendromes(String s) {
		Map<String, Integer> memoizer = new HashMap<String, Integer>();
		List<String> workingList = s.chars()
				.mapToObj(element -> new StringBuilder().appendCodePoint(element).toString())
				.collect(Collectors.toList());
		workingList.removeIf(element -> workingList.lastIndexOf(element) == workingList.indexOf(element));
		ListIterator<String> iterator = workingList.listIterator();
		while (iterator.hasNext()) {
			String primary = iterator.next();
			int index = iterator.nextIndex();
			for (String secondary : workingList.subList(index, workingList.size())) {
				for (String third : workingList.subList(index + 1, workingList.size())) {
					for (String fourth : workingList.subList(index + 2, workingList.size())) {
						String currentWord = primary + secondary + third + fourth;
						if (memoizer.containsKey(currentWord)) {
							memoizer.replace(currentWord, memoizer.get(currentWord) + 1);
						} else {
							final boolean compareOneFour = primary.equalsIgnoreCase(fourth);
							final boolean compareTwoThree = secondary.equalsIgnoreCase(third);
							if (compareOneFour && compareTwoThree) {
								memoizer.put(currentWord, 1);
							}
						}
					}
				}
			}
		}
		return memoizer;
	}

	private static Map<String, Integer> hardCalculatePalendromes(String s) {
		Map<String, Integer> memoizer = new HashMap<String, Integer>();
		int numIterations = s.length() - 1;
		List<String> workingList = new ArrayList<>();
		workingList.addAll(s.chars().mapToObj(element -> new StringBuilder().appendCodePoint(element).toString())
				.collect(Collectors.toList()));
		for (int counter = 0; counter <= numIterations; counter++) {
			for (int counter2 = counter + 1; counter2 <= numIterations; counter2++) {
				for (int counter3 = counter2 + 1; counter3 <= numIterations; counter3++) {
					for (int counter4 = counter3 + 1; counter4 <= numIterations; counter4++) {
						String result = workingList.get(counter) + workingList.get(counter2) + workingList.get(counter3)
								+ workingList.get(counter4);
						if (memoizer.containsKey(result)) {
							memoizer.replace(result, memoizer.get(result) + 1);
						} else {
							final boolean compareOneFour = workingList.get(counter)
									.equalsIgnoreCase(workingList.get(counter4));
							final boolean compareTwoThree = workingList.get(counter2)
									.equalsIgnoreCase(workingList.get(counter3));
							if (compareOneFour && compareTwoThree) {
								memoizer.put(result.toString(), 1);
							}
						}
					}
				}
			}
		}
		return memoizer;
	}
}
