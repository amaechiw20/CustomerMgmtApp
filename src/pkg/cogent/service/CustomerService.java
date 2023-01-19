package pkg.cogent.service;

import pkg.cogent.dao.CustomerDAOImpl;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Jan 18, 2023
 */
public class CustomerService {
	CustomerDAOImpl dao;
	public CustomerService() {
		dao = new CustomerDAOImpl();
	}
	
	public void save() {
		dao.create();
	}
	
	public void fetch() {
		dao.read();
	}
	
	public void modify(String cID) {
		dao.update(cID);
	}
	
	public void delete(String cID) {
		dao.delete(cID);
	}
	
	public void findCustomerByID(String cID) {
		dao.findCustomerByID(cID);
	}

	public void findYoungestCustomer() {
		dao.findYoungestCustomer();
	}
}
