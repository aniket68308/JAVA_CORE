package com.visa.training.collections;

public class PrimeCount implements Runnable{
	
	int start;
	int end;
	int pCount;
	public PrimeCount(int start, int end) {
		this.start = start;
		this.end = end;
		this.pCount = 0;
	}
	
	
	public int getPrimeCount() {
		return this.pCount;
	}
	
	public void run() {
		
		for (int i = start; i <= end; i++) {
            boolean isPrimeNumber = true;

            for (int j = 2; j < Math.sqrt(i)+1; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                this.pCount += 1;
            }
        }
		System.out.println(this.pCount);
		
	}
}
