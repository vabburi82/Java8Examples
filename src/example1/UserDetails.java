package example1;

import java.util.Scanner;

public class UserDetails {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter User Details Name ");
		System.out.println("Please enter User Name");
		String name = input.nextLine();
		System.out.println("Please enter User Email Id ");
		String emailId = input.nextLine();
		System.out.println("Please enter User Phone ");
		int phone = input.nextInt();
		
		System.out.println("User Details Entered ::");
		System.out.println("User Name :: " + name);
		System.out.println("User Phone :: "+ phone);
		System.out.println("User Email :: "+ emailId );
	}
}
