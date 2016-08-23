
public class BinarySearch {

	public static void main(String[] args) {
		int[] sortedArray={1,2,3,4,5,6,7,8,9};
		int key=10;
		System.out.println(findKey(key, sortedArray));
		
		int start=0;
		int end=sortedArray.length-1;
		System.out.println(findKeyByRecursive(key, sortedArray, start, end));

	}
	
	private static int findKey(int k, int[] a) {
		int f=0;
		int l=a.length-1;
		
		while(f<=l){
			if(k == a[(f+l)/2])
				return (f+l)/2;
			if(k<a[(f+l)/2]){ // k < mid element
				l=(f+l)/2-1;
			}else{ // k > mid element
				f=(f+l)/2+1;
			}	
		}
		return -1;
	}

	private static int findKeyByRecursive(int k, int[] a, int start, int end) {
		if(start > end)
			return -1;
		if(k < a[(start+end)/2]) // <
			return findKeyByRecursive(k, a, start, (start+end)/2-1);
		else if(k > a[(start+end)/2]) // >
			return findKeyByRecursive(k, a, (start+end)/2+1, end);
		else // =
			return (start+end)/2;
	}

}
