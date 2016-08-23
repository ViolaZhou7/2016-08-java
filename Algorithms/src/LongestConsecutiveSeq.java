import java.util.*;

public class LongestConsecutiveSeq {
	//Given an unsorted array of integers, find the length of the longest 
	//consecutive elements sequence.

	//For example, given [100, 4, 200, 1, 3, 2], the longest consecutive 
	//elements sequence should be [1, 2, 3, 4]. Its length is 4.
	public static void main(String[] args) {
		int[] arr={8,7,1,2,3,4,2,9};
		
		// output the length of the longest consecutive sequence
		// but without track the elements
		System.out.println(findLongest(arr));

	}

	private static int findLongest(int[] arr) {
		if(arr.length==0)
			return 0;
		
		Set<Integer> set=new HashSet<Integer>();
		
		// unsorted set
		for(int i: arr)
			set.add(i);
		
		// max count is at least 1
		int maxCount=1;
		
		for(int j: arr){
			int left=j-1;
			int right=j+1;
			int count=1; // initial count is 1, the element itself
			
			// if j exists in set, remove it; otherwise, redundant operation
			set.remove(j);
			
			while(set.contains(left)){
				set.remove(left);
				left--;
				count++;
			}
			while(set.contains(right)){
				set.remove(right);
				right++;
				count++;
			}
			//System.out.println("count: " + count);
			//System.out.println("size: " + set.size());
			maxCount=Math.max(maxCount, count);
		}
		
		return maxCount;
		
	}

}
