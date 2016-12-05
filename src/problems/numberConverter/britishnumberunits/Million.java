package problems.numberConverter.britishnumberunits;

import problems.numberConverter.common.InvalidNumberException;

public class Million extends AbstractNumberUnit {

	public Million(final int power) {
		super(power);
	}

	@Override
	public String getString() throws InvalidNumberException {
		if (this.number == 0) {
			return null;
		}
		return AbstractNumberUnit.getStringForNumber(this.number) + " million";
	}

	@Override
	public String toString() {
		return this.number + " million ";
	}
}
