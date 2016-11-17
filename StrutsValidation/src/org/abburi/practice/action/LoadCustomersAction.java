package org.abburi.practice.action;

import java.util.List;

import org.abburi.practice.dao.CustomerDao;
import org.abburi.practice.dto.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class LoadCustomersAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
private List<Customer> custlist;


public List<Customer> getCustlist() {
	return custlist;
}


public void setCustlist(List<Customer> custlist) {
	this.custlist = custlist;
}


public String list() throws Exception{
	CustomerDao dao= new CustomerDao();
	setCustlist(dao.listAllCustomers());
	
	if(getCustlist().size()>0){
	return SUCCESS;
	}
	else{
		return ERROR;
	}
}
}