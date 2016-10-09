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
        
        System.out.println("Enter the name: ");
        String name = input.nextLine();
        
        System.out.println("Enter the Email: ");
        String Email = input.nextLine();
        
        System.out.println("Enter the PhoneNo: ");
        String phone = input.nextLine();
        
        System.out.println("User Details Entered are ::\n");
		System.out.println("User Name :: "+ name);
		System.out.println("User Phone :: "+ phone);
		System.out.println("User Email :: "+ Email);
    	}
   
	}
}