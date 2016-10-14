package Sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] x = {9,2,4,7,3,7,10};
		int left = 0;
		int right = x.length - 1;
		
		quickSort(x, left, right);
		for(int i : x){
			System.out.println(i);
		}
	}

	public static void quickSort(int[] x, int left, int right) {
		if (x == null || x.length == 0)
			return;
		
		if (left >= right)
			return;
		
		int i = left;
		int j = right;
		int pivot = left + (right - left) / 2;
		
		while (i <= j){
			while (x[i] < x[pivot]){
				i++;
			}
			while (x[pivot] < x[j]){
				j--;
			}
			
			if (i <= j){
				int temp = x[i];
				x[i] = x[j];
				x[j] = temp;
				i++;
				j--;
			}
		}
		
		if (left < j){
			quickSort(x, left, j);
		}
		if (i < right){
			quickSort(x, i, right);
		}
	}

}
