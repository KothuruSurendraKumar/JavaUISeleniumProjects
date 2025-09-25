package com;

import java.util.Scanner;

public class MatchWins {

	public static void main (String[] args) throws java.lang.Exception
    {
        
        Scanner s = new Scanner(System.in);
        /*String inputString = s.nextLine();*/
        int a = s.nextInt();
        int[] arr = new int[a];
        for(int i=0;i<a;i++){
            arr[i] = s.nextInt();
        }
        int m = s.nextInt();
        int[] mrr = new int[m];
        for(int i=0;i<a;i++){
            mrr[i] = s.nextInt();
        }
        String st = s.next();
        matchWins(arr,mrr,st);
        //System.out.println("Hello");
    }

	private static void matchWins(int[] arr, int[] mrr, String st) {
		// TODO Auto-generated method stub
		int index = st.equals("Even") ? 0 : 1;
		int a = 0;
		int m = 0;
		
		for(int i=index;i<arr.length;i += 2) {
			int diff = arr[i] - mrr[i];
			if(diff == 0) {
				continue;
			}else if(diff < 0) {
				m++;
			}else {
				a++;
			}
		}
		if( a > m) {
			System.out.println("Andrea");
		}else if(a < m) {
			System.out.println("Maria");
		}else {
			System.out.println("Tie");
		}
		
	}
    
    

}
