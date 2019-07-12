package org.hunter.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayManip {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    		long biggestSum = 0;
    		
    		for (int i = 0; i < queries.length; ++i) {
    			long sum = 0;
    			final int currentIndex = i;
//    			List<int []> intList = Arrays.stream(queries).collect(Collectors.toList());
//    			intList.remove(currentIndex);
//    			sum = intList.stream().filter(item -> 
//    				item[0] >= queries[currentIndex][0] && item[0] <= queries[currentIndex][1] ||
//    				item[1] >= queries[currentIndex][0] && item[1] <= queries[currentIndex][1]).mapToInt(item -> item[2]).sum();
    			
    			sum = Arrays.stream(queries).filter(item -> 
    				item[0] >= queries[currentIndex][0] && item[0] <= queries[currentIndex][1] ||
    				item[1] >= queries[currentIndex][0] && item[1] <= queries[currentIndex][1]).mapToInt(item -> item[2]).sum();
    			
    			System.out.println(sum);
    			
    			if (sum > biggestSum) {
    				biggestSum = sum;
    			}    			
    		}

    		System.out.println(biggestSum);
    		return biggestSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
