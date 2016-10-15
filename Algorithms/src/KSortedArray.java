import java.util.PriorityQueue;

public class KSortedArray{

	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7};
		int[] arr2 = {2,4,6,8};
		int[] arr3 = {0,9,10,11};
		
		int[] result = mergeKSortedArray(new int[][] {arr1, arr2, arr3});
		for (int i : result)
			System.out.println(i);
	}

	public static int[] mergeKSortedArray(int[][] arrs) {
		// PriorityQueue is heap in Java
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		
		int count = 0; // count total number of elements in the arrs
		
		// put arrays into the queue
		for(int i = 0; i < arrs.length ; i++){
			queue.offer(new ArrayContainer(arrs[i],0));
			count += arrs[i].length;
		}
		
		int result[] = new int[count]; // store result
		int i = 0; // index counter
		
		while (!queue.isEmpty()){
			ArrayContainer ac = queue.poll();
			result[i++] = ac.arr[ac.index];
			
			if (ac.index < (ac.arr.length-1))
				queue.offer(new ArrayContainer(ac.arr, ac.index+1));
		}
		
		return result;
	}

}
