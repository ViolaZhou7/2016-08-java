package Sorting;

public class BubbleSort {
	// time complexity: O(n^2)
	// space complexity: 1
	public static void main(String[] args) {
		int[] arr = {56,9,56,3,53,6,42,6,2,6,7,14,78,4,2};
		sortArray(arr);
		printArray(arr);
	}

	private static void sortArray(int[] arr) {
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}
	
	private static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
