import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CountStrings {
	
	class NFA {
		
		NFA initialState
		
	}
	

	static String[] alphabet = { "a", "b" };

	static String[] lengthTwoPossible = { "aa", "ab", "bb", "ba" };

	private static long stringCount;
	private static String regex = null;

	/*
	 * Complete the countStrings function below.
	 */
	static int countStrings(String r, int l) {
		/*
		 * Write your code here.
		 */

		// l = length of strings that we are finding count for that match r
		// 1000000000 = max of l

		regex = r;
		stringCount = 0;
		calculateStringCount(l);

		System.out.println("count is " + stringCount);

		// System.out.println("ps:");
		// for (int i = 0; i < possibleStrings.length; ++i) {
		// System.out.println(possibleStrings[i]);
		// }

		// int matches = 0;
		// for (String ps : possibleStrings) {
		// matches += Pattern.matches(r, ps) ? 1 : 0;
		// }

		// System.out.println("matches " + stringCount);
		return (int) (stringCount % (long) (Math.pow(10, 9) + 7));
	}

	private static String[] calc(String[] strings1, String[] strings2) {
		String[] newStrings = new String[strings1.length * strings2.length];

		int newStringIter = 0;
		for (int i = 0; i < strings1.length; ++i) {
			for (int j = 0; j < strings2.length; ++j) {
				newStrings[newStringIter] = strings1[i] + strings2[j];
				newStringIter++;
			}
		}

		return newStrings;
	}

	// max n = 1000000000
	private static int raisesTo(int n) {
		long result = 2;
		int iter = 0;
		while (true) {
			result *= result;
			if (result > n) {
				break;
			} else {
				iter++;
			}
		}

		return iter;
	}

	private static void calc(String[] strings, int length) {
		for (int stringCtr = 0; stringCtr < strings.length; ++stringCtr) {
			StringBuffer sb = new StringBuffer(strings[stringCtr]);
			for (int i = 0; i < 30; ++i) {
				while (sb.length() < length) {
					for (int k = 0; k < strings.length; ++k) {
						sb.append(strings[k]);
					}
				}

				System.out.println("final str to check is " + sb.toString());

				if (Pattern.matches(regex, sb.toString())) {
					++stringCount;
				}
				else {
					
				}
			}
		}
	}

	private static int checkCount = 0;
	
	
	private static void createSm(String regex) {
		int [][] states = new int[Integer.MAX_VALUE][2];
		
		for (int i = 0; i < regex.length(); ++i) {
			
			
		}
		
		
	}
	
	
	private static void calc1(String currentString, String[] strings, int length) {

		//System.out.println(currentString.length());
		
		if (currentString.length() == length) {
			if (Pattern.matches(regex, currentString)) {
				stringCount++;
			}
			
			return;
		}
		
		for (int i = 0; i < strings.length; ++i) {
			calc1(currentString + strings[i], strings, length);
		}
	}	
	
	// if (Pattern.matches(regex, strings[i] + strings[j])) {
	// stringCount++;
	// }

	private static void calculateStringCount(int l) {
		// System.out.println("l " + l);
		if (l == 1) {
			for (int i = 0; i < alphabet.length; ++i) {
				if (Pattern.matches(regex, alphabet[i])) {
					stringCount++;
				}
			}

			return;
		}

		if (l == 2) {
			for (int i = 0; i < lengthTwoPossible.length; ++i) {
				if (Pattern.matches(regex, lengthTwoPossible[i])) {
					stringCount++;
				}
			}
			return;
		}

//		int possiblyAdjustedLength = l;
//
//		if (l % 2 > 0) {
//			possiblyAdjustedLength--;
//		}

		//calc(lengthTwoPossible, possiblyAdjustedLength);
		calc1("", alphabet, l);

		// if (l % 2 > 0) {
		// strings = calc(strings, alphabet);
		// }
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
