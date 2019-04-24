import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

    	//scores in desc order
    	//alice in asc order

    	int [] aliceRanks = new int[alice.length];
    	int aliceRankIndex = 0;

    	for (int aliceScore: alice) {
        	int currentScoreRank = 1;
        	int aliceRank = 1;

    		for (int scoreIndex = 0; scoreIndex < scores.length; ++scoreIndex) {
    			if (scoreIndex > 0 && scores[scoreIndex] != scores[scoreIndex - 1]) {
    				++currentScoreRank;
    			}

//    			System.out.println("cs:" + scores[scoreIndex]);
//    			System.out.println("csr:" + currentScoreRank);

    			if (aliceScore < scores[scoreIndex]) {
    				//she lost
    				aliceRank = currentScoreRank + 1;
    			}
    			else if (aliceScore == scores[scoreIndex]) {
    				aliceRank = currentScoreRank;
    				break;
    			}
    			else {
    				//she won
    				aliceRank = currentScoreRank == 1 ? 1 : currentScoreRank;
    				break;
    			}
    		}

    		aliceRanks[aliceRankIndex++] = aliceRank;
    	}

    	return aliceRanks;
    }

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
