package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCodingQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseStringWithoutBuiltInFunctions();
		countEachOccurance();
		removeNonAplhabaticCharacters();
		firstNonRepeatingChar();
		duplicateCharsInString();
		camelToSnakeCase();
		longestWordInString();
		replaceSpacesWithHypens();
		angramsOrNot();
		makeFirstCharacterAsUppercase();
		appendCountOfString();
		verifyStringContainsOnlyDigits();
		longestPalindrom();

	}

	private static void longestPalindrom() {
		// TODO Auto-generated method stub
		String s = "babad";
		int n = s.length();
		int start = 0, maxLen = 0;
		boolean[][] dp = new boolean[n][n];
		List<Integer> li = new LinkedList<>();

		// if len=1
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		// len=2
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				li.add(i);
				maxLen = 2;
			}
		}
		// len=3
		for (int length = 3; length <= n; length++) {
			for (int i = 0; i < n - length; i++) {
				int j = i + length - 1;
				if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					if (length == maxLen) {
						li.add(i);
					}
					if (length > maxLen) {
						li.clear();
						li.add(i);
						maxLen = length;
					}
				}
			}
		}
		for (int st : li) {
			System.out.println("Longest pallindrom: " + s.substring(st, st + maxLen));
		}

	}

	private static void verifyStringContainsOnlyDigits() {
		// TODO Auto-generated method stub
		String s = "123er456";
		boolean b = false;
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				b = false;
				break;
			} else {
				b = true;
			}
		}
		if (b) {
			System.out.println("True only numbers are present");
		} else {
			System.out.println("False some other chars are present");
		}

	}

	private static void appendCountOfString() {
		// TODO Auto-generated method stub
		// ip:aaaabccddd op:a4b1c2d3
		String s = "aaaabccddd";
		Map<Character, Long> map = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for (Map.Entry<Character, Long> m : map.entrySet()) {
			System.out.print(m.getKey() + "" + m.getValue());
		}
		System.out.println();

	}

	private static void makeFirstCharacterAsUppercase() {
		// TODO Auto-generated method stub
		// ip:automation testing is very important
		// op:Automation Testing Is Very Important
		String s = "automation testing is very important";
		String[] arr = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (String a : arr) {
			sb.append(Character.toUpperCase(a.charAt(0))).append(a.substring(1)).append(" ");
		}
		System.out.println("Final string to camel case " + sb.toString().trim());

	}

	private static void angramsOrNot() {
		// TODO Auto-generated method stub
		// ip:str1:listen,str2:silent op:both are angrams
		String s1 = "lister";
		String s2 = "silentr";
		if (s1.length() == s2.length()) {
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();
			Arrays.sort(c2);
			Arrays.sort(c1);
			if (Arrays.equals(c1, c2)) {
				System.out.println("Both strings are angrams");
			} else {
				System.out.println("No strings are angrams");
			}
		} else {
			System.out.println("Both lengths are not matched so 2 strings are not angrams");
		}
	}

	private static void replaceSpacesWithHypens() {
		// TODO Auto-generated method stub
		String s = "test the framework with all design pattrens";
		String res = s.replaceAll("\\s+", "-");
		System.out.println("replaces with hypens " + res);

	}

	private static void longestWordInString() {
		// TODO Auto-generated method stub
		String s = "Automation testing improves code stabilities";
		String[] sa = s.split("\\s+");
		String lo = "";
		for (String word : sa) {
			if (word.length() > lo.length()) {
				lo = word;
			}
		}
		System.out.println("Longest word " + lo);
	}

	private static void camelToSnakeCase() {
		// TODO Auto-generated method stub
		String s = "testCaseName";
		// with regex
		String res = s.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
		System.out.println("camToSanekeInreg " + res);
		// without regex
		String k = "testCaseName";
		StringBuilder sb = new StringBuilder();
		for (char c : k.toCharArray()) {
			if (Character.isUpperCase(c)) {
				sb.append("_").append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		System.out.println("camtosnakewithoutreg " + sb.toString());

	}

	private static void duplicateCharsInString() {
		// TODO Auto-generated method stub
		String s = "performance";
		Set<Character> se = new HashSet<>();
		Set<Character> dup = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (!se.add(c)) {
				dup.add(c);
			}
		}
		System.out.println(dup);

	}

	private static void firstNonRepeatingChar() {
		// TODO Auto-generated method stub
		String s = "automation";
		Map<Character, Long> map = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for (Map.Entry<Character, Long> m : map.entrySet()) {
			if (m.getValue() == 1) {
				System.out.println(m.getKey());
				break;
			}
		}

	}

	private static void removeNonAplhabaticCharacters() {
		// TODO Auto-generated method stub
		// regex method
		String s = "Hell$o %@Wo*123r^ld";
		String re = s.replaceAll("[^a-zA-Z]", "");
		// if you need to keep spaces
		String rep = s.replaceAll("[^a-zA-Z\\s]", "");
		System.out.println(rep);

		// without regex
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c) || Character.isWhitespace(c)) {
				sb.append(c);
			}
		}
		System.out.println(sb.toString());

	}

	private static void countEachOccurance() {
		// TODO Auto-generated method stub
		String s = "aabbccdde";
		Map<Character, Long> map = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for (Map.Entry<Character, Long> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}

	private static void reverseStringWithoutBuiltInFunctions() {
		// TODO Auto-generated method stub
		String s = "Surendra";
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			sb.append(c);

		}
		System.out.println(sb.toString());

	}

}
