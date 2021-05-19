package exception;


public class FeedingPlanException extends Exception {
	private static final long serialVersionUID = 1L;

	public FeedingPlanException(String message, Throwable e) {
		super(message, e);
	}
}
