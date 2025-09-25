package com;

import java.util.Arrays;
import java.util.Scanner;

public class DefeatVillans {

	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int h = s.nextInt();
        int m = s.nextInt();
        
       int[] vhealth = new int[v];
      
       for(int i=0;i<v;i++){
         vhealth[i] = s.nextInt();
       }
      Arrays.sort(vhealth);
       int defeat = 0;
       for(int vi : vhealth){
         if(m > vi){
           defeat++;
           m--;
         }else if(m == vi){
           defeat++;
           break;
         }else{
           break;
         }
       }
		
		
		System.out.println(defeat);
	}
}
