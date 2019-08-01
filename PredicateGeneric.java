package com.visa.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateGeneric {
	
	private static <T> List<T> allMatches(List<T> strList, Predicate<T> pr) {
		List<T> trueConditionList = new ArrayList<T>();
		for(T ele : strList) {
			if(pr.test(ele)) {
				trueConditionList.add(ele);
			}
		}
		return trueConditionList;
	}
	
	public static void main(String[] args) {
		//String[] array = {"this","is","an","array","with","excel","unusal","words","exist","like","xylophone"};
		//List<String> words = Arrays.asList(array);
		//List<String> longWord = PredicateGeneric.allMatches(words, s->s.length()>3);
		
		//System.out.println(longWord);
		
		Integer[] array = {1,2,3,4,5,6,7};
		List<Integer> words = Arrays.asList(array);
		List<Integer> longWord = PredicateGeneric.allMatches(words, s->s>3);
		
		System.out.println(longWord);
		
	}
	
}
