package problems.numberConverter.britishnumberunits;

import problems.numberConverter.common.InvalidNumberException;

public class Thousand extends AbstractNumberUnit {

	public Thousand(final int number) {
		super(number);
	}

	@Override
	public String getString() throws InvalidNumberException {
		if (this.number == 0) {
			return null;
		}
		return AbstractNumberUnit.getStringForNumber(this.number) + " thousand";
	}

	@Override
	public String toString() {
		return this.number + " thousand ";
	}

}
