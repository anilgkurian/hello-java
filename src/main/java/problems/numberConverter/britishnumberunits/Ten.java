package problems.numberConverter.britishnumberunits;

import java.util.LinkedHashMap;
import java.util.Map;

import problems.numberConverter.common.InvalidNumberException;

/**
 * One, teens & tens
 * 
 * @author Anil Kurian
 *
 */
public class Ten extends AbstractNumberUnit {

	private static Map<Integer, String> numberStrings = new LinkedHashMap<Integer, String>();

	public Ten(final int power) {
		super(power);
	}

	@Override
	public String getString() throws InvalidNumberException {
		String string = numberStrings.get(number);
		if (string == null) {
			string = AbstractNumberUnit.getStringForNumber(number);
		}
		return string;
	}

	public static String getNumberString(final Integer number) {
		return numberStrings.get(number);
	}

	static {
		numberStrings.put(0, "");
		numberStrings.put(1, "one");
		numberStrings.put(2, "two");
		numberStrings.put(3, "three");
		numberStrings.put(4, "four");
		numberStrings.put(5, "five");
		numberStrings.put(6, "six");
		numberStrings.put(7, "seven");
		numberStrings.put(8, "eight");
		numberStrings.put(9, "nine");
		numberStrings.put(10, "ten");
		numberStrings.put(11, "eleven");
		numberStrings.put(12, "twelve");
		numberStrings.put(13, "thriteen");
		numberStrings.put(14, "fourteen");
		numberStrings.put(15, "fifteen");
		numberStrings.put(16, "sixteen");
		numberStrings.put(17, "seventeen");
		numberStrings.put(18, "eighteen");
		numberStrings.put(19, "nineteen");
		numberStrings.put(20, "twenty");
		numberStrings.put(30, "thirty");
		numberStrings.put(40, "fourty");
		numberStrings.put(50, "fifty");
		numberStrings.put(60, "sixty");
		numberStrings.put(70, "seventy");
		numberStrings.put(80, "eighty");
		numberStrings.put(90, "ninety");
	}

	@Override
	public String toString() {
		return number + " tens ";
	}

}
