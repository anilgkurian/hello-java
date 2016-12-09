package problems.numberConverter.numberconverter;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import problems.numberConverter.britishnumberunits.Hundred;
import problems.numberConverter.britishnumberunits.Million;
import problems.numberConverter.britishnumberunits.NumberUnit;
import problems.numberConverter.britishnumberunits.NumberUnitsFactory;
import problems.numberConverter.britishnumberunits.NumberUnitsFactory.Type;
import problems.numberConverter.britishnumberunits.Ten;
import problems.numberConverter.britishnumberunits.Thousand;
import problems.numberConverter.common.InvalidNumberException;

/**
 * @author Anil Kurian
 *
 */
public class NumberConverter {

	/**
	 * input number in string
	 */
	private final String numberString;

	/**
	 * parsed int value of input string
	 */
	private int number;

	/**
	 * output result
	 */
	private StringBuilder result = new StringBuilder();

	/**
	 * Holder for different number units which aggregates to form the full
	 * number
	 */
	private final Map<NumberUnitsFactory.Type, NumberUnit> fullNumberUnits = new LinkedHashMap<NumberUnitsFactory.Type, NumberUnit>();

	public NumberConverter(final String number) {
		numberString = number.trim();
	}

	/**
	 * To convert the number in digits to letters
	 *
	 * @return
	 * @throws InvalidNumberException
	 */
	public String convertNumberToString() throws InvalidNumberException {

		if (isZero()) {
			return "zero";
		}

		number = Integer.parseInt(numberString);

		final String tens = checkForTens();
		if (tens != null) {
			return tens;
		}

		int digitPosition = 1;
		int remainingDigits = number;

		while (remainingDigits != 0) {
			final int currentDigit = remainingDigits % 10;
			createNumberUnit(digitPosition, currentDigit);
			remainingDigits = remainingDigits / 10;
			digitPosition++;
		}

		createResult();

		return result.toString().trim();
	}

	/**
	 * Creates corresponding number units for each digit
	 *
	 * @param digitPosition
	 * @param currentDigit
	 * @throws InvalidNumberException
	 */
	private void createNumberUnit(final int digitPosition, final int currentDigit) throws InvalidNumberException {

		final Type type = NumberUnitsFactory.getType(digitPosition);

		if (type == null) {
			throw new InvalidNumberException("I dont support a number with " + digitPosition + " digits");
		}

		NumberUnit numberUnit = fullNumberUnits.get(type);
		if (numberUnit == null) {
			numberUnit = NumberUnitsFactory.getNumberUnit(currentDigit, digitPosition);
			fullNumberUnits.put(type, numberUnit);
		} else {
			numberUnit.addNumber(currentDigit);
		}
	}

	/**
	 * Makes the final result from the list of different number units.
	 *
	 * @throws InvalidNumberException
	 */
	private void createResult() throws InvalidNumberException {

		final Collection<NumberUnit> values = fullNumberUnits.values();

		final NumberUnit[] numberUnits = values.toArray(new NumberUnit[values.size()]);

		for (int i = numberUnits.length - 1; i >= 0; i--) {
			final String numberRepresentation = numberUnits[i].getString();
			if (numberRepresentation != null) {
				if (isANDrequired(numberUnits, i)) {
					result = result.append(numberRepresentation + " and ");
				} else {
					result = result.append(numberRepresentation + " ");
				}
			}
		}

	}

	/**
	 * Logic to check if "and" is required in the output. If current unit is
	 * hundred and there is something after it then add "and"
	 *
	 * @param numberUnits
	 * @param currentPos
	 * @return
	 * @throws InvalidNumberException
	 */
	private boolean isANDrequired(final NumberUnit[] numberUnits, final int currentPos) throws InvalidNumberException {
		return isNextToHundred(numberUnits, currentPos) || isTensAfterMillion(numberUnits, currentPos)
				|| isTensAfterThousand(numberUnits, currentPos);

	}

	/**
	 * @param numberUnits
	 * @param i
	 * @return
	 */
	private boolean isTensAfterThousand(final NumberUnit[] numberUnits, final int i) {
		return (numberUnits[i] instanceof Thousand) && (numberUnits[i - 1].getString() == null)
				&& (numberUnits[i - 2].getString() != null) && !numberUnits[i - 2].getString().equals("");
	}

	/**
	 * @param numberUnits
	 * @param i
	 * @return
	 */
	private boolean isTensAfterMillion(final NumberUnit[] numberUnits, final int i) {
		return (numberUnits[i] instanceof Million) && (numberUnits[i - 1].getString() == null)
				&& (numberUnits[i - 2].getString() == null) && (numberUnits[i - 3].getString() != null)
				&& !numberUnits[i - 3].getString().equals("");
	}

	/**
	 * @param numberUnits
	 * @param i
	 * @return
	 */
	private boolean isNextToHundred(final NumberUnit[] numberUnits, final int i) {
		return (numberUnits[i] instanceof Hundred) && (numberUnits[i - 1].getString() != null)
				&& !numberUnits[i - 1].getString().trim().equals("");
	}

	private boolean isZero() {
		return numberString.equals("0");
	}

	private String checkForTens() {
		return Ten.getNumberString(number);
	}

}
