package example1;
import java.io.*;
import java.util.*;
public class TestCollections
{
	
@SuppressWarnings("resource")
public static void main(String[] args) throws IOException
{
	String name;
	String email;
	String phone;
	int g=0;
	 int f=1;
	 int i;
	 File file;
		Date d=new Date();
			file = new File("C:/myfile.txt");
			 if (!file.exists()) 
			  {
			     file.createNewFile();
			  }
			 	BufferedWriter bw =new BufferedWriter(new FileWriter(file,true));
			 	PrintWriter pw = new PrintWriter(bw);
			 	ArrayList<String> l = new ArrayList<String>();
			 	Scanner input =new Scanner(System.in);
				System.out.println("Welcome to Costumer Deatails page");
				System.out.println("Are you creating a record:");
				String userReply=input.next();
				for (i = 1; "Y".equalsIgnoreCase(userReply); i++)
		    		{
		    	
				        System.out.println("\nEnter Customer"+ "[" + i + "]"+ "details ::");
				        
				        System.out.print("Enter the name: ");
				        name = input.next();
				        l.add(name);
				        System.out.print("Enter the Email: ");
				        email = input.next();
				        l.add(email);
				        System.out.print("Enter the PhoneNo: ");
				        phone = input.next();
				        l.add(phone);
				        
						System.out.println("\nDo you want to  enter more customers : ");
						userReply=input.next();	
						
		    		}
				             pw.println("****************************");
							 pw.println(d.toString());
							 
				      for(int k=0;k<l.size();k++)
				      { 
				       pw.println("Customer" +"["+f+"]"+ "Details: ");
		               pw.println("Name:"+ l.get(k));
					   k++;
					   pw.println("Email:"+l.get(k));
					   k++;
					   pw.println("Phone:"+l.get(k));
					   pw.println("================================");
					   f= f+g;
					   f++;
					 }
				 pw.close();
		         FileReader fr = new FileReader(file);
		         BufferedReader br = new BufferedReader(fr);
		         String line=br.readLine();
		         while(line!=null)
		         {
		         System.out.println(line);
		         line=br.readLine();
                 }
      }
}
