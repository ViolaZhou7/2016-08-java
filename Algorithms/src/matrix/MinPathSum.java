package matrix;

public class MinPathSum {
	//Given a m x n grid filled with non-negative numbers, find a path from 
	//top left to bottom right which minimizes the sum of all numbers along its path.
	public static void main(String[] args) {
		int[][] board={{3,6,8,2,9,4,7,2},
				{4,6,6,8,2,1,6,4},
				{2,5,6,6,3,9,9,3},
				{8,3,4,1,5,2,5,7},
				{1,3,4,7,6,4,7,8},
				{4,5,3,6,2,6,2,6},
				{9,3,8,3,8,9,7,8},
				{8,3,2,7,1,6,4,5}};
		
		System.out.println("Minimum path sum: " + minPathSum(board));
		System.out.println("Minimum path sum: " + minPathSumByDynamic(board));
	}

	/*
	 * dfs; it's time is too expensive and fails the online judgment.
	 */
	private static int minPathSum(int[][] board) {
		return dfs(0,0,board);
		
	}
	
	private static int dfs(int i, int j, int[][] board) {
		if(i == board.length-1 && j == board[0].length-1)
			return board[i][j];
		
		if(i < board.length-1 && j < board[0].length-1){
			int sum1=board[i][j] + dfs(i+1,j,board);
			int sum2=board[i][j] + dfs(i,j+1,board);
			return Math.min(sum1, sum2);
		}
		
		if(i < board.length-1){
			return board[i][j] + dfs(i+1,j,board);
		}
		
		if(j < board[0].length-1){
			return board[i][j] + dfs(i,j+1,board);
		}
		
		return 0;
	}
	
	/*
	 * dynamic programming
	 */
	private static int minPathSumByDynamic(int[][] board) {
		if(board == null || board.length == 0)
			return 0;
		
		int m = board.length; // # of rows
		int n = board[0].length; // # of cols
		
		int[][] path = new int[m][n];
		path[0][0] = board[0][0];
		
		// initialize the first row
		for(int j=1;j<n;j++){
			path[0][j] = path[0][j-1] + board[0][j];
		}
		
		// initialize the left col
		for(int i=1;i<m;i++){
			path[i][0] = path[i-1][0] + board[i][0];
		}
		
		// fill up the path matrix, each cell stores the min path sum to it
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(path[i][j-1] < path[i-1][j])
					path[i][j] = path[i][j-1] + board[i][j];
				else
					path[i][j] = path[i-1][j] + board[i][j];
			}
		}
		
		return path[m-1][n-1];
	}

}
