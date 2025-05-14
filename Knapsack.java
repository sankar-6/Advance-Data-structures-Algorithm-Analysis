package Adsaa;

public class Knapsack {

    public static int knap(int W, int[] p, int[] w) {
        int n = p.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], p[i - 1] + dp[i - 1][j - w[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int[] x = new int[n];
        int wRemaining = W;
        for (int i = n; i > 0; i--) {
            if (dp[i][wRemaining] != dp[i - 1][wRemaining]) {
                x[i - 1] = 1;
                wRemaining -= w[i - 1];
            } else {
                x[i - 1] = 0;
            }
        }

        System.out.print("Selected Items (0/1 Array): ");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] p = {10, 2, 5,8,3};     // profits
        int[] w = {2, 3, 4,6,2};     // weights
        int W = 15;               // capacity

        int maxValue = knap(W, p, w);
        System.out.println("Maximum Value: " + maxValue);
        System.out.println("Maximum Capacity: " + W);
    }
}
