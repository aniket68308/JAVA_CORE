package com.visa.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateLambda {

	private static List<String> allMatches(List<String> strList, Predicate<String> pr) {
		List<String> trueConditionList = new ArrayList<String>();
		for(String ele : strList) {
			if(pr.test(ele)) {
				trueConditionList.add(ele);
			}
		}
		return trueConditionList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"this","is","an","array","with","excel","unusal","words","exist","like","xylophone"};
		List<String> words = Arrays.asList(array);
		List<String> longWord = PredicateLambda.allMatches(words, s->s.length()>3);
		
		System.out.println(longWord);
		
		
	}

}
