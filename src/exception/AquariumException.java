package exception;


public class AquariumException extends Exception {
	private static final long serialVersionUID = 1L;

	public AquariumException(String message, Throwable e) {
		super(message, e);
	}
}
