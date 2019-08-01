package com.visa.training.collections;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FileNameSearch {
	
	public static void main(String[] args) throws InterruptedException {
		
		Queue<File> directoryQueue = new LinkedList<>();
		String fileName = "PrimeThread.java";
		String startfolderName = "/root/";
			
		
		File startFolder = new File(startfolderName);
		
		File[] contents = startFolder.listFiles();
		
		//Queue<File> fileQueue = new LinkedList<>(); LinkedList is not thread safe
		
		Queue<File> fileQueue = new ConcurrentLinkedQueue<File>();
		
		
		fileQueue.addAll(Arrays.asList(contents));
		List<File> results = Collections.synchronizedList(new ArrayList<>());
		

        FileNameSearcher w1 = new FileNameSearcher(fileName, directoryQueue, results);
        FileNameSearcher w2 = new FileNameSearcher(fileName, directoryQueue, results);
        FileNameSearcher w3 = new FileNameSearcher(fileName, directoryQueue, results);
        FileNameSearcher w4 = new FileNameSearcher(fileName, directoryQueue, results);
        
        w1.start();w2.start();w3.start();w4.start();
        
        w1.join();w2.join();w3.join();w4.join();
        
        System.out.println("There were "+results.size()+" files found.");
        results.forEach(f->System.out.println(f.getAbsolutePath()));
		
		
		
	}
	
}
