import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Leaderboard {

	private static int findRank(int aliceScore, int[] scores, int start, int end) {

		if (start >= end) {
			if (scores[start] > aliceScore) {
				return allRanks[start] + 1;
			}
			else {
				return allRanks[start];
			}
		}

		int mid = start + ((end - start) / 2);

		if (scores[mid] > aliceScore) {
			return findRank(aliceScore, scores, mid + 1, end);
		}
		else if (scores[mid] < aliceScore) {
			return findRank(aliceScore, scores, start, mid);
		}
		else {
			return allRanks[mid];
		}
	}

	static int [] allRanks = null;

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] aliceRanks = new int[alice.length];
		int aliceRankIndex = 0;
    	int currentScoreRank = 1;
    	allRanks = new int[scores.length];

    	for (int scoreIndex = 0; scoreIndex < scores.length; ++scoreIndex) {
			if (scoreIndex > 0 && scores[scoreIndex] != scores[scoreIndex - 1]) {
				++currentScoreRank;
			}

			allRanks[scoreIndex] = currentScoreRank;
    	}

		for (int aliceScore : alice) {
			aliceRanks[aliceRankIndex++] = findRank(aliceScore, scores, 0, scores.length - 1);
		}

		return aliceRanks;
	}

//	static int[] climbingLeaderboard(int[] scores, int[] alice) {
//
//    	//scores in desc order
//    	//alice in asc order
//
//    	int [] aliceRanks = new int[alice.length];
//    	int [] allRanks = new int[scores.length];
//    	int [] allRanksSorted = new int[scores.length];
//    	int aliceRankIndex = 0;
//    	int lastScoreIndex = scores.length;
//    	int currentScoreRank = 1;
//
//    	for (int scoreIndex = 0; scoreIndex < scores.length; ++scoreIndex) {
//			if (scoreIndex > 0 && scores[scoreIndex] != scores[scoreIndex - 1]) {
//				++currentScoreRank;
//			}
//
//			allRanks[scoreIndex] = currentScoreRank;
//			allRanksSorted[scoreIndex] = currentScoreRank;
//    	}
//
//    	if (alice[0] >= scores[0]) {
//    		for (int i = 0; i < aliceRanks.length; ++i) {
//    			aliceRanks[i] = 1;
//    		}
//
//    		return aliceRanks;
//    	}
//
//    	if (alice[alice.length - 1] < scores[scores.length - 1]) {
//        	Arrays.sort(allRanksSorted);
//
//    		for (int i = 0; i < aliceRanks.length; ++i) {
//    			aliceRanks[i] = allRanksSorted[scores.length - 1] + 1;
//    		}
//
//    		return aliceRanks;
//    	}
//
//    	for (int aliceScore: alice) {
//
//        	int aliceRank = 1;
//
//    		for (int scoreIndex = 0; scoreIndex < lastScoreIndex; ++scoreIndex) {
////    			if (scoreIndex > 0 && scores[scoreIndex] != scores[scoreIndex - 1]) {
////    				++currentScoreRank;
////    			}
//
////    			System.out.println("cs:" + scores[scoreIndex]);
////    			System.out.println("csr:" + currentScoreRank);
//
//    			if (aliceScore < scores[scoreIndex]) {
//    				//she lost
//    				aliceRank = allRanks[scoreIndex] + 1;
//    			}
//    			else if (aliceScore == scores[scoreIndex]) {
//    				aliceRank = allRanks[scoreIndex];
//    				lastScoreIndex = scoreIndex;
//    				break;
//    			}
//    			else {
//    				//she won
//    				aliceRank = allRanks[scoreIndex];
//    				lastScoreIndex = scoreIndex;
//    				break;
//    			}
//    		}
//
//    		aliceRanks[aliceRankIndex++] = aliceRank;
//    	}
//
//    	return aliceRanks;
//    }

//	static int findRank(int aliceScore, int [] scores, int begin, int end) {
//
//		int mid = begin + ((end - begin) / 2);
//
//
//
//
//	}

	// Complete the climbingLeaderboard function below.
//    static int[] climbingLeaderboard(int[] scores, int[] alice) {
//    	int [] aliceRanks = new int[alice.length];
//    	int [] allRanks = new int[scores.length];
//    	int aliceRankIndex = 0;
//    	int currentScoreRank = 1;
//
//    	for (int scoreIndex = 0; scoreIndex < scores.length; ++scoreIndex) {
//			if (scoreIndex > 0 && scores[scoreIndex] != scores[scoreIndex - 1]) {
//				++currentScoreRank;
//			}
//
//			allRanks[scoreIndex] = currentScoreRank;
//    	}
//
//    	for (int aliceScore: alice) {
//    		aliceRanks[aliceRankIndex++] = findRank(aliceScore, scores);
//    	}
//
//    	int lastRankIndex = 0;
//
//    	for (int aliceScore: alice) {
//        	int aliceRank = 1;
//
//    		for (int rankIndex = lastRankIndex; rankIndex < allRanks.length; ++rankIndex) {
//    			if (aliceScore < scores[rankIndex]) {
//    				aliceRank = allRanks[rankIndex] + 1;
//    			}
//    			else if (aliceScore == scores[rankIndex]) {
//    				aliceRank = allRanks[rankIndex];
//    				lastRankIndex = rankIndex;
//    				break;
//    			}
//    			else {
//    				aliceRank = allRanks[rankIndex];
//    				lastRankIndex = rankIndex;
//    				break;
//    			}
//    		}
//
//    		aliceRanks[aliceRankIndex++] = aliceRank;
//    	}
//
//    	return aliceRanks;
//    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int scoresCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[scoresCount];

		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < scoresCount; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int aliceCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] alice = new int[aliceCount];

		String[] aliceItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < aliceCount; i++) {
			int aliceItem = Integer.parseInt(aliceItems[i]);
			alice[i] = aliceItem;
		}

		int[] result = climbingLeaderboard(scores, alice);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
