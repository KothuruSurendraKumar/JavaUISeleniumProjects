package com;

/*
 * i/p : 8
 * o/p : 4
 * 
 * How many steps we need to reach reach 0 -> 8 
 * we have only 2 operations you need to add 1 or double the value(nothing but multiply with 2)
 * 
 * step : 1 0 + 1 = 1(if 0 * 2 = 0) so we using add 
 * step : 2 1 * 2 = 2(prefer double.if not use add)
 * step : 3 2 * 2 = 4
 * step : 4 4 * 2 = 8
 * it taken 4 steps so otput is 4
 * 
 * in same way 0 -> 6
 * step : 1 : 0 + 1 = 1
 * step : 2 : 1 * 2 = 2
 * step : 3 : 2 * 2 = 4
 * step : 4 : 4 * 2 = 8(it's going high) 4 + 1 =5
 * step : 5 : 5 + 1 = 6 
 * it taken 5 steps .if it big num steps will increase
 * 
 * the best way is 6 is even num divide by 2 as it is one operation increase count
 * if num is odd sub with 1 and increase count
 * 
 */


public class GetMinCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int res = minCount(13);
		System.out.println(res);

	}

	private static int minCount(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		
		/*
		 * 1st 6/2 = 3 increase count - 1
		 * now num is 3 is odd then sub by 1 increase count - 2
		 * now num is 2 even then divide by 2 increase count - 3
		 * now num is 1 odd sub by 1 then 1 -1 0 increase count - 4
		 * total 4
		 */
		
		while(n!=0) {
			if(n%2 == 0) { 
				n = n/2;
			}else {
				n = n-1;
			}
			count ++;
		}
		return count;
	}

}
