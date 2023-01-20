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
		dao.create();		// Calls the DAOImpl to create the Customer Array
	}
	
	public void fetch() {
		dao.read();			// Calls the DAOImpl to read all Customer info. in the Customer Array
	}
	
	public void modify(String cID) {
		dao.update(cID);	// Calls the DAOImpl to update a Customer in the Customer Array
	}
	
	public void delete(String cID) {
		dao.delete(cID);	// Calls the DAOImpl to delete a Customer the Customer Array
	}
	
	public void findCustomerByID(String cID) {
		dao.findCustomerByID(cID);	// Calls the DAOImpl to find a Customer in the Customer Array
	}

	public void findYoungestCustomer() {
		dao.findYoungestCustomer();	//	Calls the DAOImple to find the Youngest Customer in Customer Array
	}
}
