package com.visa.training.collections;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.stream.Stream;

public class MyDOS {
	
	
	public static void main(String[] args) {
		
		String command = args[0];
					
		switch(command) {
			
			case "dir":
				doDir(args);
				break;
			case "copy":
				doCopy(args);
				break;
			case "type":
				doType(args);
				break;
				default:
					System.out.println("Unknown Command");
					
		}
	}

	private static void doType(String[] args) {
		String dirName = System.getProperty("user.dir");
		
		if(args.length > 1) {
			dirName = args[1];
		}
		
		File thatFolder = new File(dirName);
		File[] contents = thatFolder.listFiles();
		Stream.of(contents).forEach(System.out::println);
		
	}

	private static void doCopy(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		try {
			
			String src = args[1];
			String des = args[2];
			
			
			/*
			 * Very slow as it reads and writes data byte by byte
			 * 
			FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(des);
			*/
			
			FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(des);
			
			BufferedInputStream bIn = new BufferedInputStream(in);
			BufferedOutputStream bOut = new BufferedOutputStream(out);
			
			
			int aByte;
			while((aByte = bIn.read()) != -1) {
				bOut.write(aByte);
			}
			
			in.close();
			out.close();

        long end = System.currentTimeMillis();
        System.out.println("Copying took "+(end - start)+" ms.");
			
		}	
		catch (Exception e) {
            e.printStackTrace();
		}
		
	}

	private static void doDir(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
