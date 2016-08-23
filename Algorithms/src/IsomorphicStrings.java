import java.util.*;

public class IsomorphicStrings {
	
	//Given two strings s and t, determine if they are isomorphic. 
	//Two strings are isomorphic if the characters in s can be replaced to get t.

	//For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
	
	public static void main(String[] args) {
		// It is one-to-one mapping. In this case, s1 is not isomorphic to s2.
		String s1="appq";
		String s2="eggg";
		
		System.out.println(isIsomorphic(s1,s2));

	}

	private static boolean isIsomorphic(String s1, String s2) {
		if(s1==null || s2==null)
			return false;
		
		if(s1.length()!=s2.length())
			return false;
		
		Map<Character,Character> map = new HashMap<Character,Character>();
		for(int i=0;i<s1.length();i++){
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			if(!map.containsKey(c1)){
				if(map.containsValue(c2)){
					return false;
				}
				map.put(c1, c2);
			}else{
				if(map.get(c1)!=c2){
					return false;
				}
			}
		}
		return true;
	}

}
