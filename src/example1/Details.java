package example1;
import java.util.Arrays;
import java.util.Scanner;
public class Details {
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		int i;
		String name;
		String email;
		String phone;

		Scanner input =new Scanner(System.in);
		System.out.println("Welcome to Costumer Deatails page");
	    Customer names[]=new Customer[1000];
	    System.out.println("Are you creating a record:");
		String userReply=input.next();
		
		for (i = 0; "Y".equalsIgnoreCase(userReply); i++)
    	{
    	
		        System.out.println("\nEnter Customer [ " + ( i) + " ] details ::");
		        
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
		
		 System.out.println("\nUser Details Entered are ::\n");
		 
		 for(int j=0;j<i;j++)
		 {	 
			System.out.println("\nUser Name ::" + names[j].name);
			System.out.println("User Phone :: "+names[j].email);
		    System.out.println("User Email :: "+ names[j].phone);
		
		 }

	}
}
