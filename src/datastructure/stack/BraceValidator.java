package datastructure.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BraceValidator {

	private static List<String> inputs = new ArrayList<String>();

	static Map<String, String> pairs = new HashMap<String, String>();

	static {
		inputs.add("{{[]}}");
		inputs.add("{[()]}");
		inputs.add("{[]}}");
		inputs.add("{[][");
		inputs.add("}{");
	}

	static {
		pairs.put("{", "}");
		pairs.put("[", "]");
		pairs.put("(", ")");

	}

	public static void main(String[] args) {

		for (String input : inputs) {
			verify(input);
		}
	}

	private static void verify(String input) {
		LinkedList<String> stack = new LinkedList<String>();
		for (String symbol : input.split("")) {
			if (isOpenSymbol(symbol)) {
				stack.push(symbol);
			} else if (isCloseSymbol(symbol)) {
				String lastSymbol = stack.peek();
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

	private static boolean isPair(String symbol, String lastSymbol) {
		return symbol.equals(pairs.get(lastSymbol));
	}

	private static boolean isCloseSymbol(String symbol) {
		return pairs.containsValue(symbol);
	}

	private static boolean isOpenSymbol(String symbol) {
		return pairs.containsKey(symbol);
	}
}
