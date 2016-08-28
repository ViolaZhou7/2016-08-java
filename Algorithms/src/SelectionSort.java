
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {4,5,6,7,2,7,1,9,3,7};	
		int min = 0;
		
		for(int i=0;i<arr.length;i++){
			min = i; // assume min is the index of the first entry
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[min])
					min = j;
			}
			
			if(min != i){
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
