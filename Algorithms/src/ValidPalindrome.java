
public class ValidPalindrome {

	//Given a string, determine if it is a palindrome, considering only 
	//alphanumeric characters and ignoring cases.

	//For example, "Red rum, sir, is murder" is a palindrome, while 
	//"Programcreek is awesome" is not.
	public static void main(String[] args) {
		String s=" Red rum, sir, is murder   ";
		s=s.trim();
		
		System.out.println(isValidPalindrome(s));
	}

	private static boolean isValidPalindrome(String s) {
		if(s == null)
			return false;
		if(s.length()<2)
			return true;
		
		// remove other chars first and then convert to lower case
		s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		
		char[] arr=s.toCharArray();
		
		int i=0,j=arr.length-1;
		
		while(i<j){
			if(arr[i] != arr[j])
				return false;
			i++;
			j--;
		}
		
		return true;
	}

}
