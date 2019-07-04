package org.hunter.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class CountStrings2 {

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

    private static int modBy = 1000000007;

    private static long[][] matrixPowerLong(long[][] matrix, long power) {
        long[][] result = createIdentityMatrixLong(matrix.length, matrix.length);

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
        }

        return result;
    }

    private static int countStrings(String regex, int length) {
        currentPos = 0;
        dfaStateCounter = 0;

        if (!regex.contains("(")) {
            regex = "(" + regex + ")";
        }

        ParseNode tree = regexToExpressionTree(regex);
        NFA nfa = expressionTreeToNFA(tree);
        DFA dfa = subsetConstruct(nfa);
        long[][] matrix = dfa.probabilityMatrix();
        long[][] productMatrix = matrixPowerLong(matrix, length);
        long sumAcceptingStates = sumAcceptingStatesLong(productMatrix, dfa);

        System.out.println("regex: " + regex);
        System.out.println("length: " + length);
        System.out.println("number of strings: " + sumAcceptingStates);

        return (int) sumAcceptingStates;
    }

    private static long sumAcceptingStatesLong(long[][] productMatrix, DFA dfa) {
        long sum = 0;

        for (int finalState : dfa.finalStates) {
            sum += productMatrix[dfa.initial][finalState];
        }

        return sum % modBy;
    }

    private static Set<Integer> epsClosure(NFA nfa, Set<Integer> startingStates) {
        Set<Integer> stateSet = new HashSet<Integer>();

        for (int state : startingStates) {
            Set<Integer> movedToStates = nfa.getMoveToStates(nfa, state, NFA.epsStateType);

            stateSet.addAll(movedToStates);
        }

        return stateSet;
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

    static class DFA {
        int initial = 0;
        Set<Integer> finalStates = new HashSet<Integer>();
        Map<Transition, Integer> transTable = new HashMap<Transition, Integer>();

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

    static int currentPos = 0;

    private static ParseNode regexToExpressionTree(String regex) {
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
