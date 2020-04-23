package exception;

import javax.servlet.ServletException;

public class BookException extends ServletException {

	private static final long serialVersionUID = -7084987067131069107L;

	public BookException(String message) {
		super(message);
	}

}
