package pers.coding.main;

import java.util.Scanner;

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
        in.close();

    }
}

class MyRegex {
	public MyRegex() {
		this.pattern = 
				"^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
	            "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
	            "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
	            "([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])$";
	}
	public String pattern;
}