package m2i.formation.exception;

public class FormationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FormationException() {
		super();
	}

	public FormationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FormationException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormationException(String message) {
		super(message);
	}

	public FormationException(Throwable cause) {
		super(cause);
	}

}
