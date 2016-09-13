package Sorting;

public class SelectionSort {
	// time complexity: O(n^2)
	// space complexity: 1
	public static void main(String[] args) {
		int[] arr = {5,4,3,6,7,2,8,9,0,3,4,8,3};
		sortArray(arr);
		printArray(arr);
	}

	private static void sortArray(int[] arr) {
		int index; // index of min value
		for(int i=0;i<arr.length-1;i++){
			index = i; // initialize the index of min as the first index in the loop
			for(int j=i+1;j<arr.length;j++){
				if(arr[j] < arr[index]){
					index = j;
				}
			}
			
			// exchange values between arr[i] and min
			if(i != index){
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}

	private static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
