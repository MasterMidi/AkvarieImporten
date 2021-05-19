package exception;


public class SpeciesException extends Exception {
	private static final long serialVersionUID = 1L;

	public SpeciesException(String message, Throwable e) {
		super(message, e);
	}
}
