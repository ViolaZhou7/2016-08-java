
public class StringToInt {

	public static void main(String[] args) {
		String s=" +14556345536879 808978456245 ";
		s=s.trim();
		System.out.println(atoi(s));
	}

	private static int atoi(String s) {
		// check if the string is null or is empty
		if(s==null || s.length()==0)
			return 0;
		
		int index=0;
		char flag='+';
		
		//if the first char is +, then positive
		//else if the first char is -, then negative
		//otherwise, positive
		if(s.charAt(index)=='+'){
			flag='+';
			index++;
		}else if(s.charAt(index)=='-'){
			flag='-';
			index++;
		}
		
		double result=0;
		while(index<s.length() && s.charAt(index)>='0' && s.charAt(index)<='9'){
			result=result*10+(s.charAt(index++)-'0');
		}
		
		//if negative, then result is -result
		if(flag=='-')
			result=-result;
		
		//check the max and min value
		if(result>Integer.MAX_VALUE)
			result=Integer.MAX_VALUE;
		if(result<Integer.MIN_VALUE)
			result=Integer.MIN_VALUE;
		
		return (int)result;
		
	}

}
