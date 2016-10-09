package example1;
import java.util.Scanner;
public class CustomerDetails {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for (int i=1;i<=100;i++)
		{
			System.out.println("\nPlease enter Customer Details:");
			System.out.println("Please enter User Name: ");
			String name = input.nextLine();
			System.out.println("Please enter User Email Id: ");
			String emailId = input.nextLine();
			System.out.println("Please enter User Phone: ");
			String phone = input.nextLine();
			
			System.out.println("User Details Entered are ::");
			System.out.println("User Name :: " + name);
			System.out.println("User Phone :: "+ phone);
			System.out.println("User Email :: "+ emailId);
		}
	}
}