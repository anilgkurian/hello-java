package problems.numberConverter.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import problems.numberConverter.numberconverter.NumberConverter;

/**
 *
 */
public class StartNumberConverter {

	public static void main(final String[] args) {
		System.out.println("Enter a number or 'q' to quit...");
		String input = "";
		try {
			while (true) {
				final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
				if (input.equals("q")) {
					System.out.println("Existing...");
					System.exit(1);
				}
				final NumberConverter converter = new NumberConverter(input);
				try {
					System.out.println(converter.convertNumberToString());
				} catch (final NumberFormatException e) {
					System.err.println("Try again, Invalid entry " + input + " - " + e.getMessage());
				}
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
