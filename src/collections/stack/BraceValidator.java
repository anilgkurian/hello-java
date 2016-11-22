package collections.stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BraceValidator {

	private static List<String> inputs = new ArrayList<String>();
	
	static Map<String,String> pairs = new HashMap<String,String>();

	static {
		inputs.add("{{[]}}");
		inputs.add("{[()]}");
		inputs.add("{[]}}");
		inputs.add("{[][");
		
	}
	
	
	static {
		pairs.put("{","}");
		pairs.put("[","]");
		pairs.put("(",")");
		
	}
	
	
	
	public static void main(String[] args) {
		
		for(String input: inputs) {
			verify(input);
		}
	}



	private static void verify(String input) {
		LinkedList<String> stack = new LinkedList<String>();
		for(String symbol:input.split("")) {
			if(pairs.containsKey(symbol)) {
				stack.push(symbol);
			}else if(pairs.containsValue(symbol)) {
				if(stack.isEmpty()) {
					System.out.println(input +" is NOT valid 1");
					return;
				}
				String peek = stack.peek();
				if(symbol.equals(pairs.get(peek))) {
					stack.pop();
				}else {
					System.out.println(input +" is NOT valid 2");
					return;
				}
			}
			
		}
		
		if(stack.isEmpty()) {
			System.out.println(input +" is valid");
		}else {
			System.out.println(input +" is NOT valid 3");
		}
	}
}
