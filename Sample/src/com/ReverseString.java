package com;

import java.util.stream.Collectors;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String st = "Surendra";
		
		//1st method
		String res = st.chars().mapToObj(s -> (char)s).collect(Collectors.collectingAndThen(Collectors.toList(), list->{
			java.util.Collections.reverse(list);
			return list.stream().map(String::valueOf).collect(Collectors.joining());
		}));
		
		System.out.println(res);
		
		//2nd method
		StringBuilder sb = new StringBuilder(st);
		String r = sb.reverse().toString();
		System.out.println(r);
		
		//3rd method
		String rev = "";
		for(int i=st.length()-1;i>=0;i--) {
			rev = rev + st.charAt(i);
		}
		System.out.println(rev);

	}

}
