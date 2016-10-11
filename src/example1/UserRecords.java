package example1;
import java.io.IOException;
import java.util.*;
public class UserRecords {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args)throws IOException {
		int i,j,f=1,g=0;
		String details;
		List<CustomerList> l =  new ArrayList<CustomerList>();
		Scanner input=new Scanner(System.in);
		CustomerList cl;
		System.out.println("Welcome to User Details Page...!");
		System.out.println("Do you want to Enter User Details: ");
		details = input.next();
		
		for (i = 1;"Y".equalsIgnoreCase(details); i++)
		{
			cl=new CustomerList();
			System.out.println("Enter Name:");
			cl.setName(input.next());
			System.out.println("Enter Email:");
			cl.setEmail(input.next());
			System.out.println("Enter PhoneNo:");
			cl.setPhone(input.nextInt());
			System.out.println("Enter Age:");
			cl.setAge(input.nextInt());
			System.out.println("Enter Height:");
			cl.setHeight(input.nextFloat());
			l.add(cl);
			System.out.println("\nDo you want to  enter more customers : ");
			details=input.next();
			}
		//System.out.println("USER DETAILS ENTERED ARE::");
		
		/*for(j = 0;j<l.size();j++){
			System.out.println("User" +"["+f+"]:");
			System.out.println("Name:"+ l.get(j).getName());
			System.out.println("Email:"+ l.get(j).getEmail());
			System.out.println("Phone:"+ l.get(j).getPhone());
			System.out.println("Height"+ l.get(j).getHeight());
			System.out.println("Age:"+ l.get(j).getAge());
			System.out.println("===============================");
			f= f+g;
			f++;
		}*/
		System.out.println("Enter your choice::");
		System.out.println("choice 1 for Name");
		System.out.println("choice 2 for Email");
		System.out.println("choice 3 for Phone");
		System.out.println("choice 4 for Age");
		System.out.println("choice 5 for Height");
		details=input.next();
		int m=Integer.parseInt(details);
		switch (m) {
		  case 1:
			  for(int a= 0; a<l.size(); a++)
			  {
		       System.out.println("Name:"+ l.get(a).getName());
			  }
			  break;
		  case 2:
			  for(int b=0; b<l.size(); b++)
			  {
			  System.out.println("Email:" + l.get(b).getEmail());
			  }
			  break;
		  case 3:
			  for(int c=0; c<l.size(); c++)
			  {
			  System.out.println("Phone:" + l.get(c).getPhone());
			  }
			  break;
		  case 4: 
			  for(int d=0; d<l.size(); d++)
			  {
			  System.out.println("Height:" + l.get(d).getHeight());
			  }
			  break;
		  case 5:
			  for(int e=0; e<l.size(); e++)
			  {
				  System.out.println("Age:" + l.get(e).getAge());
			  }
			  break;
		  default:
			  for(int h=0; h<l.size(); h++)
			  {
				  System.out.println("User" +"["+(h+1)+"]"+"details:");
					System.out.println("Name:"+ l.get(h).getName());
					System.out.println("Email:"+ l.get(h).getEmail());
					System.out.println("Phone:"+ l.get(h).getPhone());
					System.out.println("Height"+ l.get(h).getHeight());
					System.out.println("Age:"+ l.get(h).getAge());
					System.out.println("===============================");
			  }
			  break;
		}
	}
}