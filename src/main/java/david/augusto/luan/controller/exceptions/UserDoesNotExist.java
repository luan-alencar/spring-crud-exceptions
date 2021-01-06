package david.augusto.luan.controller.exceptions;

public class UserDoesNotExist extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserDoesNotExist(String message) {
		super(message);
	}
}
