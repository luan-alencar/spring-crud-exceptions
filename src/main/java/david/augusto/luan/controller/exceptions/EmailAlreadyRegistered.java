package david.augusto.luan.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyRegistered extends ResponseStatusException {
	private static final long serialVersionUID = 1L;

	public EmailAlreadyRegistered(HttpStatus status, String reason) {
		super(status, reason);
	}

}
