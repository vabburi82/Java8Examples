package example1;

import java.util.Scanner;
public class Customer1
{

	public static void main(String[] args) 
	{
    int i;
   // @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
    System.out.print("\nDo you want enter more customers : ");
    String moreCustomers = input.next();
    for (i = 1; "Y".equalsIgnoreCase(moreCustomers); i++) 
    	{
    	
		        System.out.println("\nEnter Customer [ " + ( i) + " ] details ::");
		        
		        System.out.print("Enter the name: ");
		        String name = input.next();
		        
		        System.out.print("Enter the Email: ");
		        String email = input.next();
		        
		        System.out.print("Enter the PhoneNo: ");
		        String phone = input.next();
		        
				System.out.println("\nDo you want enter more customers : ");
			    moreCustomers = input.next();
    	
	    System.out.println("User Details Entered are ::\n");
		System.out.println("User Name :: "+ name);
		System.out.println("User Phone :: "+ email);
		System.out.println("User Email :: "+ phone);
	}
	}
}