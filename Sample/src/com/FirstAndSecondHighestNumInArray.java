package com;

import java.util.Arrays;
import java.util.Comparator;

public class FirstAndSecondHighestNumInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr = {2,5,6,1,3,3,7,8};
		/*
		 * 1.get unique elements
		 * 2.sort the array in dec order
		 * 3.get 1st 2 elements
		 * */
		
		Integer[] res = Arrays.stream(arr).distinct().sorted(Comparator.reverseOrder()).limit(2).toArray(Integer[]::new);
		
		System.out.println(Arrays.toString(res));
		
		
		
		    

	}

}
