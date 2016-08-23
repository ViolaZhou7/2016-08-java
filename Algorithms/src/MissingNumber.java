
public class MissingNumber {
	
	//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
	//find the one that is missing from the array. For example, 
	//given nums = [0, 1, 3] return 2.
	
	public static void main(String[] args) {
		int[] arr={0,1,2,3,4,6,7,8,9};
		
		System.out.println(findMissingNumber(arr));
		System.out.println(findMissingNumberByBitManipulation(arr));

	}

	private static int findMissingNumber(int[] arr) {
		// assume arr contains at least one element
		
		for(int i=0;i<arr.length;i++){
			if(arr[i] != i)
				return i;
		}
		
		// there is no missing element
		return -1;
		
	}
	
	private static int findMissingNumberByBitManipulation(int[] arr) {
		int missing=0;
		
		for(int i=0; i<arr.length; i++){
			// XOR relationship
	        missing ^= (i+1) ^arr[i];
	    }
	 
	    return missing;
	}

}
