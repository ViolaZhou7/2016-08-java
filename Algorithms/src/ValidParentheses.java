import java.util.*;

public class ValidParentheses {
	//Given a string containing just the characters '(', ')', '{', '}', 
	//'[' and ']', determine if the input string is valid.

	//The brackets must close in the correct order, "()" and "()[]{}" 
	//are all valid but "(]" and "([)]" are not.
	public static void main(String[] args) {
		// test cases: "()", "(", ")", "((", "(()"
		String str="({[]})"; //valid
		
		System.out.println(isValid(str));
		
	}

	private static boolean isValid(String str) {
		Map<Character,Character> map=new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		
		Stack<Character> stack=new Stack<Character>();

		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(map.keySet().contains(c)){
				stack.push(c);
			}else if(map.values().contains(c)){
				// check if stack is empty to avoid empty stack exception
				// which is thrown by stack.peek()
				if(!stack.isEmpty() && map.get(stack.peek())==c){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		
		return stack.isEmpty();	
	}

}
