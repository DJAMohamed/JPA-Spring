package m2i.formation.exception;

public class FormationDataException extends FormationException {
	private static final long serialVersionUID = 1L;

	public FormationDataException() {
		super();
	}

	public FormationDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FormationDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormationDataException(String message) {
		super(message);
	}

	public FormationDataException(Throwable cause) {
		super(cause);
	}

	
}
