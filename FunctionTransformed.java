package com.visa.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTransformed {
	
	private static <T> List<T> transformedList(List<T> strList, Function<T,T> fn) {
		List<T> transformedList = new ArrayList<T>();
		for(T ele : strList) {
			transformedList.add(fn.apply(ele));
		}
		return transformedList;
	}
	
	
	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,6,7};
		List<Integer> words = Arrays.asList(array);
		List<Integer> longWord = FunctionTransformed.transformedList(words, s->s*s);
		
		System.out.println(longWord);
	}
}
