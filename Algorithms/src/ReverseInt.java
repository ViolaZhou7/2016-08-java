
public class ReverseInt {

	public static void main(String[] args) {
		// rotate an array with space complexity O(1) 
		// and time complexity O(n), with order = 2
		// so, the resulting array = {5,6,1,2,3,4}
		int[] arr = {1,2,3,4,5,6};
		int len = arr.length;
		int order = 2;
		
		// after executing, arr1=[4,3,2,1,5,6]
		reverse(arr,0,len-1-order);
		for(int i=0;i<len;i++){
			System.out.println(arr[i]);
		}
		
		// after executing, arr1=[4,3,2,1,6,5]
		reverse(arr,len-order, len-1);
		for(int i=0;i<len;i++){
			System.out.println(arr[i]);
		}
		
		// after executing, arr1=[5,6,1,2,3,4]
		reverse(arr,0,len-1);
		for(int i=0;i<len;i++){
			System.out.println(arr[i]);
		}
		
		
	}

	private static void reverse(int[] arr, int i, int j) {
		while(i<j){
			int temp = arr[i];
			arr[i++]=arr[j];
			arr[j--]=temp;
		}
	}

}
