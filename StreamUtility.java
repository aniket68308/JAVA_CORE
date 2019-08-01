package com.visa.training.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamUtility {
	
	private static void partOneExcer(List<String> str) {
		
		str.stream().forEach(y->System.out.println(" "+y));
		str.stream().forEach(StreamUtility::printNext);
	}
	
	private static List<String> partOneExcerTwo(List<String> str) {
		
		List<String>transformed = str.stream().map(s->s+"--transformed").collect(Collectors.toList());
		return transformed;
	}
	
	private static List<String> partOneExcerFour(List<String> str) {
		
		List<String>transformed = str.stream().filter(s->s.length()>3).collect(Collectors.toList());
		return transformed;
	}
	
	private static void printNext(String s) {
		System.out.println(s);
	}
	
	private static void partOne(List<String> str1) {
		//partOneExcer(str1);
		
		//List<String> transformedStr1 = partOneExcerTwo(str1);
		//System.out.println(transformedStr1);
				
		List<String> transformedStr2 = partOneExcerFour(str1);
		System.out.println(transformedStr2);
	}
	
	
	private static void partTwoOne(List<String> str1) {
		Optional<String>reducedString = str1.stream().reduce((s1,s2)->(s1.toUpperCase()+s2.toUpperCase()));
		reducedString.ifPresent(System.out::println);
	}
	
	private static void partTwoTwo(List<String> str1) {
		Optional<String>reducedString = str1.stream().map(String::toUpperCase).reduce((s1,s2)->(s1+s2));
		reducedString.ifPresent(System.out::println);
	}
	
	private static void partTwoThree(List<String> str1) {
		Optional<String>reducedString = str1.stream().reduce((s1,s2)->(s1+","+s2));
		reducedString.ifPresent(System.out::println);
	}
	
	
	private static void partTwoExcer(List<String> str1) {
		partTwoOne(str1);
		partTwoTwo(str1);
		partTwoThree(str1);
	}
	
	public static void main(String[] args) {
		
		List<String> str1 = Arrays.asList("hi", "hello", "world", "boy", "mango");
		//partOneExcer(str1);
		partTwoExcer(str1);
		
		
	}
}
