package com.sample.test;
import com.examples.daodemo.Customer;
import com.examples.daodemo.UserDao;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class UserDaoTest extends Assert {
	@Test
	public void saveUser() throws Exception{
		UserDao user=new UserDao();
		int count= user.saveUser("669", "anil", "anil@gmail.com", "75575585");
		assertEquals(count, 1);
  }
	@Test
	public void shouldUpdateUser() throws Exception {
		UserDao dao=new UserDao();
		Customer updatedUser =dao.updateUser("668", "venu", "chandra@gmail.com", "2758257298");
		assertNotNull(updatedUser);
	}
	@Test
	public void shouldNotUpdateUser() throws Exception {
		UserDao dao=new UserDao();
		Customer updatedUser =dao.updateUser("99", "chandra", "chandra@gmail.com", "2758257298");
		assertNull(updatedUser);
	}
	@Test
	public void shouldDeleteUser() throws Exception {
		UserDao dao=new UserDao();
		int deletedtedUser =dao.deleteUser("879");
		assertNotNull(deletedtedUser);
		assertEquals(deletedtedUser,1);
	}
	@Test
	public void shouldNotDeleteUser() throws Exception {
		UserDao dao=new UserDao();
		int deletedtedUser =dao.deleteUser("32");
		assertNotNull(deletedtedUser);
		assertEquals(deletedtedUser,0);
	}
	@Test
	public void shouldListAllUsers() throws Exception {
		UserDao dao=new UserDao();
		List<Customer> list =dao.listAllUsers();
		assertNotNull(list);
	}
}