package org.abburi.practice.action;

import org.abburi.practice.dto.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class EditAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	public String editCustomer() throws Exception {
		System.out.println("Edit name = "+getCustomer().getName());
		System.out.println("Edit email = "+getCustomer().getEmail());
		System.out.println("Edit phone = "+getCustomer().getPhone());
		return SUCCESS;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
