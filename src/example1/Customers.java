package example1;
import java.util.Scanner;
public class Customers
{
public static void main(String[] args) 
	{
    int i, j;
    @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
    System.out.print("\nEnter No. of customers : ");
    j = input.nextInt();
    
    for (i = 0; i < j; i++) 
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
    	}
   
	}
}