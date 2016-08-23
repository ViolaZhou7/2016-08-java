import java.util.*;

public class FindDuplicateNumber {
	//Given an array nums containing n + 1 integers where each integer is 
	//between 1 and n (inclusive), prove that at least one duplicate number 
	//must exist. Assume that there is only one duplicate number, find the 
	//duplicate one.
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7,8,3,9,10};
		
		System.out.println(findDuplicateNumberByMap(arr));
		System.out.println(findDuplicateNumberBySet(arr));

	}

	private static int findDuplicateNumberByMap(int[] arr) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i]))
				return arr[i];
			map.put(arr[i], 0);
		}
		return -1;
	}
	
	private static int findDuplicateNumberBySet(int[] arr) {
		Set<Integer> set=new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++){
			if(set.contains(arr[i]))
				return arr[i];
			set.add(arr[i]);
		}
		return -1;
	}
	
}
