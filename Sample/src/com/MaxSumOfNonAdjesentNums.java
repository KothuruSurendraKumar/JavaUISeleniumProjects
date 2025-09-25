package com;


/*
 * i/p:-2,1,3,-4,5
 * o/p:8
 * 
 * take non-adjesent subsets (-2,3,5 = 6),(1,-4 = -3),(1,5 = 6),(-2,3 = 1),(3,5 = 8),(-2,-4 = -6) 
 * Here max num is 8
 * 
 * Approch :
 * 1.loop an array
 * 2.compare each element with previous element if it is greater then replace with max element
 */

public class MaxSumOfNonAdjesentNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2,1,3,-4,5};
		
		int maxValue = maxSumOfnonAdjesent(arr);
		System.out.println(maxValue);

	}

	private static int maxSumOfnonAdjesent(int[] arr) {
		// TODO Auto-generated method stub
		
		int include = 0;
		int exclude = 0;
		
		for(int i=0;i<arr.length;i++) {
			int newMax = Math.max(exclude, include);
			include = exclude + arr[i];
			exclude = newMax;
		}
		
		return Math.max(exclude, include);
	}

}
