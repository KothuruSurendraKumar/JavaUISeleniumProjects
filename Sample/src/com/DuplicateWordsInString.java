package com;

import java.util.*;

public class DuplicateWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bad bad baad bbaad baad sad iss iss isss";
		String[] sr = s.split(" ");
		Set<String> set = new HashSet<>();
		for(int i=0;i<sr.length;i++) {
			String a = sr[i];
			if(set.contains(a)) {
				System.out.println("Duplicate String :"+a);
			}
			set.add(a);
		}

	}

}
