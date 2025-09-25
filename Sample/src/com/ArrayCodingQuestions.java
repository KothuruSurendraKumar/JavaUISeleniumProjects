package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayCodingQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,6,3,4,5,5,5,5};
		sumOfArray(arr);
		maxAndMinInArray(arr);
		reverseAnArray(arr);
		countEvenAndOdd(arr);
		searchIntInArray(arr);
		frequancyOfElem(arr);
		int[] arr2 = {1,2,3,4,5};
		
		rotateArray(arr2);
		int[] arr3 = {11,13,12,15,14};
		int[] arr4 = {17,16,18,20,19};
		mergeTwoArrays(arr3,arr4);
		findKthLargestElementInArray();

	}

	private static void findKthLargestElementInArray() {
		// TODO Auto-generated method stub
		int[] arr = {2,4,7,1,9,10};
		int n = 3;
		PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
		for(int k:arr) {
			p.add(k);
			if(p.size() > n) {
				p.poll();
			}
		}
		System.out.println(n+"rd largest element is "+p.peek());
		
		
	}

	private static void mergeTwoArrays(int[] arr3, int[] arr4) {
		// TODO Auto-generated method stub
		int[] res = IntStream.concat(Arrays.stream(arr3), Arrays.stream(arr4)).sorted().toArray();
		for(int num : res) {
			System.out.print(num+" ");
			
		}
		List<Integer> l1 = Arrays.asList(1,2,3,4,5);
		List<Integer> l2 = Arrays.asList(1,2,3,6,7);
		List<Integer> l3 = l1.stream().filter(s -> l2.contains(s)).collect(Collectors.toList());
		System.out.println("list"+l3);
	}

	private static void rotateArray(int[] arr2) {
		// TODO Auto-generated method stub
		int n=2;
		reverseAnArray(arr2,0,arr2.length-1);
		reverseAnArray(arr2,0,n-1);
		reverseAnArray(arr2,n,arr2.length-1);
		
		for(int num:arr2) {
			System.out.println(num + " rot");
		}
		
	}

	private static void reverseAnArray(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
		
	}

	private static void frequancyOfElem(int[] arr) {
		// used boxed because of conver Int to Integer
		Map<Integer,Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(c -> c,Collectors.counting()));
		map.forEach((key,value) -> System.out.println(+key+":"+value));
		
 		
	}

	private static void searchIntInArray(int[] arra) {
		// TODO Auto-generated method stub
		int[] arr = {2,4,7,8,3,2,5};
		int n=5;
		int k = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == n) {
				k = i;
				//System.out.println("index is "+i);
				break;
			}
		}
		if(k > 0) {
			System.out.println("index is "+k);
		}else {
			System.out.println("element not found");
		}
		
		
		
	}

	private static void countEvenAndOdd(int[] arr) {
		// TODO Auto-generated method stub
		int even = 0,odd=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] % 2 == 0) {
				even++;
			}else {
				odd++;
			}
		}
		System.out.println(even + " " +odd);
		
	}

	private static void reverseAnArray(int[] arr) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = arr.length-1;
		while(left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
		}
		for(int num : arr) {
			System.out.print("rev"+num + " ");
		}
		
		
	}

	private static void maxAndMinInArray(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int len = arr.length;
		System.out.println("min "+arr[0]);
		System.out.println("Max "+arr[len-1]);
		
	}

	private static void sumOfArray(int[] arr) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
		}
		System.out.println(sum);
		
		List<Integer> l1 = Arrays.asList(1,2,3,4,5,3,4,7);
		Collections.sort(l1);
		System.out.println(l1);
		
	}

}
