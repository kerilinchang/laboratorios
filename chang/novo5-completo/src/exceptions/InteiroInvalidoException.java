package exceptions;

public class InteiroInvalidoException extends Exception {

	/**
	 * Construtor da exception para casos de numeros inteiros invalidos.
	 */
	private static final long serialVersionUID = 1L;

	public InteiroInvalidoException(String message) {
		super(message);
	}

}
