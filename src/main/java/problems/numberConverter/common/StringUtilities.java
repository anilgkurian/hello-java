package problems.numberConverter.common;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Anil Kurian
 *
 */
public abstract class StringUtilities {

	public static String convertToSingleString(final Collection<String> collection) {
		final StringBuilder result = new StringBuilder();
		final Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			result.append(iterator.next());
		}

		return result.toString();
	}
}