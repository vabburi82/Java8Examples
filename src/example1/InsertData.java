package example1;

import java.util.Scanner;    
import java.sql.*;    
public class InsertData {    
public static void main(String args[])throws SQLException  
{    
    System.out.println("Welcome to Your database");    
    try    
    {    
        Scanner input=new Scanner(System.in);    
        System.out.println("Enter you First Name");    
        String first_name=input.nextLine();     
        System.out.println("Enter your Last Name");    
        String last_name=input.nextLine();    
        System.out.println("Welcome"+ " "+ first_name +" "+last_name);    
        System.out.println("Enter your Phone number");    
        String phone=input.nextLine();    
        System.out.println("Enter your email id");    
        String email=input.nextLine();    
        System.out.println("Enter your current city");    
        String city=input.nextLine();    
        System.out.println("Enter you current State");    
        String state=input.nextLine();    
        System.out.println("Enter you pin code");       
        String pin=input.nextLine();    
        System.out.println("------------------------");
        
        System.out.println("Your Details are following.");    

        System.out.println("Name :"+ " "+first_name +" "+ last_name);    
        System.out.println("Phone :"+ " "+phone);    
        System.out.println("Email :"+ " "+email);    
        System.out.println("City :"+ " "+city);    
        System.out.println("State :"+ " "+state);
        System.out.println("PIN code :"+ " "+pin);    

        Class.forName("com.mysql.jdbc.Driver");      

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anil","root","root");    
        Statement input1 = (Statement) con.createStatement();
        String update=("insert into Emp_details(first_name,last_name,phone,email,city,state,pin) values('" + first_name + "', '" + last_name + "', '" + phone + "', '" + email + "', '" + city + "', '" + state + "', '" + pin +"')");
        input1.executeUpdate(update);
        System.out.println("All Right , We got your entry");    
    }    
    catch(Exception e)    
    {System.out.println(e);}    
    finally{    
        System.out.println("Thanks for using our code");    
    }    
}    
}    