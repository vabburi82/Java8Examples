package example1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFile2
{
	
public static void main(String[] args)
{
	 File file;
		String mycontent ="Customer Details";
		{
		try{
			file = new File("C:/myfile.txt");
			 if (!file.exists()) 
			  {
			     file.createNewFile();
			  }
			 System.out.print("Hello");
			 FileWriter fw = new FileWriter(file,true);
			 BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Hello");
			bw.close();
		}
		catch(IOException ioe)
		{
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
		}	

	}

}
}