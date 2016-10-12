package com.sample;

import java.io.*;

public class CustomUserDetails {


	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    String name;
		String email;
		String phone;
		File file=new File("C:\\Users\\ABBURI'S\\Documents\\myfile.txt");
		if(!file.exists()){
		file.createNewFile();
		}
		FileWriter fw=new FileWriter(file);
		//BufferedWriter bw=new BufferedWriter(fw);
		System.out.print("enter no.of customer records:");
		//Scanner sc =new Scanner(System.in);
		//int i,j;
		BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
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
		PrintWriter pw=new PrintWriter(fw);
		pw.println(name);
		pw.println(email);
		pw.println(phone);
		bw.write(name);
		bw.write(email);
		bw.write(phone);
		}
	   else
		{ 
			System.out.println("Printing details");
		}
	}	
		System.out.println("DETAILS ENTERED ARE:");
		 for(int i = 0; i < customers.length; i++)
		 {/*
			 Customer line=customers[i];
			 FileReader fileReader = new FileReader("UserData.txt");

		            // Always wrap FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);

		            while((line = bufferedReader.readLine()) != null) {
		                System.out.println(line);
		            }   

		            // Always close files.
		            bufferedReader.close();
		   */
	           System.out.println("Customer"+ "["+(i+1)+"]"+"details:"); 
	           System.out.println("Name:" + customers[i].name);    
	           System.out.println("Email:" + customers[i].email);
	           System.out.println("Phone:" + customers[i].phone);
	           System.out.println("==============================");
	        }
}
}

	
	
