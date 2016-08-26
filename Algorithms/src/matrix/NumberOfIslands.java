package matrix;

public class NumberOfIslands {
	//Given a 2-d grid map of '1's (land) and '0's (water), count the number 
	//of islands. An island is surrounded by water and is formed by connecting 
	//adjacent lands horizontally or vertically. You may assume all four edges 
	//of the grid are all surrounded by water.
	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','0'}, // '1': island; '0': water
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','1'}};

		System.out.println(numberOfIslands(grid));
	}

	private static int numberOfIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int count=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j] == '1'){
					count++;
					merge(grid,i,j,m,n);
				}
			}
		}
		return count;
	}

	private static void merge(char[][] grid, int i, int j, int m, int n) {
		if(i<0 || i>=m || j<0 || j>=n || grid[i][j] != '1')
			return;
		
		grid[i][j] = 'x'; // merged
		
		merge(grid,i-1,j,m,n);
		merge(grid,i+1,j,m,n);
		merge(grid,i,j-1,m,n);
		merge(grid,i,j+1,m,n);	
	}

}
