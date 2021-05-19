package exception;


public class DateFormatException extends Exception {
	private static final long serialVersionUID = 1L;

	public DateFormatException(String message, Throwable e) {
		super(message, e);
	}
}
