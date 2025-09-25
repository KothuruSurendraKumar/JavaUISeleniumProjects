package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Normal {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		LinkedList<Integer> l1 = new LinkedList<>();
//		l1.add(2);
//		l1.add(4);
//		l1.add(3);
//		LinkedList<Integer> l2 = new LinkedList<>();
//		l2.add(5);
//		l2.add(6);
//		l2.add(4);
//		
//		
//		int res = getAddOfTwoLists(l1,l2);
//		System.out.println(res);
//		LinkedList<Integer> list = convertIntToList(res);
//		Collections.reverse(list);
//		System.out.println("list"+list);
//
//	}
//	public static void main(String[] args) {
//		int num = 1234;
//		int rev =  reverseInt(num);
//		System.out.println(rev);
//		
//	}

	public static int reverseInt(int num) {
		int rev = 0;
		while (num != 0) {
			int dig = num % 10;
			rev = rev + 10 + dig;
			dig = dig / 10;
		}
		return rev;
	}

//	private static LinkedList<Integer> convertIntToList(int res) {
//		// TODO Auto-generated method stub
//		LinkedList<Integer> list = new LinkedList<>();
//		if(res == 0) {
//			list.add(0);
//		}
//		while(res > 0) {
//			list.addFirst(res % 10);
//			res = res/10;
//		}
//		
//		return list;
//	}
//
//	private static int getAddOfTwoLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
//		// TODO Auto-generated method stub
//		int num1 = convertListToInt(l1);
//		System.out.println("1st"+num1);
//		int num2 = convertListToInt(l2);
//		System.out.println("2nd"+num2);
//		int res = num1+num2;
//		System.out.println("res"+res);
//		return res;
//	}
//
//	private static int convertListToInt(LinkedList<Integer> l1) {
//		// TODO Auto-generated method stub
//		int res = 0;
//		int mul = 1;
//		for(int i=0;i<l1.size();i++) {
//			res = res + l1.get(i) * mul;
//			mul = mul * 10;
//		}
//		return res;
//	}
	// regex pattren matches
//	public static void main(String[] args) {
//		System.out.println("Hello!!!");
//		String a = "aa";
//		String b = "a";
//		boolean c = a.matches(b);
//		System.out.println("result "+c);
//	}

//	public static void main(String[] args) {
//		int[] arr = {1,8,6,2,5,4,8,3,7};
//		int area = maxHeightOfTank(arr);
//		System.out.println("area "+area);
//	}

	private static int maxHeightOfTank(int[] arr) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = arr.length - 1;
		int area = 0;

		while (i < j) {
			int tank = Math.min(arr[i], arr[j]);
			area = Math.max(area, tank * (j - i));
			if (arr[i] < arr[j]) {
				i++;
			} else {
				j--;
			}
		}
		return area;
	}

//public static void main(String[] args) {
//	String roman = "MMMDCCXLIX";
//	int res = romanToInteger(roman);
//	System.out.println("res "+res);
//}

	private static int romanToInteger(String roman) {
		// TODO Auto-generated method stub

		java.util.Map<Character, Integer> romanMap = new java.util.HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		int res = 0;
		for (int i = 0; i < roman.length(); i++) {
			int cur = romanMap.get(roman.charAt(i));
//    	int j = i +1;
//    	int c = romanMap.get(roman.charAt(i+1));
			if (i + 1 < roman.length() && cur < romanMap.get(roman.charAt(i + 1))) {
				res = res - cur;
			} else {
				res = res + cur;
			}
		}

		return res;
	}
//	public static void main(String[] args) {
//		String[] str = {"flower","flow","flight"};
//		String res = longestCommonPrefix(str);
//		System.out.println("res "+res);
//	}

	private static String longestCommonPrefix(String[] str) {
		if (str.length == 0 || str == null) {
			return "";
		}
		String prefix = str[0];
		for (int i = 1; i < str.length; i++) {
			while (str[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}

		return prefix;
	}

//	public static void main(String[] args) {
//		String s = "abc";
//		convertFirstLetterInUppercase(s);
//	}

	private static void convertFirstLetterInUppercase(String s) {
		// TODO Auto-generated method stub
		String cap = s.substring(0, 1).toUpperCase() + s.substring(1);
		System.out.println(cap);

	}

//	public static void main(String[] args) {
//		String s = "abc bcd egf";
//		reverseStringWordsUsingCollections(s);
//		reverseStringWordsUsingStreams(s);
//	}

	private static void reverseStringWordsUsingStreams(String s) {
		// TODO Auto-generated method stub
		String[] arr = s.split(" ");
		String res = Arrays.stream(arr).sorted(Collections.reverseOrder()).collect(Collectors.joining(" "));
		System.out.println("Streams "+res);
		
	}

	private static void reverseStringWordsUsingCollections(String s) {
		// TODO Auto-generated method stub
		String[] arr = s.split(" ");
		List<String> list = new ArrayList<String>();
		for(String st:arr) {
			list.add(st);
		}
		Collections.reverse(list);
		String res = String.join(" ", list);
		System.out.println(res);
		
	}
	
	public static void main(String[] args) {
		String s = "Rerr";
		int n =7;
		int[] arr = {1,2,0,5,7,0,3,6,10,54,5,7,8};
		//printUniqueValues(s);
		//moveZerosToLast(arr);
		String b ="LongestSubstringFindOut";
		//LongestSubString(b);
		//reverseString(s);
		//LargestElementInArray(arr);
		//Palindrom(s);
		int a = Factorial(n);
		//System.out.println(a);
		//printFibbanocci(n);
		
		System.out.println("before sorting");
		printArray(arr);
		BubbleSort(arr);
		printArray(arr);
	}

	

	private static void BubbleSort(int[] arr) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}

	private static void printFibbanocci(int n) {
		// TODO Auto-generated method stub
		int first = 0,second = 1 ,next = 0;
		if(n >= 1) {
			System.out.println(first + " ");
		}
		if(n >= 2) {
			System.out.println(second + " ");
		}
		for(int i=0;i<n;i++) {
			next = first + second;
			System.out.println(next + " ");
			first = second;
			second = next;
		}
		
	}

	private static int Factorial(int n) {
		// TODO Auto-generated method stub
		if(n == 1) {
			return n;
		}
		
		return n * Factorial(n-1);
	}

	private static void Palindrom(String s) {
		// TODO Auto-generated method stub
		StringBuilder st = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			st.append(s.charAt(i));
		}
		st.reverse();
		if(st.toString().equalsIgnoreCase(s)) {
			System.out.println("yes");
		}else {
			System.out.println("No");
		}
		
		
	}

	private static void LargestElementInArray(int[] arr) {
		// TODO Auto-generated method stub
		int a =0;
		for(int i=0;i<arr.length;i++) {
			if(a < arr[i]) {
				a = arr[i];
			}
		}
		
		System.out.println(a);
	}

	private static void reverseString(String s) {
		// TODO Auto-generated method stub
		StringBuilder st = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			st.append(s.charAt(i));
		}
		st.reverse();
		System.out.println(st.toString());
		
	}

	private static void LongestSubString(String b) {
		// TODO Auto-generated method stub
		Set<Character> set = new HashSet<>();
		int start = 0;
		int maxLen = 0;
		int maxStart = 0;
		for(int i=0;i<b.length();i++) {
			while(set.contains(b.charAt(i))) {
				set.remove(b.charAt(start));
				start++;
			}
			set.add(b.charAt(i));
			if(i - start +1 > maxLen) {
				maxLen = i - start +1;
				maxStart = start;
			}
		}
		String ress = b.substring(maxStart , maxStart +maxLen);
		System.out.println(ress);
		
		
	}

	private static void moveZerosToLast(int[] arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		while(count < arr.length) {
			arr[count++] = 0;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i] + " ");
		}
		
	}

	private static void printUniqueValues(String s) {
		// TODO Auto-generated method stub
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0;i<s.length();i++) {
			set.add(Character.toLowerCase(s.charAt(i)));
		}
		
		List<Character> list2 = new ArrayList<>(set);
		Collections.sort(list2);
		for(Character c : list2) {
			System.out.println(c);
		}
		
		
	}

	
}
