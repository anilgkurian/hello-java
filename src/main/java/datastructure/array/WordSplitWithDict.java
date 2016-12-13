package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anil Kurian
 * Splits the given string into words from dictionary 
 */
public class WordSplitWithDict {

	private static final String[] dict = { "i", "like", "the", "blue", "sky" };

	public static void main(final String[] args) {

		Arrays.parallelSort(dict);
		final List<String> splitWords = splitWord("ilikethebluesky");
		System.out.println(splitWords.toString());

	}

	private static boolean doesWordExist(final String[] dict, final String key) {
		int index = 0;

		index = Arrays.binarySearch(dict, key.toLowerCase()); // best since dict
																// is sorted
		if (index >= 0) {
			return true;
		}
		return false;
	}

	private static List<String> splitWord(final String phrase) {
		final char[] cArray = phrase.toCharArray();
		String word = "";
		final List<String> splitwords = new ArrayList<String>();

		for (final char element : cArray) {
			word += element;
			if (doesWordExist(dict, word)) {
				splitwords.add(word);
				word = "";
			}
		}
		return splitwords;
	}

}