package problems.numberConverter.britishnumberunits;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import problems.numberConverter.common.InvalidNumberException;
import problems.numberConverter.common.StringUtilities;

public abstract class AbstractNumberUnit implements NumberUnit {

	/**
	 * Number which is represented by this number unit
	 */
	protected int number;

	/**
	 * increased by one with each call to addNumber()
	 */
	private int tenPower = 1;

	private static final String EMPTY_SPACE = " ";

	private static final String AND = "and";

	AbstractNumberUnit(final int number) {
		this.number = number;
	}

	@Override
	public void addNumber(final int number) {
		final double powerOfNumber = Math.pow(10, this.tenPower);
		this.number = (int) (this.number + (powerOfNumber * number));
		this.tenPower++;
	}

	@Override
	abstract public String getString() throws InvalidNumberException;

	/**
	 * Single string representation for a number belongs to one number unit
	 * 
	 * @param number
	 * @return
	 * @throws InvalidNumberException
	 */
	public static String getStringForNumber(final int number) throws InvalidNumberException {
		int remainingDigits = number;
		int tenthPower = 1;

		final int lastTwoDigit = number % 100;

		final List<String> numberRep = new LinkedList<String>();

		final String stringForLastTwo = Ten.getNumberString(lastTwoDigit);
		boolean lastTwoAdded = false;
		if (stringForLastTwo != null) {
			numberRep.add(EMPTY_SPACE + stringForLastTwo);
			remainingDigits = remainingDigits / 100;
			tenthPower++;
			tenthPower++;
			lastTwoAdded = true;
		}
		while (remainingDigits != 0) {
			final int currentDiigit = remainingDigits % 10;

			NumberUnit numberUnit = null;

			if (tenthPower == 2) { // for 22s, 34s etc
				numberUnit = NumberUnitsFactory.getNumberUnit(currentDiigit * 10, tenthPower);
				numberRep.add(numberUnit.getString() + EMPTY_SPACE);
			} else {
				numberUnit = NumberUnitsFactory.getNumberUnit(currentDiigit, tenthPower);
				String joiner = lastTwoAdded ? "" : EMPTY_SPACE;
				if (isTensPresent(numberRep)) {
					joiner = EMPTY_SPACE + AND + joiner;
				}
				numberRep.add(numberUnit.getString() + joiner);
			}
			remainingDigits = remainingDigits / 10;
			tenthPower++;
		}

		Collections.reverse(numberRep);
		final String trim = StringUtilities.convertToSingleString(numberRep).trim();
		return trim;
	}

	/**
	 * @param numberRep
	 * @return
	 */
	private static boolean isTensPresent(final List<String> numberRep) {
		return !StringUtilities.convertToSingleString(numberRep).trim().equals("");
	}
}
