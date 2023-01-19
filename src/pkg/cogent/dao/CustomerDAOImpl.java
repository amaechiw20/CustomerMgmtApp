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
public class CustomerDAOImpl implements CustomerDAO{ // Implementation of Customer DAO

	Customer customers[];
	Scanner sc = new Scanner(System.in);

	@Override
	public void create() {
		try {
			System.out.println("How many customer you want to store?");
			int size = sc.nextInt();
			customers = new Customer[size];
			for(int i = 0; i < customers.length; i++) {

				Customer temp = new Customer();
				System.out.print("Please enter customer ID: ");
				String cID = sc.next();
				System.out.print("Please enter customer Name: ");
				String cName = sc.next();
				System.out.print("Please enter customer Email: ");
				String cEmail = sc.next();
				try {
					System.out.println("Please enter customer DOB");
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
					temp.setcDOB(DOB);
					temp.setcID(cID);
					temp.setcName(cName);
					temp.setcEmail(cEmail);
					validateMandatoryField(temp);
					customers[i] = temp;	
					System.out.print("\n");
				} catch(DateTimeParseException dtpe) {
					System.out.println("This is not a valid date. Please Try Again.");
					System.out.print("\n");
				}

			}
		} catch(InputMismatchException ime) {
			System.out.print("Improper Inputs. Please Try Again.");
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
		boolean noList = true;
		for(Customer cust : customers) {
			if (cust != null) {
				System.out.println("Customer ID: " +  cust.getcID());
				System.out.println("Customer Name: " + cust.getcName());
				System.out.println("Customer E-mail: " + cust.getcEmail());
				System.out.println("Customer DOB: " + cust.getcDOB().toString() + "\n");
			}
		}
		if(noList) {
			System.out.println("No Customer List to Read");
		}
	}

	@Override
	public void update(String customerID) {
		boolean notFound = true;
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].getcID().equals(customerID)) {
				notFound = false;
				updateName(customers[i]);
				updateEmail(customers[i]);
				updateDOB(customers[i]);
				System.out.print("\n");
			}
		}
		if(notFound) {
			System.out.println("No Customer of ID: " + customerID + " was found.");
		}
	}
	
	private void updateName(Customer cust) {
		try{
		System.out.println("New Customer Name: ");
		String newName = sc.next();
		cust.setcName(newName);
		} catch(InputMismatchException ime) {
			System.out.print("Improper Inputs. Please Try Again.");
		}
	}
	
	private void updateEmail(Customer cust) {
		try{
		System.out.println("New Customer Email: ");
		String newEmail = sc.next();
		cust.setcEmail(newEmail);
		} catch(InputMismatchException ime) {
			System.out.print("Improper Inputs. Please Try Again.");
		}
	}
	
	private void updateDOB(Customer cust) {
		try {
			System.out.println("New Customer DOB");
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
		} catch(InputMismatchException ime) {
			System.out.print("Improper Inputs. Please Try Again.");
		}catch(DateTimeParseException dtpe) {
			System.out.println("This is not a valid date. Please Try Again.");
		}
	}
	
	@Override
	public void delete(String customerID) {
		System.out.println("Deleting Customer");
		boolean notFound = true;
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].getcID().equals(customerID)) {
				notFound = false;
				customers[i] = null;
			}
		}
		if(notFound) {
			System.out.println("No Customer of ID: " + customerID + " was found.");
		}
	}

	@Override
	public void findCustomerByID(String customerID) {
		System.out.println("Finding Customer with ID: " + customerID);
		boolean notFound = true;
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].getcID().equals(customerID)) {
				System.out.println("Customer ID: " + customers[i].getcID());
				System.out.println("Customer Name: " + customers[i].getcName());
				System.out.println("Customer E-mail: " + customers[i].getcEmail());
				System.out.println("Customer DOB: " + customers[i].getcDOB());
				notFound = false;
			}
		}
		if(notFound) {
			System.out.println("No Customer of ID: " + customerID + " was found.");
		}
	}
	
	@Override
	public void findYoungestCustomer() {
		boolean noList = true;
		Customer young = new Customer();
		int youngestYear = 0;
		for(int i = 0; i < customers.length; i++) {
			if (customers[i] != null) {
				if(customers[i].getcDOB().getYear() > youngestYear) {
					young = customers[i];
					noList = false;
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
				System.out.println("Customer DOB:" + young.getcDOB().toString());	
			}
		}
	}
}
