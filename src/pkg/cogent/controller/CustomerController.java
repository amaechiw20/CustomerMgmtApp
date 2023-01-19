package pkg.cogent.controller;

import java.util.Scanner;

import pkg.cogent.service.CustomerService;

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
			cs.save();
			break;
		case 2:
			cs.fetch();
			break;
		case 3:
			System.out.println("Please enter the customer ID");
			cID = sc.next();
			cs.modify(cID);
			break;
		case 4:
			System.out.println("Please enter the customer ID");
			cID = sc.next();
			cs.delete(cID);
			break;
		case 5:
			System.out.println("Please enter the customer ID");
			cID = sc.next();
			cs.findCustomerByID(cID);
			break;
		case 6:
			cs.findYoungestCustomer();
			break;
		case 7:
			System.exit(choice);
			break;
		}
	}

}