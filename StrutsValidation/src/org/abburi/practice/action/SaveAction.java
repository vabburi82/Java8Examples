package org.abburi.practice.action;

import org.abburi.practice.dao.CustomerDao;
import org.abburi.practice.dto.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class SaveAction extends ActionSupport{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private CustomerDao dao;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String addCustomer() throws Exception {
		dao = new CustomerDao();
		dao.saveUser(customer);
		return "success";
//		return SUCCESS;
	}
}

