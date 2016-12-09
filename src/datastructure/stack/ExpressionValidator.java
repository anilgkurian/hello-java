package datastructure.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * Validates the given expression for open and closed braces.
 *
 * @author Anil Kurian
 *
 */
public class ExpressionValidator {

	private static List<String> testInputs = new ArrayList<String>();

	static Map<String, String> pairs = new HashMap<String, String>();

	static {
		testInputs.add("{{[]}}");
		testInputs.add("{[()]}");
		testInputs.add("{[]}}");
		testInputs.add("{[][");
		testInputs.add("}{");
	}

	static {
		pairs.put("{", "}");
		pairs.put("[", "]");
		pairs.put("(", ")");
	}

	public static void main(final String[] args) {

		for (final String input : testInputs) {
			verify(input);
		}
	}

	private static void verify(final String input) {
		final LinkedList<String> stack = new LinkedList<String>();
		for (final String symbol : input.split("")) {
			if (isOpenSymbol(symbol)) {
				stack.push(symbol);
			} else if (isCloseSymbol(symbol)) {
				final String lastSymbol = stack.peek();
				if (isPair(symbol, lastSymbol)) {
					stack.pop();
				} else {
					System.out.println(input + " is NOT valid");
					return;
				}
			}

		}

		if (stack.isEmpty()) {
			System.out.println(input + " is valid");
		} else {
			System.out.println(input + " is NOT valid, not all are closed");
		}
	}

	private static boolean isPair(final String symbol, final String lastSymbol) {
		return symbol.equals(pairs.get(lastSymbol));
	}

	private static boolean isCloseSymbol(final String symbol) {
		return pairs.containsValue(symbol);
	}

	private static boolean isOpenSymbol(final String symbol) {
		return pairs.containsKey(symbol);
	}
}
