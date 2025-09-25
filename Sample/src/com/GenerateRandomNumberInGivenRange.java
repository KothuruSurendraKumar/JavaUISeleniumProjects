package com;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumberInGivenRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = 3;
		int max = 50;
		
		int res = getRandomNum(min,max);
		System.out.println("Random Num :"+res);

	}

	private static int getRandomNum(int min, int max) {
		// TODO Auto-generated method stub
		int res = ThreadLocalRandom.current().nextInt(min, max);
		return res;
	}

}
