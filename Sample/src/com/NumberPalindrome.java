package com;

public class NumberPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x= 121;
		int a=x;
		int res = 0;
        while(a != 0){
            int dig = a % 10;
            res = res * 10 + dig;
            a = a/10;
        }
        System.out.println("res "+res +"is equals "+x);
        if(x < 0 ||res != x){
            System.out.println("false");
        }else{
        	System.out.println("true");
        }
        

	}

}
