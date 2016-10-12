package com.sample;

import java.io.*;
import java.util.*;

import javax.imageio.stream.FileImageInputStream;

public class FileDemo {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	  Scanner sc= new Scanner(System.in);
	  Date d= new Date();
	  File file= new File("C:\\Users\\ABBURI'S\\Documents\\newfile.txt");
      if(!file.exists())
      {
    	  file.createNewFile();
    	  System.out.println("File created");
      }
      else 
    	  {
    	  System.out.println("file already exists");
    	  }
      //FileInputStream fis=new FileInputStream(file);
      BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
      bw.write(d.toString());
      System.out.println("Enter text:");
      //bw.newLine();
      //bw.write(d.toString());
      bw.newLine();
      bw.write(sc.next());
      bw.close();
      //FileReader fr=new FileReader(file);
      
      BufferedReader br= new BufferedReader(new FileReader(file));
      String in=null;
      //System.out.println(d.toString());
      while((in = br.readLine()) != null)
      {
    	  
    	System.out.println(in);
        
      }
	}
}

