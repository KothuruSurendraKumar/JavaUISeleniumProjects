package com;

public class ResizeorderInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,55,43,21,47,81,12,14,4,14,18,86,9,34,56,21,33,58,90,87};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		int[] resArr = reordertheArray(arr);
		System.out.println();
		for(int i=0;i<resArr.length;i++) {
			System.out.print(resArr[i] + " ");
		}
	}

	private static int[] reordertheArray(int[] arr) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			if(arr[left] % 2 == 0 && left < right) {
				left++;
			}
			if(arr[right] %2 != 0 && left < right) {
				right--;
			}
			if(left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				//left++;
				//right--;
			}
		}
		return arr;
	}

}
