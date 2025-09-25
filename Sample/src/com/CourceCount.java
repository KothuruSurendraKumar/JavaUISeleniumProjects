package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * consider 
 */

public class CourceCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cources = {{4,18},{3,12},{9,10},{5,20},{10,20},{5,17},{10,19}};
		int co = sheduleCources(cources);
		System.out.println(co);
		

	}

	private static int sheduleCources(int[][] cources) {
		// TODO Auto-generated method stub
		Arrays.sort(cources,(a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int time = 0;
		for(int[] cource : cources) {
			int start = cource[0];
			int end = cource[1];
			
			
			time = time + start;
			q.add(start);
			
			if(time > end) {
				time = time - q.poll();
			}
		}
		
		return q.size();
	}

}
