package org.hunter.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayManip {

	// Complete the arrayManipulation function below.
    static long arrayManipulation6(int n, int[][] queries) {
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
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

        long currentSum = 0;
        long maxSum = 0;
//    		System.out.println("begin");
        for (int i = 0; i < queries.length; ++i) {
            currentSum = queries[i][2];
            for (int j = 0; j < i; ++j) {
                if (queries[i][0] <= queries[j][1]) {
                    currentSum += queries[j][2];
                }
            }

            maxSum = currentSum > maxSum ? currentSum : maxSum;
        }
//    		System.out.println("end");
//    		System.out.println("number ops " + nops);

        System.out.println(maxSum);

        return maxSum;
    }

    static long arrayManipulation10(int n, int[][] queries) {
    	  
        //0 = sum of beginings
        //1 = sum of endings
        long [][] sums = new long[n + 1][2];
        int max1 = Arrays.stream(queries).mapToInt(item -> item[1]).max().getAsInt();
        for (int i = 0; i < queries.length; ++i) {
                sums[queries[i][0]][0] += queries[i][2];
                sums[queries[i][1]][1] += queries[i][2];
                
//                max1 = queries[i][1] > max1 ? queries[i][1] : max1;
        }

        long currentSum = 0;
        long maxSum = 0;
        for (int i = 0; i <= max1; ++i) {
                if (sums[i][0] > 0) {
                    currentSum += sums[i][0];                    
                }
                
                if (sums[i][1] > 0) {
                    maxSum = currentSum > maxSum ? currentSum : maxSum;
                    currentSum -= sums[i][1];
                }
        }
        
        System.out.println(maxSum);

        return maxSum;
    }    
    
	static long arrayManipulation(int n, int[][] queries) {
		Map<Long, Long[]> sumsMap = new HashMap<Long, Long[]>(queries.length * 2);

		for (int i = 0; i < queries.length; ++i) {
			if (sumsMap.get((long) queries[i][0]) == null) {
				sumsMap.put(new Long(queries[i][0]), new Long[] { (long) queries[i][2], 0L });
			} else {
				long value = sumsMap.get((long) queries[i][0])[0];
				long value2 = sumsMap.get((long) queries[i][0])[1];
				Long[] array = new Long[] { value + queries[i][2], value2 };
				sumsMap.put((long) queries[i][0], array);
			}

			if (sumsMap.get((long) queries[i][1]) == null) {
				sumsMap.put(new Long(queries[i][1]), new Long[] { 0L, (long) queries[i][2] });
			} else {
				long value = sumsMap.get((long) queries[i][1])[0];
				long value2 = sumsMap.get((long) queries[i][1])[1];
				Long[] array = new Long[] { value, value2 + queries[i][2] };
				sumsMap.put((long) queries[i][1], array);
			}
		}

		long currentSum = 0;
		long maxSum = 0;
		for (Long key : sumsMap.keySet().stream().sorted().collect(Collectors.toList())) {
			if (sumsMap.get(key)[0] > 0) {
				currentSum += sumsMap.get(key)[0];
			}

			if (sumsMap.get(key)[1] > 0) {
				maxSum = currentSum > maxSum ? currentSum : maxSum;
				currentSum -= sumsMap.get(key)[1];
			}
		}

		//System.out.println(maxSum);
		return maxSum;
	}

    static class ArrayKey {
        int start;
        int end;
        int value;

        @Override
        public boolean equals(Object o1) {
            ArrayKey ak1 = this;
            ArrayKey ak2 = (ArrayKey)o1;

            return ak1.start == ak2.start && ak1.end == ak2.end && ak1.value == ak2.value;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + new Integer(start).hashCode();
            result = 31 * result + new Integer(end);
            result = 31 * result + new Integer(value);
            return result;
        }
    }

//    static long arrayManipulation(int n, int[][] queries) {
//        Arrays.sort(queries, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] > o2[0]) {
//                    return 1;
//                }
//                else if (o1[0] < o2[0]) {
//                    return -1;
//                }
//                else {
//                    return 0;
//                }
//            }
//        });
//
//        List<ArrayKey> sortedByStart = new ArrayList<ArrayKey>();
//        List<ArrayKey> sortedByEnd = new ArrayList<ArrayKey>();
//
//        for (int [] query : queries) {
//            ArrayKey ak = new ArrayKey();
//            ak.start = query[0];
//            ak.end = query[1];
//            ak.value = query[2];
//
//            sortedByStart.add(ak);
//        }
//
//        Arrays.sort(queries, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] > o2[1]) {
//                    return 1;
//                }
//                else if (o1[1] < o2[1]) {
//                    return -1;
//                }
//                else {
//                    return 0;
//                }
//            }
//        });
//
//        for (int [] query : queries) {
//            ArrayKey ak = new ArrayKey();
//            ak.start = query[0];
//            ak.end = query[1];
//            ak.value = query[2];
//
//            sortedByEnd.add(ak);
//        }
//
//        long [] sums = new long[queries.length];
//
//        for (int i = 0; i < queries.length; ++i) {
//            ArrayKey ak = new ArrayKey();
//            ak.start = queries[i][0];
//            ak.end= queries[i][1];
//            ak.value = queries[i][2];
//
////            List<ArrayKey> matchedByStart = sortedByStart.stream().filter(item -> ak.start >= item.start).collect(Collectors.toList());
////            List<ArrayKey> matchedByEnd = sortedByEnd.stream().filter(item -> ak.start <= item.end).collect(Collectors.toList());
////            List<ArrayKey> matchedByStart2 = sortedByStart.stream().filter(item -> ak.start < item.start).collect(Collectors.toList());
////            List<ArrayKey> matchedByEnd2 = sortedByEnd.stream().filter(item -> ak.start > item.start).collect(Collectors.toList());
//
//            sums[i] = 0;
//        }
//
//        System.out.println(Arrays.stream(sums).max().getAsLong());
//
//        return Arrays.stream(sums).max().getAsLong();
//    }

    static long arrayManipulation3(int n, int[][] queries) {
        long biggestSum = 0;

        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
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
        long[] sums = new long[queries.length];
        long currentSum = 0;
        List<int[]> list1 = new ArrayList<int[]>();
        System.out.println("begin");
        for (int i = 0; i < queries.length; ++i) {
            Collections.sort(list1, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] > o2[1]) {
                        return 1;
                    }
                    else if (o1[1] < o2[1]) {
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            });

            int currentIndex = i;
            currentSum = queries[i][2];
            currentSum += list1.stream().filter(item -> queries[currentIndex][0] <= item[1]).mapToLong(item -> item[2])
                    .sum();

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

//	static long arrayManipulation2(int n, int[][] queries) {
//		long biggestSum = 0;
//
//		Arrays.sort(queries, new Comparator<int[]>() {
//			@Override
//            public int compare(int[] o1, int[] o2) {
//				if (o1[0] > o2[0]) {
//					return 1;
//				} else if (o1[0] < o2[0]) {
//					return -1;
//				} else {
//					return 0;
//				}
//			}
//		});
//
//		long nops = 0;
//		List<long []> sums = new ArrayList<long []>();
//		long last1 = 0;
//		long min1 = 0;
//		long currentSum = 0;
//		int sumCounter = 0;
//		System.out.println("begin");
//		for (int i = 0; i < queries.length; ++i) {
//			if (i > 0) {
//				for (long [] sum : sums) {
//					if (queries[i][0] <= sum[]) {
//						sums[sumCounter][0] += (long)queries[i][2];
//						sums[sumCounter][1] = queries[i][1] < min1 ? queries[i][1] : min1;
//					}
//					else {
//						sums[++sumCounter] += (long)queries[i][2];
//						min1 = queries[i][1] < min1 ? queries[i][1] : min1;
//					}
//				}
//			}
//			else {
//				sums.add(new long [] { queries[i][2], queries[i][0] });
//			}
//		}
//
//		System.out.println("end");
//		System.out.println("number ops " + nops);
//
//		System.out.println(Arrays.stream(sums).max().getAsLong());
//
//		return Arrays.stream(sums).max().getAsLong();
//	}

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
