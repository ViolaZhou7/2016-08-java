package matrix;

public class LongestIncreasingPath {
	//Given an integer matrix, find the length of the longest 
	//increasing path.
	//From each cell, you can either move to four directions: 
	//left, right, up or down. You may NOT move diagonally or 
	//move outside of the boundary
	public static void main(String[] args) {
		int[][] matrix = {{1,1},
				{1,1}};
		System.out.println(fingLongestIncreasingPath(matrix));
	}

	private static int fingLongestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] path = new int[m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dfs(matrix,i,j,path); // walk through every cell, store the longest path to each cell
			}
		}
		
		int longest = 1;
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				longest = Math.max(longest, path[i][j]); // find the max cell in path
			}
		}
		return longest;
	}

	private static void dfs(int[][] matrix, int i, int j, int[][] path) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		if(path[i][j] == 0) // initial path cell is 0
			path[i][j] = 1;
		
		if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]){ // top cell
			path[i-1][j] = Math.max(path[i-1][j], path[i][j]+1);
			dfs(matrix,i-1,j,path);
		}
		if(i+1 <= m-1 && matrix[i+1][j] > matrix[i][j]){ // bot cell
			path[i+1][j] = Math.max(path[i+1][j], path[i][j]+1);
			dfs(matrix,i+1,j,path);
		}
		if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]){ // left cell
			path[i][j-1] = Math.max(path[i][j-1], path[i][j]+1);
			dfs(matrix,i,j-1,path);
		}
		if(j+1 <= n-1 && matrix[i][j+1] > matrix[i][j]){ // right cell
			path[i][j+1] = Math.max(path[i][j+1], path[i][j]+1);
			dfs(matrix,i,j+1,path);
		}
			
	}

}
