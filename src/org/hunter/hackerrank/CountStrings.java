import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class CountStrings {

	static String[] alphabet = { "a", "b" };

	static String[] lengthTwoPossible = { "aa", "ab", "bb", "ba" };

	private static long stringCount;
	private static String regex = null;

	public static void main(String [] args) {
		//ParseNode tree = regexToExpressionTree("(a|b)*abb");
		ParseNode tree = regexToExpressionTree("((a((((((ba)*)(b((b|((b(b(b*)))*))*)))*)*)|((bb)|(((b((ba)*))|((a|(a|b))*))*))))|(b|(b*)))");
		//ParseNode tree = regexToExpressionTree("((a|b)|(a|b)*)");

		printTree(tree, 0);
	}

	private static void printTree(ParseNode tree, int indent) {
		if (tree == null) {
			return;
		}

		StringBuffer spaces = new StringBuffer();
		for (int i = 0; i < indent; ++i) {
			spaces.append(" ");
		}

		if (tree.type.equals(ParseNode.Type.CHAR)) {
			System.out.println(spaces.toString() + tree.data);
		}
		else if (tree.type.equals(ParseNode.Type.ALT)) {
			System.out.println(spaces.toString() + "|");
			printTree(tree.left, indent + 1);
			printTree(tree.right, indent + 1);
		}
		else if (tree.type.equals(ParseNode.Type.CONCAT)) {
			System.out.println(spaces.toString() + ".");
			printTree(tree.left, indent + 1);
			printTree(tree.right, indent + 1);
		}
		else if (tree.type.equals(ParseNode.Type.STAR)) {
			System.out.println(spaces.toString() + "*");
			printTree(tree.left, indent + 1);
			printTree(tree.right, indent + 1);
		}
	}

	static class NFA {
		static String noneStateType = "NONE";
		static String epsStateType = "EPS";
		int size;
		int initial;
		int last;

		String [][] transTable = null;

		void addTransition(int from, int to, String input) {
			if (transTable == null) {
				transTable = new String[size][size];
			}

			transTable[from][to] = input;
		}

	}

	private static NFA buildNFAAlter(NFA nfa1, NFA nfa2) {

	}

	private static NFA appendEmptyState(NFA nfa) {
		NFA appendedNFA = new NFA();
		String [][] appendedTransitionTable = new String[nfa.transTable.length + 1][nfa.transTable.length + 1];

		for (int i = 0; i < nfa.transTable.length; ++i) {
			for (int j = 0; j < nfa.transTable.length; ++j) {
				appendedTransitionTable[i][j] = nfa.transTable[i][j];
			}
		}

		for (int i = 0; i < nfa.transTable.length + 1; ++i) {
			appendedTransitionTable[nfa.transTable.length][i] = NFA.noneStateType;
		}

		for (int i = 0; i < nfa.transTable.length + 1; ++i) {
			appendedTransitionTable[i][nfa.transTable.length] = NFA.noneStateType;
		}

		appendedNFA.transTable = appendedTransitionTable;
		appendedNFA.initial = nfa.initial;
		appendedNFA.size = nfa.size + 1;

		return appendedNFA;
	}

	static class ParseNode {
		enum Type { CHAR, STAR, ALT, CONCAT };
		Type type = null;
		ParseNode left = null;
		ParseNode right = null;
		ParseNode parent = null;
		String data = null;
	}

	static Stack<ParseNode> expressionStack = new Stack<ParseNode>();

	private static ParseNode regexToExpressionTree(String regex) {
		ParseNode lastNode = null;

		//((a|b)|(a|b)*)
		//((a|b)|(a|b))
		//(a|b)*abb

		for (int i = 0; i < regex.length(); ++i) {
			char c = regex.charAt(i);

			if (c == '(') {
				ParseNode node = new ParseNode();
				expressionStack.push(node);
			}
			else if (c == ')') {
				if (i + 1 < regex.length() &&
						regex.charAt(i + 1) == ')' || i == regex.length() - 1) {

					//null, null, alt, null
					//search for unbalanced alt at same level and balance it
					ParseNode lastUnbalancedAlt = null;
					for (ParseNode node : expressionStack) {
						if (node.type != null && node.type.equals(ParseNode.Type.ALT) && node.right == null) {
							lastUnbalancedAlt = node;
						}
					}

					if (lastUnbalancedAlt != null) {
						ParseNode last = expressionStack.pop();
						lastUnbalancedAlt.right = last;
						expressionStack.push(lastUnbalancedAlt);
					}
				}
			}
			else if (c == '|') {
				ParseNode node = new ParseNode();
				node.type = ParseNode.Type.ALT;
				node.left = expressionStack.pop();
				expressionStack.push(node);
			}
			else if (c == '*') {
				ParseNode node = new ParseNode();
				node.type = ParseNode.Type.STAR;
				node.left = expressionStack.pop();
				expressionStack.push(node);
			}
			else {
				//char data - leaf node
				ParseNode node = new ParseNode();
				node.type = ParseNode.Type.CHAR;
				node.data = Character.toString(c);

				if (expressionStack.peek().type == null) {
					expressionStack.push(node);
				}
				else if (expressionStack.peek().type.equals(ParseNode.Type.ALT)) {
					ParseNode last = expressionStack.pop();
					last.right = node;
					expressionStack.push(last);
				}
				else {
					ParseNode node2 = new ParseNode();
					node2.type = ParseNode.Type.CONCAT;
					node2.right = node;
					node2.left = expressionStack.pop();
					expressionStack.push(node2);
				}
			}
		}

		return expressionStack.pop();
	}

	private static int levelsFromRegex(String regex) {
		int levels = 0;

		for (int i = 0; i < regex.length(); ++i) {
			char c = regex.charAt(i);

			if (c == '(') {
				++levels;
			}

			if (c == ')') {
				break;
			}

		}

		return levels;
	}



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

//	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int t = Integer.parseInt(scanner.nextLine().trim());
//
//		for (int tItr = 0; tItr < t; tItr++) {
//			String[] rl = scanner.nextLine().split(" ");
//
//			String r = rl[0];
//
//			int l = Integer.parseInt(rl[1].trim());
//
//			int result = countStrings(r, l);
//
//			bufferedWriter.write(String.valueOf(result));
//			bufferedWriter.newLine();
//		}
//
//		bufferedWriter.close();
//	}
}
