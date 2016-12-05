package problems.numberConverter.common;

public class InvalidNumberException extends NumberFormatException {

	public InvalidNumberException(final String messaage) {
		super(messaage);
	}
}
