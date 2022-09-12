package pers.coding.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        s = s.trim();
        if(!s.isEmpty()) {
        	String[] splitList = s.split("[ !,?._'@]+");
        	System.out.println(splitList.length);
        	for(String token : splitList) {
        		System.out.println(token);
        	}
        } else {
        	System.out.println(0);
        }
    }
}
