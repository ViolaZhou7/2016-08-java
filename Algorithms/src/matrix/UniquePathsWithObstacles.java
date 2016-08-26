package matrix;

public class UniquePathsWithObstacles {
	//Follow up for "Unique Paths":
	//Now consider if some obstacles are added to the grids. 
	//An obstacle and empty space is marked as 1 and 0 respectively in the grid. 
	public static void main(String[] args) {
		//int[][] grid = {{0,0,0},{0,1,0},{0,0,0}}; // should return 2
		int[][] grid = {{0,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,0,1},
				{1,0,0,0,0},
				{0,0,0,0,0}};
				
		System.out.println(uniquePaths(grid));
		System.out.println(uniquePathsByDynamic(grid));
	}

	private static int uniquePaths(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		return dfs(grid,0,0,m,n);
	}

	private static int dfs(int[][] grid, int i, int j, int m, int n) {
		if(i == m-1 && j == n-1){
			if(grid[i][j] == 0)
				return 1;
			else
				return 0;
		}
		
		if(i < m-1 && j < n-1){
			if(grid[i][j] == 0)
				return dfs(grid,i+1,j,m,n) + dfs(grid,i,j+1,m,n);
			else
				return 0;
		}
		
		if(i < m-1){
			if(grid[i][j] == 0)
				return dfs(grid,i+1,j,m,n);
			else
				return 0;
		}
		
		if(j < n-1){
			if(grid[i][j] == 0)
				return dfs(grid,i,j+1,m,n);
			else
				return 0;
		}
		
		return 0;
	}

	private static int uniquePathsByDynamic(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
			return 0;
		
		int[][] path = new int[m][n];
		
		// at this point, grid[0][0] has checked with value 0, so path[0][0]=1
		path[0][0] = 1;
		
		// initialize the top row
		for(int j=1;j<n;j++){
			if(path[0][j-1] == 1 && grid[0][j] == 0){
				path[0][j] = 1;
			}else{
				path[0][j] = 0;
			}
		}
		
		// initialize the left col
		for(int i=1;i<m;i++){
			if(path[i-1][0] == 1 && grid[i][0] == 0){
				path[i][0] = 1;
			}else{
				path[i][0] = 0;
			}
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(grid[i][j] == 0){ // entry is 0
					path[i][j] = path[i-1][j] + path[i][j-1];
				}else{ // entry is 1, obstacle
					path[i][j] =0;
				}
			}
		}
		
		return path[m-1][n-1];
	}

}
