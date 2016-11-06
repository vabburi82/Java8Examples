package com.sample;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class RecordEntry {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i,j;
		String userReply;
		Date d=new Date();
		File f=new File("user_details.txt");
				if(!f.exists())
				{
					f.createNewFile();
				}
				else 
				{
					System.out.println("File already exists");
				}
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
		PrintWriter pw=new PrintWriter(bw);
		List<CustomerList> l= new ArrayList<CustomerList>();
		Scanner sc=new Scanner(System.in);
		CustomerList c;
		System.out.println("Welcome to Record Entry");
		System.out.print("Do you want to create a Record:");
		userReply=sc.next();
		for(i=1;"y".equalsIgnoreCase(userReply);i++)
		{
			c=new CustomerList();
		//CustomerList c1=new CustomerList();
		//System.out.println("Record"+ i);	
		System.out.print("Enter name:");
		c.setName(sc.next());
		System.out.print("Enter email:");
		c.setEmail(sc.next());
		System.out.print("Enter Phone_Number:");
		c.setPhone(sc.nextInt());
		System.out.print("Do you want to create another record:");
		userReply=sc.next();
		l.add(c);
		}
		System.out.println("***************test***************");
	    for(int k=0;k<l.size();k++){
	    System.out.println("Record"+ "["+(k+1)+"]");
		System.out.println("Name:"+l.get(k).getName());
		System.out.println("Email:"+l.get(k).getEmail());
		System.out.println("Phone:"+l.get(k).getPhone());
		System.out.println("============================");
		
	}
	    pw.println(d.toString());
	    for(int m=0;m<l.size();m++){
		    pw.println("Record"+ "["+(m+1)+"]");
			pw.println("Name:"+l.get(m).getName());
			pw.println("Email:"+l.get(m).getEmail());
			pw.println("Phone:"+l.get(m).getPhone());
			pw.println("============================");
	    }
		pw.flush();
		pw.close();

}

}