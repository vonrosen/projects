package org.hunter.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayManip {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    		long biggestSum = 0;
    		long [][] sums = new long[queries.length][4];

    		for (int i = 0; i < queries.length; ++i) {
//    			long sum1 = 0;
//    			long sum2 = 0;
//    			final int currentIndex = i;

    			//System.out.println("array= " + queries[currentIndex][0] + "," + queries[currentIndex][1] + "," + queries[currentIndex][2]);

//    			sum1 = Arrays.stream(queries).filter(item ->
//    			    queries[currentIndex][0] >= item[0] && queries[currentIndex][0] <= item[1]).mapToInt(item -> item[2]).sum();
//
//                sum2 = Arrays.stream(queries).filter(item ->
//                    queries[currentIndex][1] >= item[0] && queries[currentIndex][1] <= item[1]).mapToInt(item -> item[2]).sum();
//
//                sum1 = sum2 > sum1 ? sum2 : sum1;
//
//                biggestSum = sum1 > biggestSum ? sum1 : biggestSum;


    		    if (i > 0) {
    		        long sum = queries[i][2];
    		        for (int j = 0; j < i; ++j) {
    		            if (queries[i][0] >= sums[j][0] && queries[i][0] <= sums[j][1] ||
    		                queries[i][1] >= sums[j][0] && queries[i][1] <= sums[j][1] ||
    		                queries[i][0] < sums[j][0] && queries[i][1] > sums[j][1]) {

    		                sum += sums[j][2];
    		            }
    		        }

                    sums[i][0] = queries[i][0];
                    sums[i][1] = queries[i][1];
                    sums[i][2] = queries[i][2];
                    sums[i][3] = sum;
                    //System.out.println("it" + i + "=" + sum);
    		    }
    		    else {
    		        sums[i][0] = queries[i][0];
    		        sums[i][1] = queries[i][1];
    		        sums[i][2] = queries[i][2];
    		        sums[i][3] = queries[i][2];
    		    }
    		}

//    		for (int i = 0; i < sums.length; ++i) {
//                System.out.println(sums[i][3]);
//    		}

    		biggestSum = Arrays.stream(sums).mapToLong(item -> item[3]).max().getAsLong();

    		System.out.println("bs" + biggestSum);
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
