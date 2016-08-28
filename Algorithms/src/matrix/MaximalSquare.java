package matrix;

public class MaximalSquare {
	//Given a 2D binary matrix filled with 0's and 1's, find the 
	//largest square containing all 1's and return its area.
	public static void main(String[] args) {
		int[][] matrix = {{1,1,0,0,0},
				{1,1,0,1,0},
				{0,0,1,1,1},
				{1,0,1,1,1},
				{1,1,1,1,1}};
		System.out.println(maxSquare(matrix));
	}
	
	/*
	 * dynamic programming
	 */
	private static int maxSquare(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] t = new int[m][n];
		
		// initialize top row
		for(int j=0;j<n;j++){
			t[0][j] = matrix[0][j];
		}
		
		// initialize left col
		for(int i=0;i<m;i++){
			t[i][0]	= matrix[i][0];	
		}
		
		int min = 0;
		
		//The changing condition is: t[i][j] = min(t[i][j-1], t[i-1][j],
		//    t[i-1][j-1]) + 1. It means the square formed before this point.
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][j] == 1){
					min = Math.min(t[i-1][j-1], t[i-1][j]);
					min = Math.min(min, t[i][j-1]);
					t[i][j] = min+1;
				}else{
					t[i][j] = 0;
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(t[i][j] > max)
					max = t[i][j];
			}
		}
		
		return max*max;
	}

}
