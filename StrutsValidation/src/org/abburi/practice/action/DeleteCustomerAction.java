package org.abburi.practice.action;

import org.abburi.practice.dao.CustomerDao;
import org.abburi.practice.dto.Customer;

public class DeleteCustomerAction {
	
	private Customer customer;
	private CustomerDao dao;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String execute() throws Exception {
		System.out.println("delete param = "+getCustomer().getName());
		dao = new CustomerDao();
		int deletedUser=dao.deleteUser(getCustomer().getName());
		if(deletedUser>0){
			return "success";
		}
		else{
			return "error";
		}
	}
}

