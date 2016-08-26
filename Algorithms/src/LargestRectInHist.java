import java.util.Stack;

public class LargestRectInHist {

	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}

	private static int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		
		int max = 0;
		int i = 0;
		
		// store indexes with corresponding increasing heights
		Stack<Integer> stack = new Stack<Integer>();
		
		while(i<height.length){
			// push index to stack if current height >= the height of the 
			// first index in the stack
			if(stack.isEmpty() || height[i] >= height[stack.peek()]){
				stack.push(i);
				i++;
			}else{
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty()? i : i - stack.peek() - 1;
				max = Math.max(h*w, max);
			}
		}
		
		while(!stack.isEmpty()){
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty()? i : i - stack.peek() - 1;
			max = Math.max(h*w, max);
		}
		
		return max;
	}

}
