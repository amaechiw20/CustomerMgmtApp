package pkg.cogent.model;

import java.time.LocalDate;

/**
 * 
 * @author: William U. Amaechi
 * @date: 	Jan 18, 2023
 * 
 * Customer Bean Class for our Customer Management App 
 */
public class Customer {
	private String cID;		//	Customer ID
	private String cName;	//	Customer Name
	private String cEmail;	//	Customer Email
	private LocalDate cDOB;	//	Customer Date of Birth
	
	public Customer() {
		
	}
	
	public Customer(String cID, String cName, String cEmail, LocalDate cDOB) {
		super();
		this.cID = cID;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cDOB = cDOB;
	}

	//	Customer ID Getter and Setter
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}

	//	Customer Name Getter and Setter
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	//	Customer Email Getter and Setter
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	
	//	Customer DoB Getter and Setter
	public LocalDate getcDOB() {
		return cDOB;
	}
	public void setcDOB(LocalDate cDOB) {
		this.cDOB = cDOB;
	}
		
}
