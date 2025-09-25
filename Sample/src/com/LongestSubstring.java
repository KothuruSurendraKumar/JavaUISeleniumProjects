package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 3 };
		int[] arr2 = { 2 ,4};
		String s = "abcabcbb";
		String p = "baabad";
		System.out.println(p.length());
		String res = LongestPalindrom(p);
		System.out.println("Longest Plaindrom "+res);
		//calucalteMedian(arr1,arr2);
//		findLongestSubString(s);
		int len = findLongestSubStringTwo(s);
		System.out.println(len);
		
	}
	
	private static String LongestPalindrom(String p) {
		// TODO Auto-generated method stub
		int n = p.length();
		int start = 0;
		int maxLen = 1;
		boolean[][] dp = new boolean[n][n];
		
		//if len=1
		for(int i=0;i<n;i++) {
			dp[i][i] = true;
		}
		
		//if len=2
		for(int i=0;i<n-1;i++) {
			if(p.charAt(i) == p.charAt(i+1)) {
				dp[i][i+1] = true;
				start = i;
				maxLen = 2;
			}
		}
		
		//if len >2 
		for(int length = 3;length <= n;length++) {
			for(int i=0;i<=n-length;i++) {
				int j = i + length -1;
				if(p.charAt(i) == p.charAt(j) && dp[i+1][j-1]) {
					dp[i][j] = true;
					start = i;
					maxLen = length;
				}
			}
		}
		
		return p.substring(start,start + maxLen);
	}

	private static int findLongestSubStringTwo(String s) {
		int start = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(start));
                start++;
            }

            set.add(c);
            maxLen = Math.max(maxLen,i-start+1);
        }
        return maxLen;
	}

	private static void findLongestSubString(String s) {
		// TODO Auto-generated method stub
		int start = 0;
		int maxLen = 0;
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			while(set.contains(c)) {
				set.remove(s.charAt(start));
				start++;
			}
			set.add(c);
			maxLen = Math.max(maxLen, i-start+1);
		}
		System.out.println(set.toString());
		System.out.println(maxLen);
		
	}

	public static void calucalteMedian(int[] arr1,int[] arr2) {
		

		int[] res = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
		Arrays.sort(res);
		int len = res.length;
		if ((res.length % 2) == 0) {
			int mid1 = res[len / 2 - 1];
			int mid = res[len / 2];
			System.out.println((mid1 + mid) / 2.0);
		} else {
			System.out.println((double)res[len / 2]);
		}
	}

}
