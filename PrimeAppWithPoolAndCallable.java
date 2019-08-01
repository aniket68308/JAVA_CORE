package com.visa.training.collections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeAppWithPoolAndCallable {

    public static void main(String[] args) throws Exception {
        CallablePrimeCounter counter1 = new CallablePrimeCounter(10000, 100000);
        CallablePrimeCounter counter2 = new CallablePrimeCounter(60000, 200000);
        
        ExecutorService pool = Executors.newFixedThreadPool(4);
        
        Future<Long> f1 = pool.submit(counter1);
        Future<Long> f2 = pool.submit(counter2);
        
        
        
        long result1 = f1.get();
        long result2 = f2.get();
        
        System.out.println("Number of primes in range1 :"+result1);
        System.out.println("Number of primes in range2 :"+result2);
        pool.shutdown();
    }

}
