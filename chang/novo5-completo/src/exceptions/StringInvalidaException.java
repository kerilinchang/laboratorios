package exceptions;

public class StringInvalidaException extends Exception {

	/**
	 * Exception lancada caso a String seja invalida, ou o campo que contem
	 * String seja null.
	 */
	private static final long serialVersionUID = 1L;

	public StringInvalidaException(String message) {
		super(message);
	}

}
