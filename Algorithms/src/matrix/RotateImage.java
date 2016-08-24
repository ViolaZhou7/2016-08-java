package matrix;

public class RotateImage {
	//You are given an n x n 2D matrix representing an image.
	//Rotate the image by 90 degrees (clockwise).
	//Do this in place
	public static void main(String[] args) {
		// use the relationship matrix[i][j]=matrix[n-1-j][i]
		//int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix={{1,2},{3,4}};
		rotate90(matrix);
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	private static void rotate90(int[][] matrix) {
		int n=matrix.length;
		
		for(int i=0;i<n/2;i++){
			for(int j=0;j<Math.ceil(((double)n)/2);j++){
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-j][i];
				matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
				matrix[j][n-1-i]=temp;
			}
		}
	}

}
