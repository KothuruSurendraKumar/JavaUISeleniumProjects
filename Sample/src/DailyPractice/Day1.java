package DailyPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkNumberisPrime(0);
		sortArrayUsingBubbleSort();
		//revrseString();
		checkRoatationOfAnotherString();
		largestNumberInArray();
		fibonacciSeries();
		primeNumbersUptoN();
		//longestSubstringwithoutRepeating();
		countVowelsInString();
		occuranceOfCharacter();
		lengthOfLongestPalindrome();
		rotateArrayBasedOnIndex();
		commonElementsInArray();
		firstRepatingChar();
		// int[] arr = {7,8,2,4,10,6,9};
		int[] arr = { 5, 10, 4, 7, 2, 1 };
		sortArrayUsingQuickSort(arr, 0, arr.length - 1);
		for (int num : arr) {
			System.out.println(num);
		}
		areaOfRectangle();
		areaOfCircle();
		moveAllZerosToEnd();
		removeDulicatedInHashMap();
		reverseEachWordInSenetense();
	}

	private static void reverseEachWordInSenetense() {
		// TODO Auto-generated method stub
		String s = "Surendra is good boy";
		String[] arr = s.split(" ");
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			String rev = revrseString(arr[i]);
			res = res + rev + " ";
			
		}
		System.out.println(res.trim());

	}

	private static void removeDulicatedInHashMap() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("key1", 1);
		map.put("key2", 3);
		map.put("key3", 2);
		map.put("key4", 1);
		map.put("key4", 1);

		Set<Integer> dup = map.values().stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(s -> s.getValue() > 1).map(k -> k.getKey()).collect(Collectors.toSet());
		System.out.println(dup);
		// get the keys which has duplicate values

		Set<String> dupKey = map.entrySet().stream().filter(s -> dup.contains(s.getValue())).map(s -> s.getKey())
				.collect(Collectors.toSet());

		System.out.println(dupKey);

	}

	private static void moveAllZerosToEnd() {
		// TODO Auto-generated method stub
		int[] arr = { 1, 0, 2, 0, 0, 3, 0, 5, 6, 0, 1 };
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
				index++;
			}
		}
		System.out.println(Arrays.toString(arr));

	}

	private static void areaOfCircle() {
		// TODO Auto-generated method stub
		int r = 4;
		double a = 0;
		a = 3.14 * 4 * 4;
		System.out.println("Area of Circle " + a);

	}

	private static void areaOfRectangle() {
		// TODO Auto-generated method stub
		int length = 3, breath = 4;
		System.out.println("Area of rectangle " + length * breath);

	}

	private static void sortArrayUsingQuickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low < high) {
			int piv = quickSort(arr, low, high);
			sortArrayUsingQuickSort(arr, low, piv - 1);
			sortArrayUsingQuickSort(arr, piv + 1, high);
		}

	}

	private static int quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub

		int pivot = arr[low];
		int start = low;
		int end = high;
		while (start < end) {
			while (arr[start] <= pivot && start <= high) {
				start++;
			}
			while (arr[end] > pivot && end >= low) {
				end--;
			}
			if (start < end) {
				swap(arr, start, end);
			}
		}
		swap(arr, low, end);

		return end;
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private static void firstRepatingChar() {
		// TODO Auto-generated method stub
		String s = "kiss"; // o/p:s
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				System.out.println("Repeat char : " + s.charAt(i));
				break;
			}
			set.add(s.charAt(i));
		}
		System.out.println("No repaeating character");

	}

	private static void commonElementsInArray() {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5, 6 };
		int[] a2 = { 6, 7, 8, 9, 1, 2 };

		Set<Integer> set = new HashSet<>();
		Set<Integer> common = new HashSet<>();
		for (int num : a) {
			set.add(num);
		}
		for (int num : a2) {
			if (set.contains(num)) {
				common.add(num);
			}
		}
		System.out.println(common);
		List<Integer> l1 = Arrays.asList(3, 4, 5, 6, 7);
		List<Integer> l2 = Arrays.asList(3, 4, 5, 7, 8, 9);

		Set<Integer> ele = l1.stream().filter(s -> l2.contains(s)).collect(Collectors.toSet());
		System.out.println(ele);

	}

	private static void rotateArrayBasedOnIndex() {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 2;
		reverse(0, arr.length - 1, arr);
		reverse(0,k-1,arr);
		reverse(k,arr.length-1,arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
//		List<Integer> li = Arrays.stream(arr).boxed().collect(Collectors.toList());
//		Collections.rotate(li, k);
//		for (int num : li) {
//			System.out.println(num);
//		}
		
	}

	private static void reverse(int i, int j, int[] arr) {
		// TODO Auto-generated method stub
		for (int k = 0; k < arr.length; k++) {
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

	}

	private static void lengthOfLongestPalindrome() {
		// TODO Auto-generated method stub
		String s = "baabad";
		int n = s.length();
		int start = 0, maxLen = 0;
		boolean[][] dp = new boolean[n][n];
		// if len=1
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		// len is 2
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				start = i;
				maxLen = 2;
			}
		}
		// if len=3
		for (int length = 3; length <= n; length++) {
			for (int i = 0; i <= n - length; i++) {
				int j = i + length - 1;
				if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					start = i;
					maxLen = length;
				}
			}
		}
		System.out.println(s.substring(start, start + maxLen));
	}

	private static void occuranceOfCharacter() {
		// TODO Auto-generated method stub
		String a = "Surendra";
		a.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().forEach(c -> System.out.println(c.getKey() + ":" + c.getValue()));

	}

	private static void countVowelsInString() {
		// TODO Auto-generated method stub
		String a = "Surendra";
		String vowels = "AEIOUaeiou";
		// only vowels
		Map<Boolean, Long> map = a.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> vowels.indexOf(c) != -1, Collectors.counting()));
		Long vowelCount = map.getOrDefault(true, 0L);
		System.out.println("vowelsCount" + vowelCount);
		Long consonentCount = map.getOrDefault(false, 0L);
		System.out.println("ConsonentCount" + consonentCount);

	}

	private static void longestSubstringwithoutRepeating() {
		// TODO Auto-generated method stub
		String s = "abcb";
		int start = 0,maxLen=0,maxStart=0;
		Set<Character> set = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			while(set.contains(c)) {
				set.remove(start);
				start++;
			}
			set.add(c);
			if(i-start+1 > maxLen) {
				maxLen = i-start+1;
				maxStart = start;
			}
		}
		System.out.println(s.substring(maxStart, maxStart+maxLen));

	}

	private static void primeNumbersUptoN() {
		// TODO Auto-generated method stub
		int n = 100;
		for (int i = 1; i < n; i++) {
			if (checkNumberisPrime(i)) {
				System.out.println(i);
			}
		}

	}

	private static void fibonacciSeries() {
		// TODO Auto-generated method stub
		int n = 21;
		int a = 0, b = 1, sum;
		System.out.print("Fibanocci" + a + "," + b);
		for (int i = 2; i < n; i++) {
			sum = a + b;
			System.out.print("," + sum);
			a = b;
			b = sum;
		}

	}

	private static void largestNumberInArray() {
		// TODO Auto-generated method stub
		Integer[] arr = { 2, 4, 6, 7, 9, 10 };
		System.out.println(Collections.max(Arrays.asList(arr)));
		int[] ar = { 2, 65, 43, 12, 78, 90 };
		int res = Arrays.stream(ar).min().getAsInt();
		System.out.println(res);

	}

	private static void checkRoatationOfAnotherString() {
		// TODO Auto-generated method stub
		String s = "Suri";
		String s1 = "uriS";
		String s2 = "iruS";
		String res = s.concat(s);
		if (res.contains(s2)) {
			System.out.println("Yes Rotation of string" + res);
		} else {
			System.out.println("No it's not rotation");
		}

	}

	private static String revrseString(String s) {
		// TODO Auto-generated method stub
		//String s = "Suri";
//		StringBuilder sb = new StringBuilder(s).reverse();
//		System.out.println(sb.toString());
		String sa = "";
		char[] ch = s.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			sa = sa + ch[i];
		}
		System.out.println("reverse String without inbuilt : " + sa);
		return sa;

	}

	private static void sortArrayUsingBubbleSort() {
		// TODO Auto-generated method stub
		int[] arr = { 4, 5, 2, 3, 1 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}

	private static boolean checkNumberisPrime(int a) {
		// TODO Auto-generated method stub
		// int a = 1022;
		if (a < 2)
			return false;
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}
