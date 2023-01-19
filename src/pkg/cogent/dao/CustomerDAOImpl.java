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
			if (cust != null) {
				System.out.println("Customer ID: " +  cust.getcID());
				System.out.println("Customer Name: " + cust.getcName());
				System.out.println("Customer E-mail: " + cust.getcEmail());
				if(cust.getcDOB() != null) {
					System.out.println("Customer DOB: " + cust.getcDOB());
				}
			}
		}
	}

	@Override
	public void update(String customerID) {
		System.out.println("Updating Customer Name and Email.");
		String response;
		boolean notFound = true;
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].getcID().equals(customerID)) {
				notFound = false;
				System.out.println("Update Customor Name?");
				response = sc.next().toLowerCase();
				switch(response) {
				case "y" :
				case "yes":
				{
					System.out.println("New Customer Name: ");
					String newName = sc.next();
					customers[i].setcName(newName);
				}
				case "n" :
				case "no":
				{
					System.out.println("Update Customor Name?");
					response = sc.next().toLowerCase();
					switch(response) {
					case "y" :
					case "yes":
					{
						System.out.println("New Customer Email: ");
						String newEmail = sc.next();
						customers[i].setcEmail(newEmail);
					}
					case "n" :
					case "no":
					{
						System.out.println("Nothing was updated");
					}
					}
				}
				}
			}
		}
		if(notFound) {
			System.out.println("No Customer of ID: " + customerID + " was found.");
		}
	}

	@Override
	public void delete(String customerID) {
		System.out.println("Deleting Customer Name and Email.");
		boolean notFound = true;
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].getcID().equals(customerID)) {
				customers[i] = null;
			}
		}
		if(notFound) {
			System.out.println("No Customer of ID: " + customerID + " was found.");
		}
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
