package com.visa.training.collections;

import java.util.concurrent.Callable;

public class CallablePrimeCounter implements Callable<Long> {

    long start, end;

    public CallablePrimeCounter(long start, long end) {

        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        long numPrimes = 0;
        for(long i = start;i<=end;i++) {
            if(isPrime(i)) {
                numPrimes++;
            }
        }
        return numPrimes;
    }

    private boolean isPrime(long num) {
        if(num <= 2) {
            return true;
        }
        for(long i=2;i<num;i++) {
            if((num % i) == 0) {
                return false;
            }
        }
        return true;
    }}
