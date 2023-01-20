package pkg.cogent.client;

import pkg.cogent.controller.CustomerController;

import java.util.Scanner;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Jan 18, 2023
 */

public class Main {
	public static void main (String[] args) {

		int choice = 0;
		Scanner sc = new Scanner(System.in);
		CustomerController cc = new CustomerController();

		do {
			System.out.println("1 - Add Customers");
			System.out.println("2 - Lists All Customers");
			System.out.println("3 - Update a Customer in the Collection");
			System.out.println("4 - Delete a Customer from the Collection");
			System.out.println("5 - Find a Customer in the Collection");
			System.out.println("6 - Find the Youngest Customer in the Collection");
			System.out.println("7 - Exit App");
			
			choice = sc.nextInt(); // Client inputs what they wish to do based on what number they enter
			cc.accept(choice);
		} while (choice != 7);
		sc.close();
	}
}