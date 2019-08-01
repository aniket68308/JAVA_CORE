package com.visa.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


class StringLengthComparator implements Comparator<String>{
	
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length()-o2.length();
	}
}

public class CollectionsDemo {
	
	public static <T> void copyFirstListToSecond(List<T> src, List<? super T> dest) {
		for(T anElemnt : src) {
			dest.add(anElemnt);
		}
	}
	public static double sum(List<? extends Number> numList) {
		double sumList = 0;
		for(Number aNumber : numList) {
			sumList += aNumber.doubleValue();
		}
		// numList.add(1234); this is not allowed as ? extends only tells that numList is subclass of Number.
		return  sumList;
	}
	
	public static void main(String[] args) {
		
		//List<Double> doubles = demolist();
		//double sumList = sum(doubles);
		//System.out.println("Sum of random numbers : " + sumList);
		
		//demoMap();
		
		//demoSet();
		
		//demoGenerics();
		demoSortList();
		
	}
	
	private static void demoGenerics() {
		// TODO Auto-generated method stub
		List<Integer> iList1 = new ArrayList<>();
		List<Integer> iList2 = new ArrayList<>();
		List<String> sList1 = new ArrayList<>();
		List<String> sList2 = new ArrayList<>();
		List<Number> nList = new ArrayList<>();
		copyFirstListToSecond(iList1, iList2);
		copyFirstListToSecond(sList1, sList2);
		//copyFirstListToSecond(iList1, sList1); Not applicable now
		
		copyFirstListToSecond(iList1, nList);
	}
	private static void demoSet() {
		// TODO Auto-generated method stub
		Set<String> words = new HashSet<>();
		
		while(true) {
			String aWord = fromKeyboard("Enter a Word : ");
			if(!words.add(aWord)) {
				System.out.println("This is a duplicate!");
			}
			if(words.size() == 10) {
				break;
			}
			
		}
		
		System.out.println("_______________List of unique words_____________");
		for(String aWord : words) {
			System.out.println(aWord);
		}
		
	}

	public static String fromKeyboard(String prompt) {
		Scanner s = new Scanner(System.in);
		System.out.println(prompt);
		return s.nextLine();
		
	}
	
	private static void demoSortList() {
		String[] array = {"this","is","an","array","with","unusal","words","like","xylophone"};
		List<String> words = Arrays.asList(array);
		System.out.println("Before Sort : ");
		System.out.println(words);
		System.out.println("After Sort : ");
		//Collections.sort(words, new StringLengthComparator());
		
		/*
		Collections.sort(words, new Comparator<String>() { // Anonymous class

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()-o2.length();
			}
		});
		*/
		
		//Collections.sort(words, (s1,s2) -> s1.length()-s2.length());
		
		//Collections.sort(words, (s1,s2) -> s2.length()-s1.length());
		
		//Collections.sort(words, (s1,s2) -> s1.charAt(0) - s2.charAt(0));
		
		Collections.sort(words, (s1,s2) -> (((s1.charAt(0)=='e')? 0 : 1)- ((s2.charAt(0)=='e')? 0 : 1)));
		
		System.out.println(words);
	}

	private static void demoMap() {
		// TODO Auto-generated method stub
		Map<String,String> employees = new HashMap<>();
		
		employees.put("e001", "emp1");
		employees.put("e002", "emp2");
		employees.put("e003", "emp3");
		employees.put("e004", "emp4");
		
		while(true) {
            String id = fromKeyboard("Enter an employee id (or 'quit') :");
            if(id.equalsIgnoreCase("quit")) {
                break;
            }
            
            if(employees.containsKey(id)) {
                System.out.println("Employee exists!");
                System.out.println(employees.get(id));
            }else {
                System.out.println("No Such employee.");
            }
        }
		Set<String> Keys = employees.keySet();
		for(String aKey : Keys) {
			System.out.println(aKey + "--->" + employees.get(aKey));
		}
	}

	private static List<Double> demolist() {
		List<Double> randoms = new ArrayList<Double>();
		
		while(true) {
			double aRandom = Math.random();
			if(aRandom < 0.01) {
				break;
			}
			randoms.add(aRandom);
		}
		System.out.println("There are " + randoms.size() + " random numbers");
		
		/*
		 * for(int i=0;i<random.size();i++) {
		 * 	System.out.println(randoms.get(i));
		 * }
		 */
		/*
		for(Double aDouble : randoms) {
			System.out.println(aDouble);
		}
		*/
		return randoms;
	}
}
