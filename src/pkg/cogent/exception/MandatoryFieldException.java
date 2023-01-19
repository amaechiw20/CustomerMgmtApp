package pkg.cogent.exception;

public class MandatoryFieldException extends RuntimeException{
	private String errorMessage;
	public MandatoryFieldException() {
		super();
	}
	
	public MandatoryFieldException(String errorMessage) {
		super(errorMessage);
		this.errorMessage=errorMessage;
	}

}


