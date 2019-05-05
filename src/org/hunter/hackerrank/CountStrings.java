import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CountStrings {

	static String [] alphabet = {
			"a",
			"b"
	};

	static String [] lengthTwoPossible = {
			"aa",
			"ab",
			"bb",
			"ba"
	};

    /*
     * Complete the countStrings function below.
     */
    static int countStrings(String r, int l) {
        /*
         * Write your code here.
         */

    	//l = length of strings that we are finding count for that match r
    	//1000000000 = max of l

    	String [] possibleStrings = calculatePossibleStrings(l);

//    	System.out.println("ps:");
//    	for (int i = 0; i < possibleStrings.length; ++i) {
//    		System.out.println(possibleStrings[i]);
//    	}

    	int matches = 0;
    	for (String ps : possibleStrings) {
    		matches += Pattern.matches(r, ps) ? 1 : 0;
    	}

    	System.out.println("matches " + matches);
    	return matches;
    }

    private static String [] calc(String [] strings) {
    	double length = strings.length * strings.length;
    	String [] newStrings = new String[length];

//    	System.out.println("nsl" + newStrings.length);

    	int newStringIter = 0;
    	for (int i = 0; i < strings.length; ++i) {
    		for (int j = 0; j < strings.length; ++j) {
    			newStrings[newStringIter] = strings[i] + strings[j];
    			++newStringIter;
    		}
    	}

    	return newStrings;
    }

    private static String [] calc(String [] strings1, String [] strings2) {
    	String [] newStrings = new String[strings1.length * strings2.length];

    	int newStringIter = 0;
    	for (int i = 0; i < strings1.length; ++i) {
    		for (int j = 0; j < strings2.length; ++j) {
    			newStrings[newStringIter] = strings1[i] + strings2[j];
    			newStringIter++;
     		}
    	}

    	return newStrings;
    }

    private static String[] calculatePossibleStrings(int l) {
    	if (l == 1) {
    		return new String [] { "a", "b" };
    	}

    	if (l == 2) {
    		return lengthTwoPossible;
    	}

    	int possiblyAdjustedLength = l;

    	if (l % 2 > 0) {
    		possiblyAdjustedLength--;
    	}

    	String [] strings = lengthTwoPossible;
    	while (strings[0].length() < possiblyAdjustedLength) {
    		System.out.println("lenght of strings is now " + strings.length);
    		strings = calc(strings);
    	}

    	if (l % 2 > 0) {
    		strings = calc(strings, alphabet);
    	}

    	return strings;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] rl = scanner.nextLine().split(" ");

            String r = rl[0];

            int l = Integer.parseInt(rl[1].trim());

            int result = countStrings(r, l);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
