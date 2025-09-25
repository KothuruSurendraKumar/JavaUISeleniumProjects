package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodingQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// reverse String
		String r = "Surendraasv";
		reverseString(r);

		// factorial of number
		int n = 5;
		int res = factorialNumber(n);
		System.out.println(res);

		// palindrom
		String p = "aba";
		plaindrom(p);

		int[] arr = { 1, 2, 3, 4, 5, 7 };
		missingNumberInArray(arr);

		int[] arr1 = { 23, 6, 78, 21, 58, 3, 22 };
		int k = 2;
		findKthLargestElement(arr1, k);
		findKthsmallestElement(arr1, k);

		getDuplicateElementsWithCounts(r);
		getOccuranceOfEachElement(r);

		String sr = "I am okay";
		reverseTheWordsInString(sr);
		String na = "automation";
		firstNonRepeatingChar(na);
		String di = "-123456";
		cotainsOnlyDigits(di);
		countVowelsInString(r);
		convertStringToInt(di);
		String a = "I am in Indiaddd";
		String ress = a.replace("d", "D");
		System.out.println("new string" + ress);

		// TODO Auto-generated method stub
		String s = "aabbccdde";
		countOccuranceOfChar(s);
		int[] a1 = { 1, 2, 3, 4, 5 };
		int ka = 2;
		rotateArray(a1, ka);
		String s1 = "silent";String s2 = "listen";
		//contains same characters in both strings irrespective to order
		angramOrNot(s1,s2);
		//longest prefix
		//{"automation","auto","autonoums"} o/p:auto
		String[] pr = {"automation","auto","autonoums"};
		longestPrefix(pr);
		String[] saa = {"apple","mango","banana","apple"};
		removeDuplicateString(saa);
		List<Integer> list1 = Arrays.asList(2,4,6);
        List<Integer> list2 = Arrays.asList(1,3,5,2);
        mergeListsInSorted(list1,list2);
        countDigitsAndConsts();
        
		
//				Map<Character, Long> dup = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//				
//				dup.entrySet().stream().filter(entry -> entry.getValue() >1).forEach(c ->System.out.println(c.getKey()+" "+c.getValue()));
//				dup.entrySet().stream().forEach(c -> System.out.println(c.getKey() +" "+c.getValue()));
//				
//				String b = "2345123";
//				boolean a = b.chars().allMatch(Character::isDigit);
//				System.out.println(a);
//				
//				String d = "swiss";
//				Character res = d.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()
//				.stream().filter(c -> c.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
//				System.out.println("non  :"+res);

	}

	private static void countDigitsAndConsts() {
		// TODO Auto-generated method stub
		String s  ="123abc";
		//char[] ch = s.toCharArray();
		int dig = 0,con = 0;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				dig++;
			}else {
				con++;
			}
		}
		System.out.println(dig + " : "+con);
		
	}

	private static void mergeListsInSorted(List<Integer> list1, List<Integer> list2) {
		// TODO Auto-generated method stub
//		Integer[] arr = Stream.concat(list1.stream(), list2.stream()).sorted().toArray(s -> new Integer[s]);
//		System.out.println(Arrays.toString(arr));
		list1.stream().filter(s -> list2.contains(s)).forEach(s -> System.out.println(s));
	}

	private static void removeDuplicateString(String[] saa) {
		// TODO Auto-generated method stub
		Arrays.stream(saa).distinct().forEach(s -> System.out.println(s));
		int[] arr = {2,54,67,89,3};
		int res = Arrays.stream(arr).min().orElse(Integer.MIN_VALUE);
		System.out.println(res);
		//System.out.println(Collections.max(Arrays.asList(arr)));
		
	}

	private static void longestPrefix(String[] pr) {
		// TODO Auto-generated method stub
		String prefix = pr[0];
		for(String word : pr) {
			while(!word.startsWith(prefix)) {
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) {
					System.out.println("no prefix");
				}
			}
		}
		System.out.println("prefix"+prefix);
		
	}

	private static void angramOrNot(String s1, String s2) {
		// TODO Auto-generated method stub
		if(s1.length() != s2.length()) {
			System.out.println("Not angrams");
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(Arrays.equals(c1, c2)) {
			System.out.println("Angram strings");
		}else {
			System.out.println("Not Angrams");
		}
		
	}

	private static void rotateArray(int[] a1, int k) {
		// TODO Auto-generated method stub
		//k = k % a1.length;
		reverse(a1, 0, a1.length - 1);
		reverse(a1,0,k-1);
		reverse(a1,k,a1.length-1);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]);
		}

	}

	private static void reverse(int[] a1, int i, int j) {
		// TODO Auto-generated method stub
		while (i < j) {
			int temp = a1[i];
			a1[i] = a1[j];
			a1[j] = temp;
			i++;
			j--;
		}

	}

	private static void countOccuranceOfChar(String s) {
		// TODO Auto-generated method stub
		s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().forEach(k -> System.out.println("oc" + k.getKey() + " : " + k.getValue()));

	}

	private static void convertStringToInt(String di) {
		// TODO Auto-generated method stub
		int si = 1, i = 0, res = 0;
		if (i < di.length() && (di.charAt(i) == '-' || di.charAt(i) == '+')) {
			si = di.charAt(i) == '-' ? -1 : 1;
			i++;
		}
		System.out.println(si);

		while (i < di.length() && Character.isDigit(di.charAt(i))) {
			int dig = di.charAt(i) - '0';
			res = res * 10 + dig;
			i++;
		}
		System.out.println(res * si);

	}

	private static void countVowelsInString(String r) {
		// TODO Auto-generated method stub
		String vowels = "aeiouAEIOU";
		long count = r.chars().filter(c -> vowels.indexOf(c) != -1).count();
		System.out.println("vowels " + count);
		// vowels and consonets
		Map<Boolean, Long> map = r.chars().mapToObj(c -> (char) c)
				.collect(Collectors.partitioningBy(c -> vowels.indexOf(c) != -1, Collectors.counting()));
		Long vowelCount = map.getOrDefault(true, 0L);
		Long consonentCount = map.getOrDefault(false, 0L);

		System.out.println(vowelCount + " " + consonentCount);

		int v = 0, co = 0;
		for (char c : r.toCharArray()) {
			if (vowels.indexOf(c) != -1) {
				v++;
			} else {
				co++;
			}
		}
		System.out.println("Vowle count " + v + " consonent Count " + co);

	}

	private static void cotainsOnlyDigits(String di) {
		// TODO Auto-generated method stub
		boolean a = di.chars().allMatch(c -> Character.isDigit(c));
		System.out.println(a);
	}

	private static void firstNonRepeatingChar(String r) {
		// TODO Auto-generated method stub
		Map<Character, Long> map = r.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Character ca = map.entrySet().stream().filter(c -> c.getValue() == 1).map(entry -> entry.getKey()).findFirst()
				.orElse(null);
		for (Map.Entry<Character, Long> m : map.entrySet()) {
			if (m.getValue() == 1) {
				System.out.println("Non repeating: " + m.getKey());
				break;
			}
		}
		System.out.println("non rep:"+ca);

	}

	private static void reverseTheWordsInString(String sr) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(sr).reverse();
		System.out.println(sb.toString());

		String[] sa = sr.split(" ");
		String res = "";
		for (int i = 0; i < sa.length; i++) {
			StringBuilder sq = new StringBuilder(sa[i]).reverse();
			res = res + sq.toString() + " ";
		}
		System.out.println(res.trim());

	}

	private static void getOccuranceOfEachElement(String r) {
		// TODO Auto-generated method stub
		Map<Character, Long> map = r.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.entrySet().stream().forEach(c -> System.out.println(c.getKey() + " " + c.getValue()));
	}

	private static void getDuplicateElementsWithCounts(String r) {
		// TODO Auto-generated method stub

		Map<Character, Long> map = r.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.entrySet().stream().filter(c -> c.getValue() > 1)
				.forEach(c -> System.out.println(c.getKey() + " " + c.getValue()));
	}

	private static void findKthsmallestElement(int[] arr1, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
		for (int num : arr1) {
			min.add(num);
			if (min.size() > k) {
				min.poll();
			}
		}

		System.out.println(min.peek());

	}

	private static void findKthLargestElement(int[] arr1, int k) {
		// TODO Auto-generated method stub
		// As priority Queue will store element in Asce as default

		PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
		for (int num : arr1) {
			min.add(num);
			if (min.size() > k) {
				min.poll();
			}
		}

		System.out.println("small"+min.peek());

	}

	private static void missingNumberInArray(int[] arr) {
		int a = 1;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != a) {
				System.out.println(a);
				break;
			}
			a = a + 1;
		}
		int[] ne = {1,2,4,5};
		int n = ne.length + 1;
		int tot = (n * (n + 1))/2;
		System.out.println("tot"+tot);
		int sum=0;
		for(int i=0;i<ne.length;i++) {
			sum = sum + ne[i];
		}
		int res = tot - sum;
		System.out.println("result "+res);

	}

	private static void plaindrom(String p) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(p).reverse();
		if (sb.toString() == p) {
			System.out.println("String is palindrome");
		} else {
			System.out.println("Not palindrome");
		}

	}

	private static int factorialNumber(int n) {
		// TODO Auto-generated method stub
		if (n == 1) {
			return 1;
		}
		return n * factorialNumber(n - 1);
	}

	private static void reverseString(String r) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(r).reverse();
		System.out.println(sb.toString());

	}

}
