package pkg.cogent.dao;

import pkg.cogent.exception.MandatoryFieldException;
import pkg.cogent.model.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Jan 18, 2023
 */
public class CustomerDAOImpl implements CustomerDAO{	//	Implementation of Customer DAO

	Customer customers[];
	Scanner sc = new Scanner(System.in);

	@Override
	public void create() {	//	This called when the user's choice = 1. Creates an Array of Customers
		try {
			System.out.println("How many customer you want to store?");
			int size = sc.nextInt();
			customers = new Customer[size];
			for(int i = 0; i < customers.length; i++) {
				Customer temp = new Customer();
				System.out.print("Please enter customer ID: ");
				String cID = sc.next(); // ID
				System.out.print("Please enter customer Name: ");
				String cName = sc.next(); // Name
				System.out.print("Please enter customer Email: ");
				String cEmail = sc.next(); // Email
				try {
					System.out.println("Please enter customer DOB");
					System.out.print("Month: ");
					int mm = sc.nextInt();	//	DOB month
					sc.nextLine();
					System.out.print("Day: ");
					int  dd = sc.nextInt();	//	DOB day
					sc.nextLine();
					System.out.print("Year: ");
					int yyyy = sc.nextInt();	//	DOB year
					String cDOB = yyyy + "-" + String.format("%02d", mm) + "-" + String.format("%02d", dd);
					LocalDate DOB = LocalDate.parse(cDOB);	//	Creates DOB for customer to be store. Throws DateTimeExcption if not a valid date
					temp.setcDOB(DOB);
					temp.setcID(cID);
					temp.setcName(cName);
					temp.setcEmail(cEmail);
					validateMandatoryField(temp);	//	Checks if Customer Object is empty || Customer ID is empty
					customers[i] = temp;	
					System.out.print("\n");
				} catch(DateTimeParseException dtpe) {	//	Checks if DOB is valid; if not, print error message and throws ManadatoryFieldException to clear list
					System.err.println("This is not a valid date. Please Try Again.");
					throw new MandatoryFieldException();
				}

			}
		} catch(InputMismatchException ime) {	//	Checks if the input of Scanner is correct; if not prints error message and clear list
			System.err.println("Improper Inputs. Please Try Again.");
			sc.nextLine();
			customers = null;
		}
		catch(MandatoryFieldException mfe){
			customers = null;
		}

	}

	public void validateMandatoryField(Customer customer) {	//	Checks if the Mandatory fields in Customer is valid
		if (customer == null) {
			throw new MandatoryFieldException("Customer Object can not be left blank");
		}
		else if(customer.getcID() == null)
		{
			throw new MandatoryFieldException("Customer ID can not be left blank");
		}
	}

	@Override
	public void read() { // This called when the user's choice = 2. Reads an Array of Customers
		try {
			for(int i = 0; i < customers.length; i++) {
				if(customers[i] != null) { // Checks is Customer is null, if not prints out Customer Info
					System.out.println("Customer ID: " + customers[i] .getcID());
					System.out.println("Customer Name: " + customers[i] .getcName());
					System.out.println("Customer E-mail: " + customers[i] .getcEmail());
					System.out.println("Customer DOB: " + customers[i] .getcDOB().toString() + "\n");
				}
			}

		} catch(NullPointerException npe) { // Checks if there is no Customer Array 
			
			System.err.println("There is no Customer List to Read");
		}

	}

	@Override
	public void update(String customerID) { // This called when the user's choice = 3. Updates a Customer an Array of Customers
		try {
			boolean notFound = true; // This is true if The ID being search is not found
			Customer customer = new Customer();
			for(int i = 0; i < customers.length; i++) {
				if(customers[i] != null) { // Checks is Customer in Customer Array is null
					if(customers[i].getcID().equals(customerID)) {
						customer = customers[i];
						notFound = false;
					}
				}
			}

			if(notFound) { // Prints Message to Client that ID was not found in out List
				System.out.println("No Customer of ID: " + customerID + " was found.");
			}
			else {
				updateName(customer);
				updateEmail(customer);
				updateDOB(customer);
				System.out.print("\n");
			}
		} catch(NullPointerException npe) {
			System.err.println("There is no Customer List to Read");
		}

	}
	private void updateName(Customer cust) { // Updates Customers's name
		try{
			System.out.println("New Customer Name: ");
			String newName = sc.next();
			cust.setcName(newName);
			validateMandatoryField(cust);

			System.out.println("Name has been updated.");
		} catch(InputMismatchException ime) {
			System.err.print("Improper Inputs. Name has not been updated.");
		}

	}

	private void updateEmail(Customer cust) { // Updates Customer's Email
		try{
			System.out.println("New Customer Email: ");
			String newEmail = sc.next();
			cust.setcEmail(newEmail);
			System.out.println("Email has been updated.");
		} catch(InputMismatchException ime) {
			System.err.print("Improper Inputs. Email has not been updated.");
		}
	}

	private void updateDOB(Customer cust) { // Update Customer's DOB
		try {
			System.out.println("New Customer DOB:");
			System.out.print("Month: ");
			int mm = sc.nextInt();
			sc.nextLine();
			System.out.print("Day: ");
			int  dd = sc.nextInt();
			sc.nextLine();
			System.out.print("Year: ");
			int yyyy = sc.nextInt();
			String cDOB = yyyy + "-" + String.format("%02d", mm) + "-" + String.format("%02d", dd);
			LocalDate DOB = LocalDate.parse(cDOB);
			cust.setcDOB(DOB);
			System.out.println("Date of Birth has been updated.");
		} catch(InputMismatchException ime) {
			System.err.print("Improper Inputs. Date of Birth has not been updated.");
		} catch(DateTimeParseException dtpe) {
			System.err.println("This is not a valid date. Date of Birth has not been updated.");
		}
	}

	@Override
	public void delete(String customerID) { // This called when the user's choice = 4. Deletes a Customer an Array of Customers
		try {
			boolean notFound = true;
			for(int i = 0; i < customers.length; i++) {
				if(customers[i] != null) { // Checks is Customer is null
					if(customers[i].getcID().equals(customerID)) {
						customers[i] = null;
						notFound = false;
					}
				}
			}

			if(notFound) {
				System.out.println("No Customer of ID: " + customerID + " was found.");
			}
			else {
				System.out.println("Deleting Customer: " + customerID);
			}
		} catch(NullPointerException npe) {
			System.err.println("There is no Customer List to Read");
		}
	}

	@Override
	public void findCustomerByID(String customerID) {// This called when the user's choice = 5. Find a Customer an Array of Customers
		System.out.println("Finding Customer with ID: " + customerID);
		try {
			boolean notFound = true;
			Customer customer = new Customer();
			for(int i = 0; i < customers.length; i++) {
				if(customers[i] != null) { // Checks is Customer is null
					if(customers[i].getcID().equals(customerID)) {
						customer = customers[i];
						notFound = false;
					}
				}
			}
			if(notFound) {
				System.out.println("No Customer of ID: " + customerID + " was found.");
			}
			else {
				System.out.println("Customer ID: " + customer.getcID());
				System.out.println("Customer Name: " + customer.getcName());
				System.out.println("Customer E-mail: " + customer.getcEmail());
				System.out.println("Customer DOB: " + customer.getcDOB());
			}
		} catch(NullPointerException npe) {
			System.err.println("There is no Customer List to Read");
		}
	}

	@Override
	public void findYoungestCustomer() { // This called when the user's choice = 6. Find the youngest Customer an Array of Customers
		try {
			boolean noList = true;
			Customer young = new Customer();
			int youngestYear = 0;
			for(int i = 0; i < customers.length; i++) {
				if(customers[i] != null) { // Checks is Customer is null
					if(customers[i].getcDOB().getYear() > youngestYear) { 	// Checks which the birth year for each customer
																			// The Customer with the largest Birth Year is the youngest customer
						young = customers[i];
						noList = false;
					}
				}
			}	
			if(noList) {
				System.out.println("No Customers List to Read");
			}
			else {
				System.out.println("Youngest Customer:");
				System.out.println("Customer ID: " + young.getcID());
				System.out.println("Customer Name: " + young.getcName());
				System.out.println("Customer E-mail: " + young.getcEmail());
				System.out.println("Customer DOB: " + young.getcDOB().toString());	
			}

		} catch(NullPointerException npe) {
			System.err.println("There is no Customer List to Read");
		}
	}
}
