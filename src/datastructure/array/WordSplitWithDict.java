package datastructure.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSplitWithDict {

    private static final String[] dict = {"i","like","the","blue","sky"};

    public static void main(String[] args) {

        Arrays.parallelSort(dict);
        List<String> splitWords = splitWord("ilikethebluesky");
        System.out.println(splitWords.toString());

    }

    private static boolean doesWordExist(String[] dict, String key){
        int index = 0;

        index = Arrays.binarySearch(dict, key.toLowerCase());	// best since dict is sorted
        if(index>= 0) {
            return true;
        }
        return false;
    }

    private static List<String> splitWord(String phrase) {
        char[] cArray = phrase.toCharArray();
        String word = "";
        List<String> splitwords = new ArrayList<String>();

        for(int i=0; i< cArray.length; i++){
            word+=cArray[i];
            if(doesWordExist(dict, word)) {
                splitwords.add(word);
                word = "";
            }
        }
        return splitwords;
    }

}