package org.abburi.practice.action;

import org.abburi.practice.dao.CustomerDao;
import org.abburi.practice.dto.Customer;

public class SaveAction {
	

	
	private Customer customer;
	private CustomerDao dao;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String execute() throws Exception {
		dao = new CustomerDao();
		dao.saveUser(customer);
		return "success";
//		return SUCCESS;
	}
}

