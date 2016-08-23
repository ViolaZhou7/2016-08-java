
public class FindPeakElement {
	
	//A peak element is an element that is greater than its neighbors. 
	//Given an input array where num[i] ¡Ù num[i+1], find a peak element and 
	//return its index. The array may contain multiple peaks, in that case 
	//return the index to any one of the peaks is fine.

	//You may imagine that num[-1] = num[n] = -¡Þ. For example, in array 
	//[1, 2, 3, 1], 3 is a peak element and your function should return the 
	//index number 2.
	public static void main(String[] args) {
		int[] arr={1,2,5,56,78,45,7,78,5768,357,68,386,6};
		
		//return the index of a peak element
		System.out.println(findPeakElement(arr));
	}

	private static int findPeakElement(int[] arr) {
		if(arr.length==0 || arr==null)
			return -1;
		if(arr.length==1)
			return 0;
		
		int max=arr[0];
		int index=0;
		
		// start for loop from the 2nd element to the 2nd last element
		for(int i=1;i<arr.length-1;i++){
			int left=i-1;
			int right=i+1;
			
			if(arr[i]>arr[left] && arr[i]>arr[right] && arr[i]>max){
				index=i;
				max=arr[i];
			}
		}
		
		// compare max to the last element
		if(arr[arr.length-1]>max){
			index=arr.length-1;
			max=arr[arr.length-1];
		}
		
		return index;
	}

}
