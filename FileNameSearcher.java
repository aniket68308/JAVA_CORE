package com.visa.training.collections;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class FileNameSearcher extends Thread{
	
	private String fileName;
	private Queue<File> directoryQueue;
	private List<File> results;
	
	public FileNameSearcher(String fileName, Queue<File> directoryQueue, List<File> results) {
		super();
		this.fileName = fileName;
		this.directoryQueue = directoryQueue;
		this.results = results;
	}

	
	@Override
	public void run() {
		while(true) {
			File aFileOrFolder = directoryQueue.poll();
			
			if(aFileOrFolder == null) {
				break;
		}
		
			if(aFileOrFolder.isFile() && aFileOrFolder.getName().equalsIgnoreCase(fileName)) {
                results.add(aFileOrFolder);
            }else if(aFileOrFolder.isDirectory() && aFileOrFolder.canRead()) {
                File[] contents = aFileOrFolder.listFiles();
                if(contents != null) {
                    directoryQueue.addAll(Arrays.asList(contents));
                }
            }
		}
	}
	
	
	
	/*
	 * 
	 * 
	 * 
	public void run() {
		
		while(this.directoryQueue.size() != 0) {
			File folder = this.directoryQueue.peek();
			File[] listOfFiles = folder.listFiles();
			for(File f : listOfFiles) {
				if(f.isFile()) {
					if(f.getName() == fileName) {
						this.countNfile += 1;
					}
				}
				else {
					if(f.isDirectory()) {
						this.directoryQueue.add(f);
					}
				}
				directoryQueue.remove();
			}
		}
	}
	*/
	
}