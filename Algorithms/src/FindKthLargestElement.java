import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElement {

	public static void main(String[] args) {
		int[] arr={3,2,1,5,6,4};
		// find 2nd largest element
		int key=2;
		// Method 1: sort arr by descending order first
		// time complexity:O(n^2)
		sort(arr,key);
		System.out.println(arr[key-1]);
		
		//Method 2: heap
		// time complexity:O(nlogk)
		int[] arr2={3,2,1,5,6,4};
		System.out.println(findKthLargest(arr2,key));
		
		//Method 3: use build-in sorting alg of array, by ascending
		// time complexity:O(nlogn)
		int[] arr3={3,2,1,5,6,4};
		Arrays.sort(arr3);
		System.out.println(arr3[arr3.length-key]);
		
		// more exercise about priority queue
		System.out.println();
		int[] arr4={3,2,1,5,6,4};
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		System.out.println("initial size: " + q.size());
		for(int i:arr4){
			System.out.println(q.add(i));
		}
		System.out.println("intermediate size: " + q.size());
		for(int i=0;i<arr4.length;i++){
			System.out.println((i+1) + "th element: " + q.poll());
		}
		System.out.println("final size: " + q.size());
		
	}

	private static int findKthLargest(int[] arr2, int key) {
		// initial capacity of the queue = key
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>(key);
		for(int i:arr2){
			queue.offer(i);
			if(queue.size()>key){
				queue.poll();
			}
		}
		return queue.peek();
	}

	private static void sort(int[] arr, int key) {
		for(int i=0;i<arr.length;i++){
			for(int j=i;j<arr.length;j++){
				if(arr[i]<arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}		
	}

}
