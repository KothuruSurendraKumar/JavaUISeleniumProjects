package com;

import java.util.Scanner;

/*
 * i/p : 4
 * aab
 * aabbaa
 * ababa
 * aaab
 * 
 * o/p
 * ab
 * aba
 * ababa
 * ab
 * 
 * Remove the duplicaates when we get continously
 */

public class ConvertGoodString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		for(int i=0;i<a;i++) {
			String in = sc.nextLine();
			String res = removeConsequtiveDuplicates(in);
			System.out.println(res);
		}
		
	}

	private static String removeConsequtiveDuplicates(String in) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<in.length();i++) {
			if(i==0 || in.charAt(i) != in.charAt(i-1)) {
				sb.append(in.charAt(i));
			}
		}
		return sb.toString();
	}

}
