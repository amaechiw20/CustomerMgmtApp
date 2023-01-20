package pkg.cogent.controller;

import java.util.Scanner;

import pkg.cogent.service.CustomerService;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Jan 18, 2023
 */
public class CustomerController {

	CustomerService cs;
	Scanner sc = new Scanner(System.in);

	public CustomerController() {
		cs = new CustomerService();
	}

	public void accept(int choice) {
		String cID;
		switch (choice) {
		case 1:
			cs.save(); // Is called by client to create Customer Array
			break;
		case 2:
			cs.fetch(); // Is called by client to list all Customers in Customer Array
			break;
		case 3:
			System.out.println("Please enter the customer ID");
			cID = sc.next();
			cs.modify(cID); // Is called by client to update a Customer's info in Customer Array based on their Customer ID
			break;
		case 4:
			System.out.println("Please enter the customer ID");
			cID = sc.next(); 
			cs.delete(cID); // Is called by client to delete Customer from Customer based on their Client ID
			break;
		case 5:
			System.out.println("Please enter the customer ID");
			cID = sc.next();
			cs.findCustomerByID(cID); // Is called by client to find Customer in Customer Array based on their Client ID
			break;
		case 6:
			cs.findYoungestCustomer(); // Is called by client to find the youngest Customer in our Client Array
			break;
		case 7:
			System.exit(choice); // Is called to close program
			break;
		}
	}

}