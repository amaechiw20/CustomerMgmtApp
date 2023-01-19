package pkg.cogent.dao;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Jan 18, 2023
 */
public interface CustomerDAO {
	void create();						//	Method that Creates the Customer Collection
	void read();						//	Method that Lists out the Customer's ID, Name, and Email in the Customer Collection
	void update(String customerID);		//	Method that Updates a Customer's Name and Email based on their Customer ID
	void delete(String customerID);		//	Method that Deletes a Customer from the Customer Collection
	void findCustomerByID(String cID);	//	Method that Searches for a Customer in our Customer Collection
	void findYoungestCustomer();		//	Method that Searches for the youngest Customer in out Customer Collection
}
