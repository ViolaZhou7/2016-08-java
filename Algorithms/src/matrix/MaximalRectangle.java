package matrix;

import java.util.Stack;

public class MaximalRectangle {
	
	//Given a 2D binary matrix filled with 0's and 1's, find the largest 
	//rectangle containing all ones and return its area.
	public static void main(String[] args) {
		int[][] matrix = {{0,1,0,0,1,0,0,0},
				{0,0,1,1,1,1,0,0},
				{0,0,1,1,1,1,0,0},
				{0,0,0,0,1,1,1,0},
				{0,1,0,0,1,1,0,0},
				{0,0,1,0,1,1,1,0}};
		// computes the largest area of rectangle which includes all 1's in the matrix
		System.out.println(maxRectangleContainingAllOnes(matrix));
		// computes the largest area of rectangle containg 1's only
		System.out.println(maxRectangleContainingOnesOnly(matrix));
		
	}
	/*computes the largest area of rectangle which includes all 1's in the matrix
	 * 
	 */
	private static int maxRectangleContainingAllOnes(int[][] matrix) {
		int top = -1;
		int bottom = matrix.length;
		int left = -1;
		int right = matrix[0].length;
		
		int sumTopDown = 0;
		int sumBottomUp = 0;
		
		boolean flagTopDown = true;
		boolean flagBottomUp = true;

		// determine top and bottom by summing up
		// if a row contains 1, then its sum > 0
		for(int i=0;i<matrix.length;i++){
			// sum of each row
			for(int j=0;j<matrix[0].length;j++){
				sumTopDown += matrix[i][j];
				sumBottomUp += matrix[matrix.length-1-i][j];	
			}
			if(flagTopDown && sumTopDown > 0){
				top = i;
				flagTopDown = false;
			}
			if(flagBottomUp && sumBottomUp > 0){
				bottom = matrix.length-1-i;
				flagBottomUp = false;
			}
		}
		
		int sumLeftRight = 0;
		int sumRightLeft = 0;
		
		boolean flagLeftRight = true;
		boolean flagRightLeft = true; 
		// determine left and right by summing up
		// if a col contains 1, then its sum > 0
		for(int j=0;j<matrix[0].length;j++){
			// sum of each col
			for(int i=0;i<matrix.length;i++){
				sumLeftRight += matrix[i][j];
				sumRightLeft += matrix[i][matrix[0].length-1-j];
			}
			if(flagLeftRight && sumLeftRight > 0){
				left = j;
				flagLeftRight = false;
			}
			if(flagRightLeft && sumRightLeft > 0){
				right = matrix[0].length-1-j;
				flagRightLeft = false;
			}
		}
		
		if(top == -1 || bottom == matrix.length)
			return 0;
		
		if(left == -1 || right == matrix[0].length)
			return 0;
		
		return (bottom-top+1)*(right-left+1);
	}
	
	/*
	 * computes the largest area of rectangle containg 1's only
	 */
	private static int maxRectangleContainingOnesOnly(int[][] matrix) {
		int m = matrix.length; // # of rows
		int n = m == 0 ? 0 : matrix[0].length; // # of cols
		int[][] height = new int[m][n+1];
		
		int maxArea = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j] == 0){
					height[i][j] = 0;
				}else{
					height[i][j] = i == 0 ? 1 : height[i-1][j] + 1;
				}
			}
		}
		
		// each row is equivalent to a histogram
		for(int i=0;i<m;i++){
			int area = maxAreaInHist(height[i]);
			if(area > maxArea)
				maxArea = area;
		}
		
		return maxArea;
	}
	
	/*
	 * reuse algorithm - Largest Rectangle in Histogram
	 */
	private static int maxAreaInHist(int[] height) {
		int max = 0;
		int i = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(i<height.length){
			if(stack.isEmpty() || height[i] >= height[stack.peek()]){
				stack.push(i);
				i++;
			}else{
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h*w);
			}
		}
		
		while(!stack.isEmpty()){
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, h*w);
		}
			
		return max;
	}


}
