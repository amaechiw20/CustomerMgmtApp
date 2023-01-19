package pkg.cogent.dao;

import pkg.cogent.exception.MandatoryFieldException;
import pkg.cogent.model.Customer;

import java.util.Scanner;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Jan 18, 2023
 */
public class CustomerDAOImpl implements CustomerDAO{ // Implementation of 

	Customer customers[];
	Scanner sc = new Scanner(System.in);

	@Override
	public void create() {

		System.out.println("How many customer you want to store?");
		int size = sc.nextInt();
		customers = new Customer[size];
		for(int i = 0; i < customers.length; i++) {
			Customer temp = new Customer();
			System.out.print("Please enter customer ID: ");
			String cID = sc.next();
			System.out.print("Please enter customer ID: ");
			String cName = sc.next();
			System.out.print("Please enter customer ID: ");
			String cEmail = sc.next();
			temp.setcID(cID);
			temp.setcName(cName);
			temp.setcEmail(cEmail);
			validateMandatoryField(temp);
			customers[i] = temp;
		}
	}

	public void validateMandatoryField(Customer customer) {
		if (customer == null) {
			throw new MandatoryFieldException("Customer Object can not be left blank");
		}
		else if(customer.getcID() == null)
		{
			throw new MandatoryFieldException("Customer ID can not be left blank");
		}
	}

	@Override
	public void read() {
		for(Customer cust : customers) {
			System.out.println("Customer ID: " +  cust.getcID());
			System.out.println("Customer Name: " + cust.getcName());
			System.out.println("Customer E-mail: " + cust.getcEmail());
			if(cust.getcDOB() != null) {
				System.out.println("Customer DOB: " + cust.getcDOB());
			}
		}
	}

	@Override
	public void update(String customerID) {
		System.out.println("Updating Customer Name and Email.");
		for(Customer cust : customers) {
			if(cust.getcID().equals(customerID)) {
				System.out.println("New Customer Name: ");
				String newName = sc.next();
				cust.setcName(newName);
				System.out.println("New Customer Email: ");
				String newEmail = sc.next();
				cust.setcEmail(newEmail);
			}
		}


	}

	@Override
	public void delete(String customerID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findCustomerByID(String cID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findYoungestCustomer() {
		// TODO Auto-generated method stub

	}
}
