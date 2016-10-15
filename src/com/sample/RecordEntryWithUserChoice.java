package com.sample;

import java.io.*;
import java.util.*;

public class RecordEntryWithUserChoice {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
				int i,j;
				String userReply,userChoice;
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
				BufferedReader br=new BufferedReader(new FileReader(f));
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
			    /*for(int k=0;k<l.size();k++){
			    System.out.println("Record"+ "["+(k+1)+"]");
				System.out.println("Name:"+l.get(k).getName());
				System.out.println("Email:"+l.get(k).getEmail());
				System.out.println("Phone:"+l.get(k).getPhone());
				System.out.println("============================");
				
			}*/
			    pw.println(d.toString());
			    for(int m=0;m<l.size();m++)
			    {
				    pw.println("Record"+ "["+(m+1)+"]");
					pw.println("Name:"+l.get(m).getName());
					pw.println("Email:"+l.get(m).getEmail());
					pw.println("Phone:"+l.get(m).getPhone());
					pw.println("============================");
			    }
				pw.flush();
				pw.close();
				System.out.println("Press 1 to print names of all records:");
				System.out.println("Press 2 to print emails of all records:");
				System.out.println("Press 3 to print phone_numbers of all records:");
				System.out.print("Enter your choice:");
				userChoice=sc.next();
				int choice=Integer.parseInt(userChoice);
				switch( choice ) {

			    case 1:
			    	for(int a=0;a<l.size();a++){
			    		
			    	System.out.println("Record"+"["+(a+1)+"]"+"Name:"+l.get(a).getName());
			    	}
			      break;

			    case 2:
			    	for(int b=0;b<l.size();b++){
			    		
				    	System.out.println("Record"+"["+(b+1)+"]"+"Email:"+l.get(b).getEmail());
				    	}
			       break;

			    case 3:
			    	for(int e=0;e<l.size();e++){
			    		
				    	System.out.println("Record"+"["+(e+1)+"]"+"phone:"+l.get(e).getPhone());
				    	}
			      break;

			    default:
			    	for(int g=0;g<l.size();g++){
                    System.out.println("Record"+ "["+(g+1)+"]");
					System.out.println("Name:"+l.get(g).getName());
					System.out.println("Email:"+l.get(g).getEmail());
					System.out.println("Phone:"+l.get(g).getPhone());
					System.out.println("============================");
			        break;
			  }


				}
				System.out.print("Do you want to print report:");
				userReply=sc.next();
				String in=br.readLine();
				if("Y".equalsIgnoreCase(userReply)){
				    while(in !=null){
					System.out.println(in);
					in=br.readLine();
				}
	}
}

}
