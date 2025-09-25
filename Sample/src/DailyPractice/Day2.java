package DailyPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Day2 {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		//Write a program to check if a number is prime.
		primeOrNot();
		fibbanocci();
		reverseStringWithoutInbuilt();
		secondLargestInArray();
		duplicatElement();
		commonElementsTwoArrays();
		countEachOccuranceOfString();
		longestSubstring();
		missingNumberInArr();
		//JsonToObject();
		duplicateCharString();
		getIndexOfNumber();
		removeNonAlphabaticChars();
		firstNonRepeatingChar();
		repeatingChars();

	}

	private static void repeatingChars() {
		// TODO Auto-generated method stub
		String s = "performance";
		Map<Character,Long> map = s.chars().mapToObj(c ->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		for(Map.Entry<Character, Long> m :map.entrySet()) {
			if(m.getValue() > 1) {
				System.out.println("Repeating chars : "+m.getKey());
			}
		}
		
	}

	private static void firstNonRepeatingChar() {
		// TODO Auto-generated method stub
		//i/p:automation o/p:u
		String s = "automation";
		Map<Character, Long> map = s.chars().mapToObj(c ->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		for(Map.Entry<Character, Long> m:map.entrySet()) {
			if(m.getValue() == 1) {
				System.out.println("Non repeating: "+m.getKey());
				break;
			}
			
		}
		
	}

	private static void removeNonAlphabaticChars() {
		//i/p:Hel@lo123 o/p:Hello
		String s = "Hel@lo123";
		String k = s.replaceAll("[^a-zA-Z]","");
		System.out.println(k);
		
	}

	private static void getIndexOfNumber() {
		// TODO Auto-generated method stub
		int[] arr= {10,20,30,40,40,20,10};
		int num=20;
		List<Integer> li = new ArrayList<>();
		for(int i=0; i < arr.length;i++) {
			if(arr[i] == num) {
				li.add(i);
			}
		}
		System.out.println(li);
		
	}

	private static void duplicateCharString() {
		// TODO Auto-generated method stub
		String s = "abcdabcdddd";
		char[] ch = s.toCharArray();
		Set<Character> sc = new HashSet<Character>();
		for(int i=0;i<ch.length;i++) {
			if(!sc.contains(ch[i])) {
				sc.add(ch[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Character c : sc) {
			sb.append(c);
		}
		System.out.println(sb.toString());
		
	}

	private static void JsonToObject() throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper map = new ObjectMapper();
		//object to Jaon
		Person p = new Person("suri","kumar");
		String jsonType = map.writeValueAsString(p);
		System.out.println(jsonType);
		
		
	}

	private static void missingNumberInArr() {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int n = arr.length+1;
		int tot = n * (n + 1) / 2;
		int summ = 0;
		int sum = Arrays.stream(arr).sum();
//		for(int num : arr) {
//			summ = summ+num;
//		}
		int res  = tot - sum;
		System.out.println("missing :"+res);
		
	}

	private static void longestSubstring() {
		// TODO Auto-generated method stub
		String s = "abcdabcbb";
		int stat = 0;
		int maxLen = 0;
		int maxStat = 0;
		Set<Character> set = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			while(set.contains(c)) {
				set.remove(s.charAt(stat));
				stat++;
			}
			set.add(c);
			if(i-stat+1 > maxLen) {
				maxLen = i-stat+1;
				maxStat = stat;
			}
		}
		System.out.println(s.substring(maxStat, maxStat+maxLen));
		
		
	}

	private static void countEachOccuranceOfString() {
		// TODO Auto-generated method stub
		String s = "aaabbccddefffff";
		Map<Character,Long> map = s.chars()
				.mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Entry<Character, Long> m = map.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow(() -> new NoSuchElementException("element not found"));
		
		System.out.println(m.getKey()+" "+m.getValue());
		String ka = "abdabdabdabdca";
		char c = ' ';
		long maxCount = 0;
		for(Map.Entry<Character, Long> ma : map.entrySet()) {
			if(ma.getValue() > maxCount) {
				maxCount = m.getValue();
				c = ma.getKey();
			}
			
		}
		System.out.println("max char "+c);
		
	}

	private static void commonElementsTwoArrays() {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int[] arr2 = {2,3,4,6,7};
		Set<Integer> one = new HashSet<>();
		Set<Integer> two = new HashSet<>();
		for(int num:arr) {
			one.add(num);
		}
		
		for(int num2:arr2) {
			if(one.contains(num2)) {
				two.add(num2);
			}
		}
		System.out.println("common "+two);
		List<Integer> l1 = Arrays.asList(1,2,3,4,5);
		List<Integer> l2 = Arrays.asList(2,3,4,5,6);
		Set<Integer> s3 = l1.stream().filter(s -> l2.contains(s)).collect(Collectors.toSet());
		System.out.println(s3);
		
		
	}

	private static void duplicatElement() {
		// TODO Auto-generated method stub
		int[] arr = {1,2,2,3,3,4,5};
		System.out.println(Arrays.stream(arr).distinct().mapToObj(c-> String.valueOf(c)).collect(Collectors.joining(",")));
		
		Set<Integer> dup = new HashSet<Integer>();
		for(int num : arr) {
			dup.add(num);
		}
		System.out.println("dup "+dup);
		
		
	}

	private static void secondLargestInArray() {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		PriorityQueue<Integer> min = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int num : arr) {
			min.add(num);
			if(min.size() > 2) {
				min.poll();
			}
		}
		System.out.println("2nd "+min.peek());
		
		int sec = Arrays.stream(arr)
				.boxed() //convert int to Integer
				.sorted(Collections.reverseOrder())
				.skip(1)
				.findFirst()
				.orElse(null);
		System.out.println("2nd stream :"+sec);
		
	}

	private static void reverseStringWithoutInbuilt() {
		// TODO Auto-generated method stub
		String s = "abcd";
		String rev = "";
		for(int i=s.length()-1;i>=0;i--) {
			rev = rev + s.charAt(i);
		}
		System.out.println("rev "+rev);
		
	}

	private static void fibbanocci() {
		int n = 10;
		for(int i=0;i<n;i++) {
			System.out.print(fibbanociSeries(i)+" ");
		}
		
	}

	private static int fibbanociSeries(int i) {
		// TODO Auto-generated method stub
		if(i <= 1) {
			return i;
		}
		
		return fibbanociSeries(i-1) + fibbanociSeries(i-2);
	}

	private static void primeOrNot() {
		// TODO Auto-generated method stub
		int a = 13;
		boolean b = false;
		for(int i=2;i<a;i++) {
			if(a % i == 0) {
				b = true;
				break;
			}else {
				b = false;
			}
		}
		String msg = (b) ? "Not Prime" : "Prime";
		System.out.println(msg);
		
	}

}
