package org.hunter.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

public class CountStrings {

    private static BigInteger[][] createIdentityMatrix(int width, int height) {
        BigInteger[][] matrix = new BigInteger[width][height];

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (i == j) {
                    matrix[i][j] = new BigInteger("1");
                }
                else {
                    matrix[i][j] = new BigInteger("0");
                }
            }
        }

        return matrix;
    }

    private static long[][] createIdentityMatrixLong(int width, int height) {
        long[][] matrix = new long[width][height];

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
                else {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    private static int[][] createIdentityMatrixInt(int width, int height) {
        int[][] matrix = new int[width][height];

        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
                else {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    private static int modBy = 1000000007;

    private static long[][] matrixPowerLong(long[][] matrix, long power) {
        long[][] result = createIdentityMatrixLong(matrix.length, matrix.length);

//		System.out.println("mlength: " + matrix.length);

//		int it = 0;
        while (power > 0) {
            if (power % 2 == 0) {
                power /= 2;
                matrix = multiplyMatricesLong(matrix, matrix);
            }
            else {
                power--;
                result = multiplyMatricesLong(matrix, result);
                power /= 2;
                matrix = multiplyMatricesLong(matrix, matrix);
            }

//			System.out.println("p: " + power);
//			++it;
        }

//		System.out.println("iters: " + it);

        return result;
    }

    private static int[][] matrixPowerInt(int[][] matrix, int power) {
        int[][] result = createIdentityMatrixInt(matrix.length, matrix.length);

//		System.out.println("mlength: " + matrix.length);

//		int it = 0;
        while (power > 0) {
            if (power % 2 == 0) {
                power /= 2;
                matrix = multiplyMatricesInt(matrix, matrix);
            }
            else {
                power--;
                result = multiplyMatricesInt(matrix, result);
                power /= 2;
                matrix = multiplyMatricesInt(matrix, matrix);
            }

//			System.out.println("p: " + power);
//			++it;
        }

//		System.out.println("iters: " + it);

        return result;
    }

    private static BigInteger[][] matrixPower3(BigInteger[][] matrix, long power) {
        BigInteger[][] result = createIdentityMatrix(matrix.length, matrix.length);

        while (power > 0) {
            if (power % 2 == 0) {
                power /= 2;
                matrix = multiplyMatrices(matrix, matrix);
            }
            else {
                power--;
                result = multiplyMatrices(matrix, result);
                power /= 2;
                matrix = multiplyMatrices(matrix, matrix);
            }

//			System.out.println("p: " + power);
        }

        return result;
    }

    private static long pow(long base, long power) {
        long result = 1;

        while (power > 0) {
            if (power % 2 == 0) {
                power /= 2;
                base *= base;
            }
            else {
                power--;
                result *= base;
                power /= 2;
                base *= base;
            }

            System.out.println("p: " + power);
        }

        return result;
    }

    private static Set<Long> findPowersOfTwo(long value) {
        Set<Long> values = new HashSet<Long>();
        double diff = value;
        double log = Math.floor(Math.log(value) / Math.log(2));
        while (true) {
            // System.out.println(log);
            if (log == 0) {
                values.add((long) log);
                break;
            }
            values.add((long) log);
            diff = diff - Math.pow(2, log);
            if (diff == 0) {
                values.add((long) log);
                break;
            }
            log = Math.floor(Math.log(diff) / Math.log(2));
            // System.out.println(log);

        }

        return values;
    }

    static String[] alphabet = { "a", "b" };

    static String[] lengthTwoPossible = { "aa", "ab", "bb", "ba" };

    private static long stringCount;
    private static String regex = null;

//	public static void main(String [] args) {
    private static int countStrings(String regex, int length) {

//		((ab)|(ba)) 2
//		((a|b)*) 5
//		((a*)(b(a*))) 100
        // (a(((b|(a(ba)))*)b)) 18
        // (b(((((a|(b|a))*)|(((((a|(a*))|a)|(b|((a|a)*)))|(a*))|(a|a)))*)*)) 502014773

//		3
//		((ab)|(ba)) 2
//		((a|b)*) 5
//		((a*)(b(a*))) 100

        // String regex = "a";
        // String regex = "((a|b)*)";
        // String regex = "(a(((b|(a(ba)))*)b))";
        // String regex =
        // "((bb)|((((((aa)|(b|b))|(a|b))|(((a|a)|b)|((((ab)a)*)((b|b)*))))|(((ab)(((aa)a)|b))b))*))";
        // String regex = "((a|b)*)";
        // String regex = "(a(((b|(a(ba)))*)b))";
        // String regex =
        // "(b(((((a|(b|a))*)|(((((a|(a*))|a)|(b|((a|a)*)))|(a*))|(a|a)))*)*))";
        // String regex = "((a*)(b(a*)))";
        // String regex =
        // "(b(((((a|(b|a))*)|(((((a|(a*))|a)|(b|((a|a)*)))|(a*))|(a|a)))*)*))";
        // regex =
        // "((bb)|((((((aa)|(b|b))|(a|b))|(((a|a)|b)|((((ab)a)*)((b|b)*))))|(((ab)(((aa)a)|b))b))*))";
//		long length = 502014773;
        // length = 653338565;
        // long length = 100;

        // 919464569
        // 919464569

        // 487453258
        // 487453258

        // System.out.println(findPowersOfTwo(502014773));

        // ParseNode tree = regexToExpressionTree("((a*)(b(a*)))");
        // ParseNode tree = regexToExpressionTree("((a|b)*)");
        // ParseNode tree = regexToExpressionTree("(a|b)*abb");
        // ParseNode tree =
        // regexToExpressionTree("((bb)|((((((aa)|(b|b))|(a|b))|(((a|a)|b)|((((ab)a)*)((b|b)*))))|(((ab)(((aa)a)|b))b))*))");
        // ParseNode tree = regexToExpressionTree("(a(((b|(a(ba)))*)b))", 0);

        currentPos = 0;
        dfaStateCounter = 0;

        if (!regex.contains("(")) {
            regex = "(" + regex + ")";
        }

//		regex = "((((b*)((b(a|a))a))(((a*)|a)a))((aa)((((((b*)*)(b|((b|(aa))|b)))(a|b))|(b*))*)))";
//		length = 937477085;
        // expected output = 971722885
        // my output = 871840851

        // System.out.println(regex);

//		BigInteger [][] m = new BigInteger[2][2];
//		m[0][0] = new BigInteger("1");
//		m[0][1] = new BigInteger("2");
//		m[1][0] = new BigInteger("3");
//		m[1][1] = new BigInteger("4");

        // System.out.println(pow(2, 502014773));

//		printMatrix(m);
//		System.out.println("");
//		printMatrix(matrixPower3(m, 502014773));

        ParseNode tree = regexToExpressionTree(regex);

//		printTree(tree, 0);

        NFA nfa = expressionTreeToNFA(tree);

//		System.out.println("nfa initial = " + nfa.initial);
//		System.out.println("nfa last = " + nfa.last);
//		System.out.println("nfa size = " + nfa.size);

        DFA dfa = subsetConstruct(nfa);

//		System.out.println(dfa.simulate("baaaaabbbbbbbbbbba"));

//		System.out.println("dfa initial " + dfa.initial);
//		System.out.println("dfa transtable size " + dfa.transTable.size());
//		System.out.println("dfa final states size " + dfa.finalStates.size());

        // BigInteger [][] matrix = dfa.probabilityMatrixBigInteger();
        long[][] matrix = dfa.probabilityMatrix();
        long[][] productMatrix = matrixPowerLong(matrix, length);
//		printMatrixLong(productMatrix);
//		BigInteger [][] productMatrix = matrixPower3(matrix, length);

//
//		BigInteger sumAcceptingStates = sumAcceptingStates2(productMatrix, dfa).mod(
//				new BigInteger(new Long((long)Math.pow(10, 9) + 7).toString()));
        long sumAcceptingStates = sumAcceptingStatesLong(productMatrix, dfa);
//
//		System.out.println(sumAcceptingStates);
        // return Integer.parseInt(sumAcceptingStates.toString());
//		System.exit(0);
        return (int) sumAcceptingStates;
    }

    private static void printMatrixLong(long[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }

            System.out.println("");
        }
    }

    private static void printMatrix(BigInteger[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }

            System.out.println("");
        }
    }

    private static void findNonFractionalLog(long l) {
        long x = 200;
        if (x % 1 == 0) {
            System.out.println("good");
        }

        long copyL = l;
        while (copyL > (l - 100)) {
            for (int base = 2; base < 100; ++base) {
                double log = Math.log(l) / Math.log(base);

                if (log % 1 == 0) {
                    System.out.println("here!");
                    System.out.println(log);
                }

                copyL--;
            }
        }

//		double diff = l;
//		double log = Math.log(diff) / Math.log(2);
//		while (log % 1 > 0) {
//
//			double roundedDownLog = Math.floor(log);
//			diff = diff - (long)Math.pow(2, roundedDownLog);
//
//			log = Math.log(diff) / Math.log(2);
//			System.out.println(log);
//		}
    }

    private static long[][] multiplyEntriesInMatrix(long[][] matrix, long value) {
        long[][] product = new long[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                product[i][j] = matrix[i][j];
                product[i][j] *= value;
            }
        }

        return product;
    }

    private static int sumAcceptingStatesInt(int[][] productMatrix, DFA dfa) {
        int sum = 0;

        for (int finalState : dfa.finalStates) {
            sum += productMatrix[dfa.initial][finalState] % modBy;
        }

        return sum;
    }

    private static long sumAcceptingStatesLong(long[][] productMatrix, DFA dfa) {
        long sum = 0;

        for (int finalState : dfa.finalStates) {
            sum += productMatrix[dfa.initial][finalState];
        }

        return sum % modBy;
    }

    private static BigInteger sumAcceptingStates2(BigInteger[][] productMatrix, DFA dfa) {
        BigInteger sum = new BigInteger("0");

        for (int finalState : dfa.finalStates) {
            sum = sum.add(productMatrix[dfa.initial][finalState]);
        }

        return sum;
    }

    private static BigInteger sumAcceptingStates(BigInteger[][] productMatrix, DFA dfa) {
        BigInteger sum = new BigInteger("0");

        for (Transition tran : dfa.transTable.keySet()) {
            int fromState = tran.state;
            int toState = dfa.transTable.get(tran);

            if (isStateInSet(dfa.finalStates, toState)) {
                System.out.println("final state from: " + fromState);
                System.out.println("final state to: " + toState);
                sum = sum.add(productMatrix[fromState][toState]);
            }
        }

        return sum;
    }

    private static long sumAcceptingStates(long[][] productMatrix, DFA dfa) {
        long sum = 0;

        for (Transition tran : dfa.transTable.keySet()) {
            int fromState = tran.state;
            int toState = dfa.transTable.get(tran);

            if (isStateInSet(dfa.finalStates, toState)) {
                sum += productMatrix[fromState][toState];
            }
        }

        return sum;
    }

    private static Set<Integer> epsClosure(NFA nfa, Set<Integer> startingStates) {
        Set<Integer> stateSet = new HashSet<Integer>();

        for (int state : startingStates) {
            Set<Integer> movedToStates = nfa.getMoveToStates(nfa, state, NFA.epsStateType);

            stateSet.addAll(movedToStates);
        }

        return stateSet;
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

    static class Transition {
        int state;
        String input = "";

        @Override
        public boolean equals(Object obj) {
            Transition t = (Transition) obj;

            return this.state == t.state && this.input.equals(t.input);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + input.hashCode();
            result = 31 * result + state;
            return result;
        }

    }

    static int dfaStateCounter = 0;

    static int getNewDfaState() {
        return dfaStateCounter++;
    }

    private static boolean isStateInSet(Set<Integer> states, Integer stateToSearchFor) {
        for (int state : states) {
            if (state == stateToSearchFor) {
                return true;
            }
        }

        return false;
    }

    private static boolean areStatesInSet(Set<Set<Integer>> stateSet, Set<Integer> statesToSearchFor) {
        for (Set<Integer> states : stateSet) {

            if (states.equals(statesToSearchFor)) {
                return true;
            }
        }

        return false;
    }

    private static DFA subsetConstruct(NFA nfa) {
        DFA dfa = new DFA();
        Map<Set<Integer>, Integer> nfaStatesToDfaState = new HashMap<Set<Integer>, Integer>();
        Set<Set<Integer>> markedStates = new HashSet<Set<Integer>>();
        Set<Set<Integer>> unMarkedStates = new HashSet<Set<Integer>>();

        Set<Integer> initialNfaState = new HashSet<Integer>();
        initialNfaState.add(nfa.initial);
        Set<Integer> first = epsClosure(nfa, initialNfaState);
        unMarkedStates.add(first);

        dfa.initial = getNewDfaState();
        nfaStatesToDfaState.put(first, dfa.initial);

        while (!unMarkedStates.isEmpty()) {
            Set<Integer> currentNfaStates = unMarkedStates.iterator().next();
            markedStates.add(currentNfaStates);
            unMarkedStates.remove(currentNfaStates);

            for (int state : currentNfaStates) {
                if (state == nfa.last) {
                    dfa.finalStates.add(nfaStatesToDfaState.get(currentNfaStates));
                }
            }

            for (String input : nfa.alphabet) {
                Set<Integer> movedToStates = epsClosure(nfa, nfa.move(currentNfaStates, input));

                if (!areStatesInSet(unMarkedStates, movedToStates) && !areStatesInSet(markedStates, movedToStates)) {
                    unMarkedStates.add(movedToStates);
                    nfaStatesToDfaState.put(movedToStates, getNewDfaState());
                }

                Transition trans = new Transition();
                trans.input = input;
                trans.state = nfaStatesToDfaState.get(currentNfaStates);

                dfa.transTable.put(trans, nfaStatesToDfaState.get(movedToStates));
            }
        }

        return dfa;
    }

    private static BigInteger[][] matrixPower2(BigInteger[][] matrix, long power) {
        Set<Long> powersOfTwo = findPowersOfTwo(power);
        List<BigInteger[][]> matrices = new ArrayList<BigInteger[][]>();

        matrix = multiplyMatrices(matrix, matrix);

        for (long powerOfTwo : powersOfTwo) {
            System.out.println("po2: " + powerOfTwo);
            matrices.add(matrixPower(matrix, powerOfTwo));
        }

        System.out.println("countm: " + matrices.size());

        BigInteger[][] product = matrices.get(0);
        for (BigInteger[][] m : matrices.subList(1, matrices.size())) {
            product = multiplyMatrices(product, m);
        }

        return product;
    }

    private static BigInteger[][] matrixPower(BigInteger[][] matrix, long power) {
        BigInteger[][] product = new BigInteger[matrix.length][matrix.length];
        if (power == 0) {
            for (int i = 0; i < product.length; ++i) {
                for (int k = 0; k < product.length; ++k) {
                    if (i == k) {
                        product[i][k] = new BigInteger("1");
                    }
                    else {
                        product[i][k] = new BigInteger("0");
                    }
                }
            }
            return matrix;
        }
        else if (power == 1) {
            return matrix;
        }

        for (int i = 0; i < product.length; ++i) {
            for (int k = 0; k < product.length; ++k) {
                product[i][k] = matrix[i][k];
            }
        }

        for (long i = 0; i < power - 1; ++i) {
            product = multiplyMatrices(matrix, product);
        }

        return product;
    }

    private static BigInteger[][] multiplyMatrices(BigInteger[][] matrix1, BigInteger[][] matrix2) {
        BigInteger[][] product = new BigInteger[matrix1.length][matrix2.length];

        for (int i = 0; i < product.length; ++i) {
            for (int j = 0; j < product.length; ++j) {
                BigInteger sum = new BigInteger("0");
                for (int ctr = 0; ctr < matrix1.length; ++ctr) {
                    sum = matrix1[i][ctr].multiply(matrix2[ctr][j]).add(sum);
                    sum = sum.mod(new BigInteger(String.valueOf(modBy)));
                }

                product[i][j] = sum;
            }
        }

        return product;
    }

    private static long[][] multiplyMatricesLong(long[][] matrix1, long[][] matrix2) {
        long[][] product = new long[matrix1.length][matrix2.length];

        for (int i = 0; i < product.length; ++i) {
            for (int j = 0; j < product.length; ++j) {
                long sum = 0;
                for (int ctr = 0; ctr < matrix1.length; ++ctr) {
                    long p = (matrix1[i][ctr] * matrix2[ctr][j]) % modBy;
                    sum = (sum + p) % modBy;
                }

                product[i][j] = sum;
            }
        }

        return product;
    }

    private static int[][] multiplyMatricesInt(int[][] matrix1, int[][] matrix2) {
        int[][] product = new int[matrix1.length][matrix2.length];

        for (int i = 0; i < product.length; ++i) {
            for (int j = 0; j < product.length; ++j) {
                int sum = 0;
                for (int ctr = 0; ctr < matrix1.length; ++ctr) {
                    long p = (long) (matrix1[i][ctr] * matrix2[ctr][j]) % modBy;
                    sum = (sum + (int) p) % modBy;
                }

                product[i][j] = sum;
            }
        }

        return product;
    }

    static class DFA {
        int initial = 0;
        Set<Integer> finalStates = new HashSet<Integer>();
        Map<Transition, Integer> transTable = new HashMap<Transition, Integer>();

        BigInteger[][] probabilityMatrixBigInteger() {
            BigInteger[][] matrix = new BigInteger[transTable.size()][transTable.size()];
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    matrix[i][j] = new BigInteger("0");
                }
            }

            for (Transition tran : transTable.keySet()) {
                int stateFrom = tran.state;
                int stateTo = transTable.get(tran);

                matrix[stateFrom][stateTo] = matrix[stateFrom][stateTo].add(new BigInteger("1"));
            }

            return matrix;
        }

        int[][] probabilityMatrixInt() {
            int[][] matrix = new int[transTable.size()][transTable.size()];

            for (Transition tran : transTable.keySet()) {
                int stateFrom = tran.state;
                int stateTo = transTable.get(tran);

                matrix[stateFrom][stateTo] += 1;
            }

            return matrix;
        }

        long[][] probabilityMatrix() {
            long[][] matrix = new long[transTable.size()][transTable.size()];

            for (Transition tran : transTable.keySet()) {
                int stateFrom = tran.state;
                int stateTo = transTable.get(tran);

                matrix[stateFrom][stateTo] += 1;
            }

            return matrix;
        }

        String simulate(String input) {
            int currentState = initial;

            for (int i = 0; i < input.length(); ++i) {
                String c = Character.toString(input.charAt(i));

                Transition trans = new Transition();
                trans.input = c;
                trans.state = currentState;

                if (transTable.get(trans) == null) {
                    return "REJECT";
                }

                currentState = transTable.get(trans);
            }

            for (int state : finalStates) {
                if (state == currentState) {
                    return "ACCEPT";
                }
            }

            return "REJECT";
        }

    }

    static class NFA {
        String[] alphabet = new String[] { "a", "b" };
        static String noneStateType = "NONE";
        static String epsStateType = "EPS";
        int size;
        int initial;
        int last;

        String[][] transTable = null;

        Set<Integer> move(Set<Integer> states, String input) {
            Set<Integer> result = new HashSet<Integer>();

            for (int state : states) {
                for (int i = 0; i < transTable[state].length; ++i) {
                    if (input.equals(transTable[state][i])) {
                        result.add(i);
                    }
                }
            }

            return result;
        }

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

        public Set<Integer> getMoveToStates(NFA nfa, int state, String input) {
            Set<Integer> results = new HashSet<Integer>();
            Set<Integer> currentStates = new HashSet<Integer>();

            results.add(state);
            currentStates.add(state);

            while (true) {
                Set<Integer> set = new HashSet<Integer>();
                for (int currentState : currentStates) {
                    for (int i = 0; i < transTable[currentState].length; ++i) {
                        if (input.equals(transTable[currentState][i])) {
                            if (!isStateInSet(results, i)) {
                                set.add(i);
                            }
                        }
                    }
                }

                if (set.size() == 0) {
                    // no more states to process
                    break;
                }
                else {
                    currentStates.clear();
                    currentStates.addAll(set);
                    results.addAll(set);
                }
            }

            return results;
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
        nfa2.addTransition(0, nfa1.initial, NFA.epsStateType);
        nfa2.addTransition(0, nfa2.initial, NFA.epsStateType);
        nfa2.initial = 0;
        nfa2 = appendEmptyState(nfa2);
        nfa2.last = nfa2.size - 1;
        nfa2.addTransition(nfa1.last, nfa2.last, NFA.epsStateType);
        nfa2.addTransition(nfa2.last - 1, nfa2.last, NFA.epsStateType);
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
        nfa.addTransition(0, nfa.size - 1, NFA.epsStateType);
        nfa.addTransition(nfa.last, nfa.initial, NFA.epsStateType);
        nfa.addTransition(nfa.last, nfa.size - 1, NFA.epsStateType);
        nfa.initial = 0;
        nfa.last = nfa.size - 1;

        return nfa;
    }

    private static NFA appendEmptyState(NFA nfa) {
        NFA appendedNFA = new NFA();
        String[][] appendedTransitionTable = new String[nfa.transTable.length + 1][nfa.transTable.length + 1];

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
        appendedNFA.last = nfa.last;

        return appendedNFA;
    }

    private static NFA shiftStates(NFA nfa, int shift) {
        NFA shiftedNFA = new NFA();
        String[][] shiftedTransitionTable = new String[nfa.transTable.length + shift][nfa.transTable.length + shift];

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
        enum Type {
            CHAR, STAR, ALT, CONCAT
        };

        Type type = null;
        ParseNode left = null;
        ParseNode right = null;
        ParseNode parent = null;
        String data = null;
    }

//	static Stack<ParseNode> expressionStack = new Stack<ParseNode>();

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

//	private static void printExpressionStack() {
//		for (ParseNode node: expressionStack) {
//			System.out.print(node.type);
//			System.out.print(" ");
//		}
//
//		System.out.println("endprint");
//	}

//	private static ParseNode regexToExpressionTree2(String regex) {
//
//		if (!regex.startsWith("(")) {
//			ParseNode node = new ParseNode();
//			node.type = ParseNode.Type.CHAR;
//			node.data = regex;
//
//			ParseNode concatNode = new ParseNode();
//			concatNode.type = ParseNode.Type.CONCAT;
//			concatNode.left = node;
//
//			return concatNode;
//		}
//
//		List<ParseNode> leaves = new ArrayList<ParseNode>();
//		String rewrittenRegex = regex;
//
//		while (!rewrittenRegex.startsWith("(")) {
//			for (int i = 0; i < regex.length(); ++i) {
//				char c = regex.charAt(i);
//
//				if (startLeaf(i)) {
//					ParseNode leaf = createLeaf(i);
//					rewrittenRegex = rewriteRegex(rewrittenRegex(i));
//					leaves.add(leaf);
//				}
//			}
//		}
//
//
//
//
//		return expressionStack.pop();
//	}

    static int currentPos = 0;

    private static ParseNode regexToExpressionTree(String regex) {
        // ((a|b)|(a|b)*)
        // ((a|b)|(a|b))
        // (a|b)*abb
        // ((a|b)*)

        Stack<ParseNode> nodes = new Stack<ParseNode>();
        for (int i = currentPos; i < regex.length(); ++i) {
            char c = regex.charAt(i);

            if (c == '(') {
                currentPos = i + 1;
                nodes.push(regexToExpressionTree(regex));
                i = currentPos;
            }
            else if (c == ')') {
                currentPos = i;
                ParseNode last = null;

                if (nodes.size() == 1) {
                    last = nodes.pop();

                    if (last.type.equals(ParseNode.Type.CHAR)) {
                        ParseNode concatNode = new ParseNode();
                        concatNode.type = ParseNode.Type.CONCAT;
                        concatNode.right = last;
                        return concatNode;
                    }
                    else {
                        return last;
                    }
                }

                while (!nodes.empty()) {
                    ParseNode current = nodes.pop();
                    if (nodes.empty()) {
                        if (current.type.equals(ParseNode.Type.ALT)) {
                            if (current.right != null) {
                                ParseNode concatNode = new ParseNode();
                                concatNode.type = ParseNode.Type.CONCAT;
                                concatNode.left = current;
                                concatNode.right = last;

                                return concatNode;
                            }
                            else {
                                current.right = last;
                                return current;
                            }
                        }
                        else {
                            ParseNode concatNode = new ParseNode();
                            concatNode.type = ParseNode.Type.CONCAT;
                            concatNode.right = last;
                            concatNode.left = current;
                            return concatNode;
                        }
                    }
                    else {
                        last = current;
                    }
                }

                return nodes.pop();
            }
            else if (c == '|') {
                ParseNode altNode = new ParseNode();
                altNode.type = ParseNode.Type.ALT;
                altNode.left = nodes.pop();
                nodes.push(altNode);
            }
            else if (c == '*') {
                ParseNode starNode = new ParseNode();
                starNode.type = ParseNode.Type.STAR;
                starNode.left = nodes.pop();
                nodes.push(starNode);
            }
            else {
                ParseNode charNode = new ParseNode();
                charNode.type = ParseNode.Type.CHAR;
                charNode.data = Character.toString(c);
                nodes.push(charNode);
            }
        }

        return nodes.pop();
    }

//	private static ParseNode getFirstNonNullNode() {
//		ParseNode last = null;
//		for (ParseNode node : expressionStack) {
//			if (node.type != null) {
//				last = node;
//			}
//		}
//
//		return last;
//	}

    /*
     * Complete the countStrings function below.
     */
//	static int countStrings(String r, int l) {
    /*
     * Write your code here.
     */

    // l = length of strings that we are finding count for that match r
    // 1000000000 = max of l

//		regex = r;
//		stringCount = 0;
//		calculateStringCount(l);
//
//		System.out.println("count is " + stringCount);

    // System.out.println("ps:");
    // for (int i = 0; i < possibleStrings.length; ++i) {
    // System.out.println(possibleStrings[i]);
    // }

    // int matches = 0;
    // for (String ps : possibleStrings) {
    // matches += Pattern.matches(r, ps) ? 1 : 0;
    // }

    // System.out.println("matches " + stringCount);
//		return (int) (stringCount % (long) (Math.pow(10, 9) + 7));
//	}

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
            }
            else {
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

        // System.out.println(currentString.length());

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

        // calc(lengthTwoPossible, possiblyAdjustedLength);
        calc1("", alphabet, l);

        // if (l % 2 > 0) {
        // strings = calc(strings, alphabet);
        // }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//		countStrings("", 0);
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
