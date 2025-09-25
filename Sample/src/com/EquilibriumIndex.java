package com;

import java.util.Scanner;

/*
 * 3,-4,2,-1,-3,2,1
 * equilibrium index : 2
 * left side 3 + -4 = -1
 * right side -1+-3+2+1 = -1
 * right side == left side so index is 2
 */

public class EquilibriumIndex {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		Scanner sc = new Scanner(System.in);
////		int r = sc.nextInt();
////		int[] arr = new int[r];
////		for(int i=0;i<arr.length;i++) {
////			arr[i] = sc.nextInt();
////		}
//
////		Scanner s = new Scanner(System.in);
////		/* String inputString = s.nextLine(); */
////		String a = s.next();
////		String[] sar = a.split(",");
////		int len = sar.length;
////		int[] arr = new int[len];
////		for (int i = 0; i < len; i++) {
////			arr[i] = Integer.parseInt(sar[i]);
////		}
////		for (int i = 0; i < arr.length; i++) {
////			System.out.println(arr[i]);
////		}
//		int[] arr = {3,-4,2,1,-3,2,-1};
//		int res = equilibriumIndex(arr);
//		System.out.println("res"+res);
//		if(res != -1) {
//			System.out.println("final"+res);
//		}else {
//			System.out.println("index not found");
//		}
//
//	}
//
//	private static int equilibriumIndex(int[] arr) {
//		// TODO Auto-generated method stub
//		int totsum = 0;
//		int leftsum = 0;
//
//		for (int num : arr) {
//			totsum = totsum + num;
//		}
//		System.out.println("tot"+totsum);
//
//		for (int i = 0; i < arr.length; i++) {
//			totsum = totsum - arr[i];
//			if (leftsum == totsum) {
//				return i;
//			}
//			leftsum = leftsum + arr[i];
//		}
//		return -1;
//	}

		Scanner s = new Scanner(System.in);
		/* String inputString = s.nextLine(); */
		String a = s.next();
		String[] sar = a.split(",");
		int len = sar.length;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(sar[i]);
		}

		int res = equlibriumIndex(arr);
		if (res != -1) {
			System.out.println(res);
		} else {
			System.out.println("Index not found");
		}

		// System.out.println("Hello");
	}

	public static int equlibriumIndex(int[] arr) {
		int sum = 0;
		int left = 0;
		for (int i : arr) {
			sum = sum + i;
		}

		for (int i = 0; i < arr.length; i++) {
			sum = sum - arr[i];
			if (left == sum) {
				return i;
			}
			left = left + arr[i];
		}
		return -1;
	}
}
