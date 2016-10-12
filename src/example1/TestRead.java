package com.sample;
import java.io.*;
import java.util.*;
public class TestRead
{
	
@SuppressWarnings({ "unused", "resource" })
public static void main(String[] args) throws IOException
{
	 File file;
		Date d=new Date();
		ArrayList<String> l= new ArrayList<>();
		
			file = new File("myfile.txt");
			 if (!file.exists()) 
			  {
			     file.createNewFile();
			  }
			 	BufferedWriter bw =new BufferedWriter(new FileWriter(file,true));
			 	PrintWriter pw = new PrintWriter(bw);
			    int i;
				String name;
				String email;
				String phone;
				Scanner input =new Scanner(System.in);
				System.out.println("Welcome to Costumer Deatails page");
			    Customer names[]=new Customer[1000];
			    System.out.println("Are you creating a record:");
				String userReply=input.next();
				
				for (i = 1; "Y".equalsIgnoreCase(userReply); i++)
		    		{
		    	
				        System.out.println("\nEnter Customer"+ "[" + i + "]"+ "details ::");
				        
				        System.out.print("Enter the name: ");
				        name = input.next();
				        
				        System.out.print("Enter the Email: ");
				        email = input.next();
				        
				        System.out.print("Enter the PhoneNo: ");
				        phone = input.next();
				        
						System.out.println("\nDo you want to  enter more customers : ");
						userReply=input.next();
						
						names[i]=new Customer();
						names[i].name=name;
						names[i].email=email;
						names[i].phone=phone;	
		    		}
				
				 System.out.println("User Details Entered are ::\n");
				 pw.println("****************************");
				 pw.println(d.toString());
				 for(int j=1;j<i;j++)
				 	{	 
					 System.out.println(d.toString());
					 System.out.println("Customer" + j+ "Details: ");
					 System.out.println("Name ::" + names[j].name);
					 System.out.println("Email :: "+ names[j].email);
				     System.out.println("Phone :: "+ names[j].phone);
				     System.out.println("================================");
				     pw.println("Customer" +"["+ j+"]"+ "Details: ");
				     pw.println("Name:"+ names[j].name);
					 pw.println("Email:"+names[j].email);
					 pw.println("Phone:"+names[j].phone);
					 pw.println("================================");
					 
				 	}
				 pw.close();
				 //file = new File("C:/myfile.txt");
		 
		         FileReader fr = new FileReader(file);
		         BufferedReader br = new BufferedReader(fr);
		         String line=br.readLine();
		         while(line!=null)
		         {
		        
		         System.out.println(line);
		         line=br.readLine();
		         }
      }
}
