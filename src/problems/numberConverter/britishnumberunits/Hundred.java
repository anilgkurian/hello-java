package problems.numberConverter.britishnumberunits;

import problems.numberConverter.common.InvalidNumberException;

public class Hundred extends AbstractNumberUnit {

	public Hundred(final int number) {
		super(number);
	}

	@Override
	public String getString() throws InvalidNumberException {
		if (this.number == 0) {
			return null;
		}
		return AbstractNumberUnit.getStringForNumber(this.number) + " hundred";
	}

	@Override
	public String toString() {
		return this.number + " hundred ";
	}
}
