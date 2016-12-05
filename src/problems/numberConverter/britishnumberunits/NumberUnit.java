package problems.numberConverter.britishnumberunits;

import problems.numberConverter.common.InvalidNumberException;

public interface NumberUnit {

	/**
	 * @return English representation of the number represented by the object
	 * @throws InvalidNumberException
	 */
	abstract public String getString() throws InvalidNumberException;

	/**
	 * Add a new number to the next digit on the object
	 * 
	 * @param number
	 */
	abstract public void addNumber(int number);

}
