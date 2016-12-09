package problems.numberConverter.britishnumberunits;

/**
 * This class is responsible for grouping numbers into different number units.
 * For eg, in british system digits 4,5 & 6 represents thousand.
 * 
 * @author Anil Kurian
 */
public abstract class NumberUnitsFactory {

	public static enum Type {
		ONE, TEN, HUNDRED, THOUSAND, MILLION;
	}

	public static Type getType(final int pos) {
		switch (pos) {
		case 1:
		case 2:
			return Type.TEN;
		case 3:
			return Type.HUNDRED;
		case 4:
		case 5:
		case 6:
			return Type.THOUSAND;
		case 7:
		case 8:
		case 9:
			return Type.MILLION;
		}
		return null;
	}

	public static NumberUnit getNumberUnit(final int factor, final int power) {
		switch (power) {
		case 0:
		case 1:
		case 2:
			return new Ten(factor);
		case 3:
			return new Hundred(factor);
		case 4:
		case 5:
		case 6:
			return new Thousand(factor);
		case 7:
		case 8:
		case 9:
			return new Million(factor);
		}
		return null;
	}
}
