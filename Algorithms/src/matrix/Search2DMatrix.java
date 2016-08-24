package matrix;

public class Search2DMatrix {
	//Write an efficient algorithm that searches for a value in a sorted m x n matrix. 
	//This solution has time complecity O(logm + logn)
	public static void main(String[] args) {
		int[][] matrix={{1,2,3,4,5,6},{8,9,10,11,12,13},{15,16,17,18,19,20}};
		int key=13;
		search(matrix,key);
	}

	private static void search(int[][] matrix,int key) {
		int m=matrix.length;
		int n=matrix[0].length;
		
		int top=0;
		int bottom=m-1;
		
		// first find which row will the key be in
		// if bottom < 0, the matrix doesn't contain the key
		// else the key exists in row "bottom"
		// the only special case is when bottom = m-1, the key can either 
		// be in row "bottom" or doesn't exist in the matrix (compare the key
		// to the last entry of the matrix)
		while (top <= bottom){
			int mid=(top+bottom)/2;
			if(key == matrix[mid][0]){
				System.out.println("row: " + mid + " & col: " + 0);
				return;
			}else if(key < matrix[mid][0]){
				bottom = mid - 1;
			}else{
				top = mid + 1;
			}
		}
		
		if(bottom < 0){
			System.out.println("the matrix does not contain the key");
			return;
		}
		
		int left=0;
		int right=n-1;
		while(left <= right){
			if((bottom == m-1) && (key > matrix[bottom][right])){
				System.out.println("the matrix does not contain the key");
				return;
			}
			int mid=(left+right)/2;
			if(key == matrix[bottom][mid]){
				System.out.println("row: " + bottom + " & col: " + mid);
				return;
			}else if(key < matrix[bottom][mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		
		System.out.println("the matrix does not contain the key");
	}

}
