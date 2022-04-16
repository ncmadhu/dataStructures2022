package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class CafeteriaMetaQuestion extends Problem {
    @Override
    public void run() {
        System.out.println("Running Cafeteria Meta Question");
        long N, K;
        int M;
        long[] S;
        // N number of seats in the cafeteria
        // K Seats needs to be empty on both left and right side
        // M number of seats currently occupied
        // S Array of Occupied seats
        // Example N = 10, K = 1, M = 2, S = [2, 6]
        // Answer = 3 --- > [ 2 , , 4 , , 6 , , 8 , , 10 ] ---> Seats available 4,8,10
        N = 10;
        K = 1;
        M = 2;
        S = new long[]{2, 6};
        System.out.println("Seats Occupied: " + Arrays.toString(S));
        System.out.println("Total seats: " + N);
        System.out.println("Distance between seats: " + K);
        System.out.println("New seats available: " + this.getMaxAdditionalDinersCount(N, K, M, S));
        N = 15;
        K = 2;
        M = 3;
        S = new long[]{11, 6, 14};
        System.out.println("Seats Occupied: " + Arrays.toString(S));
        System.out.println("Total seats: " + N);
        System.out.println("Distance between seats: " + K);
        System.out.println("New seats available: " + this.getMaxAdditionalDinersCount(N, K, M, S));
    }

    private long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);
        long count = 0;
        long start = 1, end;
        for (int i = 0; i < M; i++) {
            end = S[i] - K - 1;
            count += this.getCount(start, end, K);
            start = S[i] + K + 1;
        }
        count += this.getCount(start, N, K);
        return count;
    }

    private long getCount(long start, long end, long K) {
        return end < start ? 0 : (end - start) / (K + 1) + 1;
    }
}
