import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountStrings {

	static String [] alphabet = {
			"a",
			"b"
	};

	static String [] lengthTwoPossible = {
			"aa",
			"bb",
			"ab",
			"ba"
	};

	static String [] lengthThreePossible = {
			"aaa",
			"abb",
			"aab",
			"aba",
			"bbb",
			"baa",
			"bba",
			"bab"
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

    	System.out.println("ps:");
    	for (int i = 0; i < possibleStrings.length; ++i) {
    		System.out.println(possibleStrings[i]);
    	}

//    	for (String ps : possibleStrings) {
//    		Pattern.matches(r, ps);
//    	}

    	return 0;
    }

    private static String[] calculatePossibleStrings(int l) {
    	if (l == 1) {
    		return new String [] { "a", "b" };
    	}

    	if (l == 2) {
    		return lengthTwoPossible;
    	}

    	if (l == 3) {
    		return lengthThreePossible;
    	}

    	int iterations = l / 2;
    	int baseComboIndex = 0;
    	int startingBaseComboIndex = 0;
    	String [] possibleStrings = new String[(int)Math.pow(2, l)];

    	for (int iterCount = 0; iterCount < iterations; ++iterCount) {
    		startingBaseComboIndex = 0;
        	for (int possibleStringIter = 0; possibleStringIter < possibleStrings.length; ++possibleStringIter) {
        		if (baseComboIndex > lengthTwoPossible.length - 1) {

            		if (iterCount > 0) {
            			startingBaseComboIndex = iterCount;
            		}
            		else {
            			baseComboIndex = startingBaseComboIndex;
            		}
        		}

        		possibleStrings[possibleStringIter] =
        				(possibleStrings[possibleStringIter] == null ? "" : possibleStrings[possibleStringIter]) + lengthTwoPossible[baseComboIndex];

        		++baseComboIndex;
        	}
    	}

//		for (int iterCount = 0; iterCount < iterations; ++iterCount) {
//			possibleStringIter = 0;
//			for (int i = 0; i < lengthTwoPossible.length; ++i) {
//				possibleStrings[possibleStringIter] =
//						(possibleStrings[possibleStringIter] == null ? "" : possibleStrings[possibleStringIter]) + lengthTwoPossible[i];
//
//				++possibleStringIter;
//			}
//		}

		return possibleStrings;

//		for (int iterCount = 0; iterCount < iterations; ++iterCount) {
//			possibleStringIter = 0;
//			for (int i = 0; i < lengthTwoPossible.length; ++i) {
//				possibleStrings[possibleStringIter] =
//						(possibleStrings[possibleStringIter] == null ? "" : possibleStrings[possibleStringIter]) + lengthTwoPossible[i];
//				++possibleStringIter;
//			}
//		}

		//odd length, add one more
//		if (l % 2 > 0) {
//			for (int i = 0; i < possibleStrings.length; ++i) {
//				for (int j = 0; j < alphabet.length; ++j) {
//					possibleStrings[i] = possibleStrings[i] + alphabet[j];
//				}
//			}
//		}
//
//		return possibleStrings;
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
