package com;

import java.util.Arrays;
import java.util.Scanner;

/*
 * consider arr = [-4,-7,3,-4,2,6,5]
 * smallest missing number is 1 o/p should be 1
 * in arr we have 2,3,5,6 ignore -ve's so 1 is missing 
 * 
 * arr=[1,2,3,4] missing integer is 5
 */

public class SmallestMissingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		int len = in.split(",").length;
		String[] orgArr = in.split(",");
		//System.out.println(len);
		int[] arr = new int[len];
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(orgArr[i].trim());
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		//sort the array
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println("After sort"+arr[i]);
		}
		//remove the neg's
		int[] newArr = Arrays.stream(arr).filter(n -> n >= 0).toArray();
		
		int res = smallestMissingNumber(newArr);
		System.out.println("Missing num "+res);

	}

	private static int smallestMissingNumber(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
//		for(int i=0;i<n;) {
//			//arrange in assending order
//			if(arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i]-1]) {
//				int temp = arr[arr[i] - 1];
//				arr[arr[i] -1] = arr[i];
//				arr[i] = temp;
//			}else {
//				i++;
//			}-5, 2, 0, -1, -10, 15
//			//find index where number is incorrect
//				
//		}
		//find index where number is incorrect
		
		for(int i=0;i<n;i++) {
			if(arr[i] != i+1) {
				return i + 1;
			}
		}
		return n+1;
	}

}
