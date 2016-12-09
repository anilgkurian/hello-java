package problems.numberConverter.common;

/**
 * @author Anil Kurian
 *
 */
public class InvalidNumberException extends NumberFormatException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNumberException(final String messaage) {
		super(messaage);
	}
}
