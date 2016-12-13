package problems.numberConverter.britishnumberunits;

import problems.numberConverter.common.InvalidNumberException;

/**
 * @author Anil Kurian
 *
 */
public class Million extends AbstractNumberUnit {

	public Million(final int power) {
		super(power);
	}

	@Override
	public String getString() throws InvalidNumberException {
		if (number == 0) {
			return null;
		}
		return AbstractNumberUnit.getStringForNumber(number) + " million";
	}

	@Override
	public String toString() {
		return number + " million ";
	}
}
