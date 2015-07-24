package exceptions;

public class ScoreException extends Exception {

	/**
	 * Exception para casos de score invalido no usuario, ou que nao alcancou o
	 * quantidade necessaria.
	 */
	private static final long serialVersionUID = 1L;

	public ScoreException(String message) {
		super(message);
	}

}
