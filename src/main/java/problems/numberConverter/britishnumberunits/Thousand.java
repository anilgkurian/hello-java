package problems.numberConverter.britishnumberunits;

import problems.numberConverter.common.InvalidNumberException;

/**
 * @author Anil Kurian
 *
 */
public class Thousand extends AbstractNumberUnit {

	public Thousand(final int number) {
		super(number);
	}

	@Override
	public String getString() throws InvalidNumberException {
		if (number == 0) {
			return null;
		}
		return AbstractNumberUnit.getStringForNumber(number) + " thousand";
	}

	@Override
	public String toString() {
		return number + " thousand ";
	}

}
