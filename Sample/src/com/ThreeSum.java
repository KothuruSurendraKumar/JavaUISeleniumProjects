package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { -4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0 };
		int target = 1;
		//int[] arr = {-1,0,1,2,-1,-4};
		List<List<Integer>> res = threeSum(arr);
		
		int[] nums = {0,0,0,0};
		int result =threeSumClosest(nums,target);
		System.out.println("res"+result);

//		for (List<Integer> li : res) {
//			System.out.println(li);
//		}

	}

	private static int threeSumClosest(int[] nums, int target) {
		// TODO Auto-generated method stub
		int closest = Integer.MAX_VALUE;
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-2;i++) {
			for(int j=i+1;j<nums.length-1;j++) {
				for(int k=j+1;k<nums.length;k++) {
					int add = nums[i] + nums[j] + nums[k];
					if(Math.abs(add-target) < Math.abs(closest - target)) {
						closest = add;
					}
					if(add == target) {
						closest = add;
					}
				}
			}
		}
		return closest;
	}

	private static List<List<Integer>> threeSum(int[] arr) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<>();
		
		Arrays.sort(arr);

		for (int i = 0; i < arr.length-2; i++) {
//			if (i > 0 && arr[i] == arr[i - 1]) {
//                continue;
//            }
			for (int j = i + 1; j < arr.length-1; j++) {
//				if (j > i + 1 && arr[j] == arr[j - 1]) {
//                    continue;
//                }
				for (int k = j + 1; k < arr.length; k++) {
//					if (k > j + 1 && arr[k] == arr[k - 1]) {
//                        continue;
//                    }
					if (arr[i] + arr[j] + arr[k] == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[k]);

						res.add(list);
					}
				}
			}
		}
		List<List<Integer>> uniqueResult = new ArrayList<>();
        for (List<Integer> triplet : res) {
            if (!uniqueResult.contains(triplet)) {
                uniqueResult.add(triplet);
            }
        }

		return uniqueResult;
	}

	private static boolean containsDuplicates(List<List<Integer>> res, List<Integer> list) {
		// TODO Auto-generated method stub
		for (List<Integer> li : res) {
			if (li.containsAll(list)) {
				return true;
			}

		}
		return false;
	}

}
