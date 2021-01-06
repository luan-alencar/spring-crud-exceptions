package david.augusto.luan.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserDoesNotExist extends ResponseStatusException {
	private static final long serialVersionUID = 1L;

	public UserDoesNotExist(HttpStatus status, String reason) {
		super(status, reason);
	}
}
