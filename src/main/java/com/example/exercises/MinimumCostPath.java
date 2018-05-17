package com.example.exercises;

class MinimumCostPath {

	public static void main(String args[]) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		//
		// int cost[][]= {{1, 1, 1, 1, 1, 1, 1, 1},
		// {1, 1, 1, 1, 1, 1, 1, 1},
		// {1, 1, 1, 1, 1, 1, 1, 1},
		// {1, 1, 1, 1, 1, 1, 1, 1},
		// {1, 1, 1, 1, 1, 1, 1, 1},
		// {1, 1, 1, 1, 1, 1, 1, 1},
		// {1, 1, 1, 1, 1, 1, 1, 1},
		// {1, 1, 1, 1, 1, 1, 1, 1}};
		System.out.println("minimum cost to reach (2,2) = " + minCost(cost, 0, 2));
	}

	private static int minCost(int cost[][], int m, int n) {
		System.out.println("in minCost");
		int i, j;
		int tc[][] = new int[m + 1][n + 1];

		tc[0][0] = cost[0][0];

		// Initialize first column of total cost array
		for (i = 1; i <= m; i++)
			tc[i][0] = tc[i - 1][0] + cost[i][0];

		// Initialize first row
		for (j = 1; j <= n; j++)
			tc[0][j] = tc[0][j - 1] + cost[0][j];

		// Construct rest of the array
		for (i = 1; i <= m; i++)
			for (j = 1; j <= n; j++)
				tc[i][j] = min(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]) + cost[i][j];

		for (int row = 0; row <= m; row++) {
			for (int col = 0; col <= n; col++) {
				System.out.print(tc[row][col] + "|");
			}
			System.out.println("");
		}
		return tc[m][n];
	}

	// returns minimum of 3 integers
	private static int min(int x, int y, int z) {
		System.out.println("min(" + x + "," + y + "," + z);
		if (x < y)
			return (x < z) ? x : z;
		else
			return (y < z) ? y : z;
	}
}