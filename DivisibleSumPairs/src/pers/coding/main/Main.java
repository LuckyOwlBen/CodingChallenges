package pers.coding.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
		// Write your code here
		int count = 0;
		int sum = 0;

		for (int i = 0; i < ar.size(); i++) {
			for (int j = i + 1; j < n; j++) {
				sum = ar.get(i) + ar.get(j);
				if (sum % k == 0) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		List<Integer> ar = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			ar.add(scanner.nextInt());
		}
		scanner.close();
		System.out.println(divisibleSumPairs(n,k,ar));

	}

}
