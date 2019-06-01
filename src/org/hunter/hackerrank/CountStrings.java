package org.hunter.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

public class CountStrings {

	static String[] alphabet = { "a", "b" };

	static String[] lengthTwoPossible = { "aa", "ab", "bb", "ba" };

	private static long stringCount;
	private static String regex = null;

	public static void main(String [] args) {
		//ParseNode tree = regexToExpressionTree("(ab)");
		//ParseNode tree = regexToExpressionTree("(a|b)");
		//ParseNode tree = regexToExpressionTree("(a|b)*abb");
		ParseNode tree = regexToExpressionTree("((a((((((ba)*)(b((b|((b(b(b*)))*))*)))*)*)|((bb)|(((b((ba)*))|((a|(a|b))*))*))))|(b|(b*)))");
		//ParseNode tree = regexToExpressionTree("((a|b)|(a|b)*)");

		printTree(tree, 0);

		NFA nfa = expressionTreeToNFA(tree);

		System.out.println("nfa initial = " + nfa.initial);
		System.out.println("nfa last = " + nfa.last);
		System.out.println("nfa size = " + nfa.size);

		System.out.println("eps closure of 0: ");
		int [] closureStates = epsClosure(nfa,  new Integer[]{ 0 } );

		for (int i = 0; i < closureStates.length; ++i) {
			System.out.println(closureStates[i]);
		}

	}

	private static int [] epsClosure(NFA nfa, Integer [] startingStates) {
		Set<Integer> stateSet = new HashSet<Integer>();

		for (int state: startingStates) {
			Set<Integer> movedToStates = new HashSet<Integer>();
			nfa.getMoveToStates(nfa, state, NFA.epsStateType, movedToStates);
			stateSet.addAll(movedToStates);
		}

		int [] result = new int[stateSet.size()];

		int i = 0;
		for (int state : stateSet) {
			result[i++] = state;
		}

		return result;
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

				for (int i = 0; i < transTable.length; ++i) {
					for (int j = 0; j < transTable.length; ++j) {
						transTable[i][j] = NFA.noneStateType;
					}
				}
			}

			transTable[from][to] = input;
		}

		public void getMoveToStates(NFA nfa, int state, String input, Set<Integer> results) {
			Set<Integer> set = new HashSet<Integer>();

			results.add(state);

			for (int i = 0; i < transTable[state].length; ++i) {
				if (input.equals(transTable[state][i])) {
					set.add(i);
				}
			}

			if (set.size() > 0) {
				for (int movedToState: set) {
					getMoveToStates(nfa, movedToState, input, results);
				}
			}
		}

	}

	private static NFA buildNFABasic(String input) {
		NFA basic = new NFA();
		basic.size = 2;
		basic.initial = 0;
		basic.last = 1;
		basic.addTransition(0, 1, input);
		return basic;
	}

	private static NFA buildNFAAlter(NFA nfa1, NFA nfa2) {
		nfa1 = shiftStates(nfa1, 1);
		nfa2 = shiftStates(nfa2, nfa1.size);
		nfa2 = fillStates(nfa1, nfa2);
		nfa2 = appendEmptyState(nfa2);

		nfa2.addTransition(0, nfa1.initial, NFA.epsStateType);
		nfa2.addTransition(0, nfa2.initial, NFA.epsStateType);
		nfa2.addTransition(nfa1.last, nfa2.last, NFA.epsStateType);
		nfa2.addTransition(nfa2.last - 1, nfa2.last, NFA.epsStateType);
		nfa2.initial = 0;

		return nfa2;
	}

	private static NFA buildNFAConcat(NFA nfa1, NFA nfa2) {
		nfa2 = shiftStates(nfa2, nfa1.size - 1);
		nfa2 = fillStates(nfa1, nfa2);
		nfa2.initial = nfa1.initial;
		return nfa2;
	}

	private static NFA buildNFAStar(NFA nfa) {
		nfa = shiftStates(nfa, 1);
		nfa = appendEmptyState(nfa);

		nfa.addTransition(0, nfa.initial, NFA.epsStateType);
		nfa.addTransition(0, nfa.last, NFA.epsStateType);
		nfa.addTransition(nfa.last - 1, nfa.last, NFA.epsStateType);
		nfa.addTransition(nfa.last - 1, nfa.initial, NFA.epsStateType);
		nfa.initial = 0;

		return nfa;
	}

	private static NFA appendEmptyState(NFA nfa) {
		NFA appendedNFA = new NFA();
		String [][] appendedTransitionTable = new String[nfa.transTable.length + 1][nfa.transTable.length + 1];

		for (int i = 0; i < appendedTransitionTable.length; ++i) {
			for (int j = 0; j < appendedTransitionTable.length; ++j) {
				appendedTransitionTable[i][j] = NFA.noneStateType;
			}
		}

		for (int i = 0; i < nfa.transTable.length; ++i) {
			for (int j = 0; j < nfa.transTable.length; ++j) {
				appendedTransitionTable[i][j] = nfa.transTable[i][j];
			}
		}

		appendedNFA.transTable = appendedTransitionTable;
		appendedNFA.initial = nfa.initial;
		appendedNFA.size = nfa.size + 1;
		appendedNFA.last = nfa.last + 1;

		return appendedNFA;
	}

	private static NFA shiftStates(NFA nfa, int shift) {
		NFA shiftedNFA = new NFA();
		String [][] shiftedTransitionTable = new String[nfa.transTable.length + shift][nfa.transTable.length + shift];

		for (int i = 0; i < shiftedTransitionTable.length; ++i) {
			for (int j = 0; j < shiftedTransitionTable.length; ++j) {
				shiftedTransitionTable[i][j] = NFA.noneStateType;
			}
		}

		for (int i = 0; i < nfa.transTable.length; ++i) {
			for (int j = 0; j < nfa.transTable.length; ++j) {
				shiftedTransitionTable[i + shift][j + shift] = nfa.transTable[i][j];
			}
		}

		shiftedNFA.transTable = shiftedTransitionTable;
		shiftedNFA.initial = nfa.initial + shift;
		shiftedNFA.size = nfa.size + shift;
		shiftedNFA.last = nfa.last + shift;

		return shiftedNFA;
	}

	private static NFA fillStates(NFA nfaSource, NFA nfaTarget) {
		NFA newNFA = new NFA();
		newNFA.initial = nfaTarget.initial;
		newNFA.last = nfaTarget.last;
		newNFA.size = nfaTarget.size;
		newNFA.transTable = new String[newNFA.size][newNFA.size];

		for (int i = 0; i < nfaTarget.size; ++i) {
			for (int j = 0; j < nfaTarget.size; ++j) {
				newNFA.transTable[i][j] = nfaTarget.transTable[i][j];
			}
		}

		for (int i = 0; i < nfaSource.transTable.length; ++i) {
			for (int j = 0; j < nfaSource.transTable.length; ++j) {
				newNFA.transTable[i][j] = nfaSource.transTable[i][j];
			}
		}

		return newNFA;
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

	private static NFA expressionTreeToNFA(ParseNode tree) {
		if (tree.type.equals(ParseNode.Type.CHAR)) {
			return buildNFABasic(tree.data);
		}
		else if (tree.type.equals(ParseNode.Type.STAR)) {
			return buildNFAStar(expressionTreeToNFA(tree.left));
		}
		else if (tree.type.equals(ParseNode.Type.ALT)) {
			return buildNFAAlter(expressionTreeToNFA(tree.left), expressionTreeToNFA(tree.right));
		}
		else if (tree.type.equals(ParseNode.Type.CONCAT)) {
			return buildNFAConcat(expressionTreeToNFA(tree.left), expressionTreeToNFA(tree.right));
		}
		else {
			throw new RuntimeException("type of parse node not recognized: " + tree.type);
		}
	}

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