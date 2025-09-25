package com;

import java.util.Arrays;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String res = zigzagConversion(s,numRows);
		System.out.println(res);

	}

	private static String zigzagConversion(String s, int numRows) {
		// TODO Auto-generated method stub
		//if rows= 1
		String arr[] = new String[s.length()];
		Arrays.fill(arr, "");
		if(numRows == 1) {
			return s;
		}
		
		int i=0,cur=0,mod=0;
		int dir[] = {1,-1};
		
		while(i < s.length()) {
			arr[cur] = arr[cur] + s.charAt(i);
			i++;
			int newRow = cur + dir[mod];
			if(newRow < 0 || newRow >= numRows) {
				mod = (mod + 1)%2;
				newRow = cur + dir[mod];
			}
			cur = newRow;
		}
		String res ="";
		for(String st : arr) {
			res = res + st;
		}
		
		return res;
	}

}
