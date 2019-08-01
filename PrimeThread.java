package com.visa.training.collections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeThread {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		PrimeCount counter1 = new PrimeCount(10000,100000);
		
		PrimeCount counter2 = new PrimeCount(500000,10000000);
		
		/*
		Thread t1 = new Thread(counter1);
		
		Thread t2 = new Thread(counter2);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		*/
		
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		
		pool.execute(counter1);
		pool.execute(counter2);
		

	}

}
