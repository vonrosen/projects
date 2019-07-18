package org.hunter.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayManip {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    		long biggestSum = 0;
    		
    		Arrays.sort(queries, new Comparator<int []>() {
    			public int compare(int [] o1, int [] o2) {
    				if (o1[0] > o2[0]) {
    					return 1;
    				}
    				else if (o1[0] < o2[0]) {
    					return -1;
    				}
    				else {
    					return 0;
    				}
    			}
    		});

    		long nops = 0;
    		long [] sums = new long[queries.length];
    		long currentSum = 0;
    		int minIndex = 0;
    		long minValue = 0;
    		System.out.println("begin");
    		for (int i = 0; i < queries.length; ++i) {
			currentSum = queries[i][2];
			for (int j = 0; j < i; ++j) {
				if (queries[i][0] <= queries[j][1]) {
					currentSum += queries[j][2];
				}
			}
		
			sums[i] = currentSum;    			
    		}
    		System.out.println("end");
    		System.out.println("number ops " + nops);

    		System.out.println(Arrays.stream(sums).max().getAsLong());
    		
    		return Arrays.stream(sums).max().getAsLong();
    }
    
	static long arrayManipulation3(int n, int[][] queries) {
		long biggestSum = 0;

		Arrays.sort(queries, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return 1;
				} else if (o1[0] < o2[0]) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		long nops = 0;
		long[] sums = new long[queries.length];
		long currentSum = 0;		
		List<int []> list1 = new ArrayList<int []>();
		System.out.println("begin");
		for (int i = 0; i < queries.length; ++i) {
			Collections.sort(list1, new Comparator<int []>() {
				public int compare(int [] o1, int [] o2) {
					if (o1[1] > o2[1]) {
						return 1;
					} else if (o1[1] < o2[1]) {
						return -1;
					} else {
						return 0;
					}
				}				
			});

			int currentIndex = i;
			currentSum = queries[i][2];
			currentSum += list1.stream().filter(item -> queries[currentIndex][0] <= item[1]).mapToLong(item -> item[2]).sum();
			
//			for (int j = 0; j < i; ++j) {
//				if (queries[i][0] <= queries[j][1]) {
//					currentSum += (long) queries[j][2];
//				}
//			}

			list1.add(queries[i]);
			sums[i] = currentSum;
		}
		System.out.println("end");
		System.out.println("number ops " + nops);

		System.out.println(Arrays.stream(sums).max().getAsLong());

		return Arrays.stream(sums).max().getAsLong();
	}    
    
	static long arrayManipulation2(int n, int[][] queries) {
		long biggestSum = 0;

		Arrays.sort(queries, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return 1;
				} else if (o1[0] < o2[0]) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		long nops = 0;
		//long[][] sums = new long[queries.length][2];
		List<long []> sums = new ArrayList<long []>();
		long last1 = 0;
		long min1 = 0;
		long currentSum = 0;
		int sumCounter = 0;
		System.out.println("begin");
		for (int i = 0; i < queries.length; ++i) {
			if (i > 0) {
				for (long [] sum : sums) {
					if (queries[i][0] <= sum[]) {
						sums[sumCounter][0] += (long)queries[i][2];
						sums[sumCounter][1] = queries[i][1] < min1 ? queries[i][1] : min1;
					}
					else {
						sums[++sumCounter] += (long)queries[i][2];
						min1 = queries[i][1] < min1 ? queries[i][1] : min1;
					}
				}
			}
			else {
				sums.add(new long [] { (long)queries[i][2], (long)queries[i][0] });
			}
		}
		
		System.out.println("end");
		System.out.println("number ops " + nops);

		System.out.println(Arrays.stream(sums).max().getAsLong());

		return Arrays.stream(sums).max().getAsLong();
	}   
	
//	static long arrayManipulation(int n, int[][] queries) {
//		long biggestSum = 0;
//		
//		Arrays.sort(queries, new Comparator<int []>() {
//			public int compare(int [] o1, int [] o2) {
//				if (o1[0] > o2[0]) {
//					return 1;
//				}
//				else if (o1[0] < o2[0]) {
//					return -1;
//				}
//				else {
//					return 0;
//				}
//			}
//		});
//		
//		List<int []> queryList = new ArrayList<int []>();
//		for (int [] query: queries) {
//			queryList.add(query);
//		}
//
//		
//		long sum  = 0;
//		for (int i = 0; i < queryList.size() + queryList.size(); ++i) {
//			if (i > 100) {
//				sum += 1;
//			}
//		}
//		
//		System.out.println(sum);
//		return sum;
//		
//		long [] sums = new long[queries.length];
//		long currentSum = 0;
//		int qlsize = queryList.size();
//		int sumIndex = 0;
//		for (int i = 0; i < qlsize; ++i) {
//			if (i > 0) {
//				currentSum = queryList.get(i)[2];
//				for (int j = 0; j < i; ++j) {
//					if (queryList.get(i)[0] <= queryList.get(j)[1]) {
//						currentSum += (long)queryList.get(j)[2];
//					}
//					else {
//						queryList.remove(j);
//						--qlsize;
//						--j;
//						--i;
//						System.out.println("qlsize" + qlsize);
//					}
//				}
//				
//				sums[sumIndex++] = currentSum;
//			}
//			else {
//				sums[sumIndex++] = (long)queryList.get(i)[2];
//			}
//		}
//
//		System.out.println(Arrays.stream(sums).map(item -> item).max().getAsLong());
//		
//		return Arrays.stream(sums).map(item -> item).max().getAsLong();		
//	}	

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
