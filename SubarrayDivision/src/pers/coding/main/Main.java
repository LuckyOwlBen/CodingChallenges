package pers.coding.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numSquares = scanner.nextInt();
		List<Integer> candyBar = new ArrayList<>();
		for(int i = 0; i < numSquares; i++) {
			candyBar.add(scanner.nextInt());
		}
		int day = scanner.nextInt();
		int month = scanner.nextInt();
		scanner.close();
		int counter = 0;
        for (int i = 0; i <= candyBar.size()-month; i++) {
            if(candyBar.subList(i, i+month).stream().reduce(0, (sub, elem) -> sub + elem) == day){
                counter++;
            }
        }
        System.out.println(counter);
	}

}
