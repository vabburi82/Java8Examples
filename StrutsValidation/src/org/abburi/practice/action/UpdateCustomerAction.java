package org.abburi.practice.action;

import org.abburi.practice.dao.CustomerDao;
import org.abburi.practice.dto.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateCustomerAction extends ActionSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private String oldName;
	
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String updateCustomer() throws Exception{
		CustomerDao dao = new CustomerDao();
		String name=customer.getName();
		System.out.println("name:"+name);
		String email = customer.getEmail();
		System.out.println("email:"+ email);
		String phone = customer.getPhone();
		System.out.println("phone:"+phone);
		String oldName=getOldName();
		System.out.println("oldName:"+ oldName);
        int updatedUser=dao.updateUser(name, email, phone, oldName);
        System.out.println(updatedUser);
		if(updatedUser==1){
			return "success";
		}
		else{
			return "error";
		} 
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

}

