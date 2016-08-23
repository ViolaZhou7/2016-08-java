import java.util.*;

public class LargestNumber {
	// given [3, 30, 34, 5, 9], the largest formed number is 9534330
	// Note: The result may be very large, so you need to return a string instead of an integer.
	public static void main(String[] args) {
		// lexicographically "30" > "3"
		// so, this method does NOT work for array containing element pairs 
		// like 20&2,30&3,43&4 ...
		// assume we avoid this situation
		String s1="32";
		String s2="3";
		System.out.println(s1.compareTo(s2));
		
		int[] arr={3,36,34,5,9};
		//SortedSet set = new TreeSet();
		//for(int i:arr){
			//set.add(Integer.toString(i));
		//}
		
		String[] str=new String[arr.length];
		for(int i=0;i<arr.length;i++)
			str[i]=Integer.toString(arr[i]);
		// elements in string array are sorted by lexicographically ascending
		Arrays.sort(str);
		
		//reverse string array, in order to be descending
		int i=0,j=str.length-1;
		while(i<j){
			String temp=str[i];
			str[i++]=str[j];
			str[j--]=temp;
		}
		
		StringBuilder result=new StringBuilder();
		for(String s:str)
			result.append(s);

		System.out.println(result);
	}

}
