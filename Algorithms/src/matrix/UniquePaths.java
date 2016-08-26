package matrix;

public class UniquePaths {
	//A robot is located at the top-left corner of a m x n grid. 
	//It can only move either down or right at any point in time. 
	//The robot is trying to reach the bottom-right corner of the grid.
	public static void main(String[] args) {
		int[][] grid={{3,6,8,2,9,4,7,2},
				{4,6,6,8,2,1,6,4},
				{2,5,6,6,3,9,9,3},
				{8,3,4,1,5,2,5,7},
				{1,3,4,7,6,4,7,8},
				{4,5,3,6,2,6,2,6},
				{9,3,8,3,8,9,7,8},
				{8,3,2,7,1,6,4,5}};
		
		System.out.println(uniquePaths(grid));
		System.out.println(uniquePathsByDynamic(grid));

	}

	private static int uniquePaths(int[][] grid) {
		int m = grid.length; // rows
		int n = grid[0].length; // cols
		return dfs(0,0,m,n);
	}

	private static int dfs(int i, int j, int m, int n) {
		if(i == m-1 && j == n-1)
			return 1;
		
		if(i < m-1 && j < n-1)
			return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
		
		if(i < m-1)
			return dfs(i+1,j,m,n);
		
		if(j < n-1)
			return dfs(i,j+1,m,n);
		
		return 0;
	}
	
	private static int uniquePathsByDynamic(int[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		
		if(m == 1 || n == 1) // matrix has only one row or one col
			return 1;
		
		int[][] path = new int[m][n];
		
		// initialize the top row
		for(int j=0;j<n;j++){
			path[0][j] = 1;
		}
		
		// initialize the left col
		for(int i=0;i<m;i++){
			path[i][0] = 1;
		}
		
		// fill up the path matrix, each cell stores the # of unique paths to it
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				path[i][j] = path[i-1][j] + path[i][j-1];
			}
		}
		
		return path[m-1][n-1];
	}


}
