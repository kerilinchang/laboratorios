package exceptions;

public class ConversaoUsuarioException extends Exception {

	/**
	 * Construtor da Exception para casos de cast invalido no usuario.
	 */
	private static final long serialVersionUID = 1L;

	public ConversaoUsuarioException(String message) {
		super(message);
	}

}
