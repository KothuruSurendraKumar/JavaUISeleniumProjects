package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I am am learning learning learning java java java Programming";
		String f = "laptoppppppaaaalllllltttttooooo";
		char[] a1 = {'A','B','D','F'};
		char[] a2 = {'c','e'};
		findDuplicates(s);
		createnewArrayWithCombinationOfTwoArrays(a1,a2);
		int c = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == 'a') {
				c++;
			}
		}
		System.out.println(c);
		System.out.println(s.length());
		String res = s.replaceAll("a", "");
		System.out.println(res.length());
		
		String[] arr = s.split(" ");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int count = 1;
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], count);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		for(String x : map.keySet()) {
			System.out.println(x +":"+map.get(x));
		}

	}

	private static void createnewArrayWithCombinationOfTwoArrays(char[] a1, char[] a2) {
		// TODO Auto-generated method stub
		char[] res = new char[a1.length+a2.length];
		int ires = 0,ia1=0,ia2=0;
		while(ia1 < a1.length && ia2 < a2.length) {
			res[ires++] = a1[ia1++];
			res[ires++] = a2[ia2++];
		}
		while(ia1 < a1.length) {
			res[ires++] = a1[ia1++];
		}
		while(ia2 < a2.length) {
			res[ires++] = a1[ia2++];
		}
		
		for(Character c : res) {
			System.out.println(c);
		}
		
		
	}

	private static void findDuplicates(String f) {
		// TODO Auto-generated method stub
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int count = 1;
		for(int i=0;i<f.length();i++) {
			if(!map.containsKey(f.charAt(i))) {
				map.put(f.charAt(i), count);
			}else {
				map.put(f.charAt(i), map.get(f.charAt(i))+1);
			}
		}
		for(Character c : map.keySet()) {
			//System.out.println(c +":"+map.get(c));
			if(map.get(c) > 1) {
				System.out.println(c +":"+map.get(c));
			}
		}
		
		
	}

}
