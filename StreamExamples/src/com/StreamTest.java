package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamTest {
	
	//@Test
	public void regularCase() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ammar");
		list.add("brain");
		list.add("guru");
		list.add("Ajay");
		list.add("good");
		int count = 0;
		for(int i=0;i<list.size();i++) {
			String a = list.get(i);
			if(a.startsWith("A")) {
				count ++;
			}
		}
		System.out.println("count "+count);
	}
	
	//using streams
	//@Test
	public void streamCase() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ammar");
		list.add("brain");
		list.add("guru");
		list.add("Ajay");
		list.add("good");
		list.add("Ajay");
		
		Long b = list.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("count "+b);
		list.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);
		
	}
	
	//Just get and filter the data from list we use streams
	//After filter we need to update the list we use map
	
	//filter the list with last letter a and make it as uppercase
	
	//@Test
	public void mapCase() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ammar");
		list.add("brain");
		list.add("guru");
		list.add("Jon Abrham");
		list.add("vijay");
		list.add("Ajay");
		list.add("good");
		
		
		//list.stream().filter(s -> s.endsWith("y")).map(s -> s.toUpperCase()).forEach(System.out::println);
		//print the names in sorted way
		//list.stream().filter(s -> s.endsWith("y")).map(s -> s.toUpperCase()).sorted().forEach(System.out::println);
		//get the strings which length is more than 3 and make it upper cases and get sorted in reverse order
		list.stream().filter(s -> s.length() > 3).map(s -> s.toUpperCase()).sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));
	}
	//@Test
	public void mergeLists() {
		//merge 2 different lists and print in reverse sorted way
		List<String> list1 = Arrays.asList("Apple","Animal","Goat","Lion","Zebra","Ant");
		List<Integer> list2 = Arrays.asList(10,5,6,18,1);
		
		//Stream.concat(list1.stream(), list2.stream().map(s -> s + "")).sorted(Comparator.reverseOrder()).limit(4).skip(3).forEach(System.out::println);
		Stream.concat(list1.stream(), list2.stream().map(s -> s + "")).sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	//have list of integers need to print unique numbers and return as list in sorted order
	@Test
	public void uniqueCase() {
		List<Integer> values = Arrays.asList(1,2,3,4,1,7,18,19,2,19,25,4,5,25);
		List<Integer> listValues = values.stream().distinct().sorted().collect(Collectors.toList());
		//after sort and get the top 3 values index value
		List<Integer> listValues1 = values.stream().distinct().sorted().limit(3).collect(Collectors.toList());
//		for(int i=0;i<listValues.size();i++) {
//			System.out.println(listValues.get(i));
//		}
		//listValues.forEach(System.out::println);
		listValues1.forEach(System.out::println);
		
	}
}
