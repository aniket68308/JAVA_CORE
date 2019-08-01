package com.visa.training.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringUtil {
	
	
	
	
	private static int eChecker(String s1, String s2) {
		
		return ((s2.contains("e")? 1 : 0)- ((s1.contains("e")? 1 : 0)));
	}
	
	public static void main(String[] args) {
		
		
		lambdaSortString();
		methodReferenceSortString();
		
	}
	
	private static void lambdaSortString() {
		String[] array = {"this","is","an","array","with","excel","unusal","words","exist","like","xylophone"};
		List<String> words = Arrays.asList(array);
		System.out.println("Before Sort : ");
		System.out.println(words);
		System.out.println("After Sort : ");
		
		//Collections.sort(words, (s1,s2) -> s1.length()-s2.length());
		
		//Collections.sort(words, (s1,s2) -> s2.length()-s1.length());
		
		//Collections.sort(words, (s1,s2) -> s1.charAt(0) - s2.charAt(0));
		
		Collections.sort(words, (s1,s2) -> (((s2.contains("e")? 1 : 0)- ((s1.contains("e")? 1 : 0)))));
		
		System.out.println(words);
	}
	
	private static void methodReferenceSortString() {
		String[] array = {"this","is","an","array","with","excel","unusal","words","exist","like","xylophone"};
		List<String> words = Arrays.asList(array);
		System.out.println("Before Sort : ");
		System.out.println(words);
		System.out.println("After Sort : ");
		
		Collections.sort(words, StringUtil::eChecker);
		
		System.out.println(words);
	}

}
