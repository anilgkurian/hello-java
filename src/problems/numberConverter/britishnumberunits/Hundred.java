package problems.numberConverter.britishnumberunits;

import problems.numberConverter.common.InvalidNumberException;

/**
 * @author Anil Kurian
 *
 */
public class Hundred extends AbstractNumberUnit {

	public Hundred(final int number) {
		super(number);
	}

	@Override
	public String getString() throws InvalidNumberException {
		if (number == 0) {
			return null;
		}
		return AbstractNumberUnit.getStringForNumber(number) + " hundred";
	}

	@Override
	public String toString() {
		return number + " hundred ";
	}
}
