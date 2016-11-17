package com.examples.daodemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

public class UserDao extends BaseDao {

	public int saveUser(String id, String name, String email, String phone)
			throws ClassNotFoundException, SQLException {
		Connection con;
		con = openConnection();
		String sql = "insert into empdb.jspdata(id,name,email,phone) values(?,?,?,?)";
		java.sql.PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4, phone);
		int count = ps.executeUpdate();
		System.out.println("save success");
		con.close();
		return count;
	}

	public Customer updateUser(String id, String name, String email, String phone)
			throws SQLException, ClassNotFoundException {
		Connection con = openConnection();
		String sql = "update empdb.jspdata set name ='" + name + "', email ='" + email + "', phone ='" + phone
				+ "' where ID ='" + id + "' ";
		Statement st = con.createStatement();
		int count = st.executeUpdate(sql);
		Customer updateUser = null;
		System.out.println("user update success!!!!!!!!!");
		if(count>0){
			updateUser= buildUser(name, id, email, phone);
		}
		con.close();
		return updateUser;
	}

	public int deleteUser(String id) throws ClassNotFoundException, SQLException {
		Connection con = openConnection();
		String sql = "DELETE FROM EMPDB.JSPDATA where ID = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		int deletedRowCount = ps.executeUpdate();
		System.out.println("User delete Success");
		con.close();
		return deletedRowCount;

	}

	public ResultSet loadAllUsers() throws SQLException, ClassNotFoundException {
		Connection con = openConnection();
		String qry = "SELECT * FROM empdb.jspdata";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(qry);
		System.out.println("load success");
		return rs;
	}

	public List<Customer> listAllUsers() throws ClassNotFoundException, SQLException {
		String name;
		String email;
		String phone;
		String id;
		Customer cus;
		List<Customer> list = new ArrayList<Customer>();
		Connection con = openConnection();
		String qry = "SELECT * FROM empdb.jspdata";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(qry);
		while (rs.next()) {
			cus = new Customer();
			id = rs.getString(1);
			cus.setId(id);
			name = rs.getString(2);
			cus.setName(name);
			email = rs.getString(3);
			cus.setEmail(email);
			phone = rs.getString(4);
			cus.setPhone(phone);
			cus=buildUser(name, id, email, phone);
			list.add(cus);
		}
		con.close();
		return list;
	}
	public Customer buildUser(String name,String id,String email,String phone){
		Customer cus;
		cus=new Customer();
		cus.setName(name);
		cus.setId(id);
		cus.setEmail(email);
		cus.setPhone(phone);
		return cus;
		
	}
}
