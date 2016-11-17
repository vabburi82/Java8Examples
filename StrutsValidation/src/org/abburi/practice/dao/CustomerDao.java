package org.abburi.practice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.abburi.practice.dto.Customer;

public class CustomerDao {
	String sql;
	String url="jdbc:mysql://localhost:3306/empdb";
	String uname="root";
	String passwd="root";
	Connection con=null;
	
	
	
  public CustomerDao() {
		super();
		try {
			openConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public Connection openConnection() throws Exception{
	  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection(url,uname,passwd);
	return con;
 }
  public int saveUser(Customer cust) throws Exception{
	  sql="insert into empdb.strutsdata(name,email,phone) values(?,?,?)";
	  PreparedStatement ps=con.prepareStatement(sql);
	  ps.setString(1, cust.getName());
	  ps.setString(2, cust.getEmail());
	  ps.setString(3, cust.getPhone());
	  int saveCount=ps.executeUpdate();
	  if(saveCount>0){
		  System.out.println("save success");
	  }
	  else{
		  System.out.println("Try again");
	  }
	return saveCount;
  }
  public int updateUser(String name, String email, String phone, String oldName) throws Exception{
	  sql="update empdb.strutsdata set name=?, email=?,phone=? where name=?";
	  PreparedStatement ps=con.prepareStatement(sql);
	  System.out.println(sql);
	  ps.setString(1, name);
	  ps.setString(2, email);
	  ps.setString(3, phone);
	  ps.setString(4, oldName);
	  
	  int updateCount=ps.executeUpdate();
	  if(updateCount>0){
		  System.out.println("update success");
	  }
	  else{
		  System.out.println("Try again");
	  }
	return updateCount;
  }
  public int deleteUser(String name) throws Exception{
	  sql="delete from strutsdata where name='"+name+"' ";
	  System.out.println(sql);
	  PreparedStatement ps=con.prepareStatement(sql);
	  int deleteCount=ps.executeUpdate();
	  if(deleteCount>0){
		  System.out.println("delete success");
	  }
	  else{
		  System.out.println("Try again");
	  }
	return deleteCount;
  }
  public List<Customer> listAllCustomers() throws Exception{
	  List<Customer> list= new ArrayList<Customer>();
	  sql="select * from strutsdata";
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery(sql);
	  while(rs.next()){
		  
		  list.add(buildCustomer(rs.getString(1),  rs.getString(2), rs.getString(3)));
		}
	  return list;
	  
  }
  public Customer buildCustomer(String name,String email,String phone){
		Customer customer;
		customer=new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setPhone(phone);
		return customer;
		
	}
}
