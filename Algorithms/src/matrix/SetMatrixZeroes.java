package matrix;

public class SetMatrixZeroes {
	//Given a m * n matrix, if an element is 0, set its entire row and column to 0.
	//Do it in place.
	public static void main(String[] args) {
		int[][] matrix={{1,1,1,1},{1,1,0,1},{0,1,1,1},{1,1,1,1}};
		int rows=matrix.length;
		int cols=matrix[0].length;
		
		setZeroes(matrix,rows,cols);
		
		// output the result
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	private static void setZeroes(int[][] matrix, int rows, int cols) {
		
		boolean empty_row0=false; // if first row has 0, set to true; ow, false
		boolean empty_col0=false; // if first col has 0, set to true; ow, false
		
		// STEP 1
		for(int j=0;j<cols;j++){
			if(matrix[0][j] == 0){ // if first row has 0, set to true;
				empty_row0=true;
				break;
			}
		}
		
		//STEP 1
		for(int i=0;i<rows;i++){
			if(matrix[i][0] == 0){ // if first col has 0, set to true;
				empty_col0=true;
				break;
			}
		}
		
		// STEP 2
		// after this for loop, use first row and first column as mark
		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++){
				if(matrix[i][j] == 0){
					// set entry in the same col and in the first row to 0
					matrix[0][j]=0;
					// set entry in the same row and in the first col to 0
					matrix[i][0]=0;
				}
			}
		}
		
		// STEP 3
		// use first row and first column as mark
		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0){
					// set entry in the same row or col to 0
					matrix[i][j]=0;
				}
			}
		}
		
		// STEP 4
		if(empty_row0){
			// if first row has 0, set all entries in the first row to 0
			for(int j=0;j<cols;j++){
				matrix[0][j] = 0;
			}
		}
		
		// STEP 4
		if(empty_col0){
			// if first col has 0, set all entries in the first col to 0
			for(int i=0;i<rows;i++){
				matrix[i][0] = 0;
			}
		}
		
	}

}
