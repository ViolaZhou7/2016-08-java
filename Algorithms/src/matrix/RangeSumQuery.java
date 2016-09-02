package matrix;

public class RangeSumQuery {
	//Given a 2D matrix matrix, find the sum of the elements inside the 
	//rectangle defined by its upper left corner (row1, col1) and lower 
	//right corner (row2, col2).
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4,5,6},
				{1,2,3,4,5,6},
				{1,2,3,4,5,6},
				{2,3,4,5,6,7},
				{2,3,4,5,6,7},
				{2,3,4,5,6,7}};
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		// define a matrix to store the sum value from (0,0) to the current 
		// cell in the rectangle region
		int[][] sum = new int[m][n];
		for(int i=0;i<m;i++){
			int sumRow = 0; // for each row, sum up from 0
			for(int j=0;j<n;j++){
				if(i == 0){
					sumRow += matrix[i][j];
					sum[i][j] = sumRow;
				}else{
					sumRow += matrix[i][j];
					sum[i][j] = sumRow + sum[i-1][j];
				}
			}
		}
		
		int row1 = 1; // top-left corner
		int col1 = 0;
		int row2 = 2; // bot-right corner
		int col2 = 2;
		
		System.out.println(sumRegion(sum,row1,col1,row2,col2));

	}

	private static int sumRegion(int[][] sum, int row1, int col1, int row2, int col2) {
		if (row1 == 0 && col1 == 0)
			return sum[row2][col2];
		else if (row1 == 0)
			return sum[row2][col2] - sum[row2][col1-1];
		else if (col1 == 0)
			return sum[row2][col2] - sum[row1-1][col2];
		else
			return sum[row2][col2] - sum[row2][col1-1]
					-sum[row1-1][col2] + sum[row1-1][col1-1];
	}

}
