package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerDetails {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    String name;
		String email;
		String phone;
		System.out.print("enter your desired number of records:");
		//Scanner sc =new Scanner(System.in);
		//int i,j;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		int k=Integer.parseInt(s);
		Customer[] customers=new Customer[k];
		for(int j=0;j<k;j++)
		{
		   System.out.print("Are you creating a record:");
		   String reply=br.readLine();
		   if("Y".equalsIgnoreCase(reply))
			{
		System.out.print("enter your name");
		name=br.readLine();
		System.out.print("enter your email");
	    email=br.readLine();
		System.out.print("enter your phone");
		phone=br.readLine();
		customers[j]=new Customer();
		customers[j].name=name;
		customers[j].email=email;
		customers[j].phone=phone;
		
		}
	   else
		{ 
			System.out.println("Printing details");
		}
	}	
		System.out.println("DETAILS ENTERED ARE:");
		 for(int i = 0; i < customers.length; i++)
	        {
	            System.out.println("Customer"+ (i+1)+ "name:" + customers[i].name);
	           System.out.println(" Emial:" + customers[i].email);
	           System.out.println("Phone:" + customers[i].phone);
	           System.out.println("==============================");
	        }
}
}

	
	
