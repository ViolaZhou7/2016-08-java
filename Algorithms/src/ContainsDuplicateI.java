import java.util.*;

public class ContainsDuplicateI {

	public static void main(String[] args) {
		int[] arr={5,4,6,7,2,8,5,9};
		System.out.println(containsDuplicate1(arr));
		System.out.println(containsDuplicate2(arr));

	}

	private static boolean containsDuplicate1(int[] arr) {
		// Set does NOT allow duplicate elements
		Set<Integer> set=new HashSet<Integer>();
		for(int i:arr){
			if(set.add(i)) // the element can be successfully inserted-->no duplicate
				continue;
			else
				// return true if there is duplicate elements
				return true;
		}
		// there is no duplicate element so return false
		return false;
		
	}
	
	private static boolean containsDuplicate2(int[] arr) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i:arr){
			if(map.containsKey(i))
				// key already contains in the map-->duplicate
				return true;
			map.put(i, 1);
		}
		
		// there is no duplicate element
		return false;
	
	}
}
