package com.visa.training.collections;

public class LambdaFunction {
	
	@FunctionalInterface
	public interface TwoStringPredicate
	{
		public boolean isFirstBetter(String s1, String s2);
	}
	
	public static String betterString(TwoStringPredicate ts, String s1, String s2) {
		
		if(ts.isFirstBetter(s1, s2)) {
			return s1;
		}
		else {
			return s2;
		}
		
	}
	
	public static void main(String[] args) {
		String a1 = "stack";
		String a2 = "flow";
		String results = LambdaFunction.betterString((s1,s2) -> s1.length()>s2.length(), a1, a2);
		
		System.out.println(results);
	}
}
