
public class LengthOfLastWord {
	
	//Given a string s consists of upper/lower-case alphabets and empty 
	//space characters ' ', return the length of last word in the string. 
	//If the last word does not exist, return 0.
	public static void main(String[] args) {
		String s="x";
		
		if (s==null || s.length()==0)
			System.out.println("0");
		
		s=s.substring(s.lastIndexOf(' ')+1, s.length());
		System.out.println(s.length());

	}

}
