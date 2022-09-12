package pers.coding.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String a = sc.next();
        sc.close();
        int lastIndex = a.length() - 1;
        int midpoint = (1 + a.length()) / 2;
        String result = "Yes";
        for(int index = 0; index != midpoint; index++, lastIndex--) {
          char firstChar = a.charAt(index);
          char lastChar = a.charAt(lastIndex);
          if(firstChar != lastChar) {
            result = "No";
          }
        }
        System.out.println(result);
	}

}
