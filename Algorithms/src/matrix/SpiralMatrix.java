package matrix;

public class SpiralMatrix {
	//Given a matrix of m x n elements (m rows, n columns), return all 
	//elements of the matrix in spiral order.
	
	//Hint: cycle by cycle
	public static void main(String[] args) {
		//int[][] matrix={{1,2,3},{4,5,6},{7,8,9}}; //You should return [1,2,3,6,9,8,7,4,5].
		int[][] matrix={{1,2,3,4,5,6,7},{8,9,10,11,12,13,14},{15,16,17,18,19,20,21}};
		outputInSpiralOrder(matrix);
	}

	private static void outputInSpiralOrder(int[][] matrix) {
		
		int m=matrix.length;
		int n=matrix[0].length;
		
		// first cycle, start from x=0, y=0
		// second cycle, start from x=1, y=1
		// ...
		int x=0;
		int y=0;
		
		if(matrix == null || m == 0){ // no element
			System.out.println("no element");
			return;
		}
		
		while(m > 0 && n > 0){
			if(m == 1){ // one row
				for(int j=0;j<n;j++){
					System.out.println(matrix[x][y++]);
				}
				break;
			}else if(n == 1){ // one col
				for(int i=0;i<m;i++){
					System.out.println(matrix[x++][y]);
				}
				break;
			}
			
			// top - move right
			for(int j=0;j<n-1;j++){
				System.out.println(matrix[x][y++]); // x=0, y=0..n-1
			}
			
			// right - move down
			for(int i=0;i<m-1;i++){
				System.out.println(matrix[x++][y]); // y=n-1, x=0..m-1
			}
			
			// bottom - move left
			for(int j=0;j<n-1;j++){
				System.out.println(matrix[x][y--]); // x=m-1, y=n-1..0
			}
			
			// left - move up
			for(int i=0;i<m-1;i++){
				System.out.println(matrix[x--][y]); // y=0, x=m-1..0
			}
			
			// next cycle, start from x=x+1, y=y+1
			x++; 
			y++;
			// next cycle, number of rows/cols which need to traverse is decreased by 2
			m=m-2;
			n=n-2;
		}
		
	}

}
