package example1;
import java.util.Scanner;
public class CustomersUnlimited
{
public static void main(String[] args) 
	{
    int i, j;
    @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
    System.out.print("\nDo you want to enter more customers : ");
    String moreCustomers = input.next();
   
    
    for (i = 0; "Y".equalsIgnoreCase(moreCustomers); i++) 
    	{
        System.out.println("\nEnter Customer [ " + (i + 1) + " ] details ::");
        
        System.out.print("Enter the name: ");
        String Name = input.next();
        
        System.out.print("Enter the Email: ");
        String Email = input.next();
        
        System.out.print("Enter the PhoneNo: ");
        String phone = input.next();
        
        System.out.println("User Details Entered are ::\n");
		System.out.println("User Name :: "+ Name);
		System.out.println("User Phone :: "+ phone);
		System.out.println("User Email :: "+ Email);
		
		System.out.print("\nDo you want to enter more customers : ");
	     moreCustomers = input.next();
	   
    	}
   
	}
}