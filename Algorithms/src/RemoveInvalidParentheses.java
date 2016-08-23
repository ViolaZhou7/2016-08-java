import java.util.*;

//Remove the minimum number of invalid parentheses in order to make the 
//input string valid. Return all possible results.

public class RemoveInvalidParentheses {
	private static List<String> result=new ArrayList<String>();
	private static int max=0;
	
	public static void main(String[] args) {
		String s="(())))()()()())()()";
		removeInvalidParentheses(s);
		
		for(String i:result)
			System.out.println(i);
		
	}
	
	public static List<String> removeInvalidParentheses(String s){
		
		if(s == null || s.length()==0)
			return result;
		
		dfs(s,"",0,0);
		if(result.size()==0){
			result.add("no valid result");
		}
		return result;
	}

	/*public static void dfs(String left, String right, int countLeft, int maxLeft) {
		if(left.length()==0){
            if(countLeft==0 && right.length()!=0){
                if(maxLeft > max){
                    max = maxLeft;
                }
 
                if(maxLeft==max && !result.contains(right)){ //output all possible results, no duplication allowed
                //if(maxLeft==max){ // output all possible results, duplication allowed
                    result.add(right);
                }
            }
 
            return;
        }
 
        if(left.charAt(0)=='('){
            dfs(left.substring(1), right+"(", countLeft+1, maxLeft+1);//keep (
            dfs(left.substring(1), right, countLeft, maxLeft);//drop (
        }else if(left.charAt(0)==')'){
            if(countLeft>0){
                dfs(left.substring(1), right+")", countLeft-1, maxLeft);
            }
 
            dfs(left.substring(1), right, countLeft, maxLeft);
 
        }else{
            //dfs(left.substring(1), right+String.valueOf(left.charAt(0)), countLeft, maxLeft);
        	dfs(left.substring(1), right+left.charAt(0), countLeft, maxLeft);
        }
	}*/
	
	
	
	
	
	public static void dfs(String left, String right, int countLeft, int maxLeft){
		if(left.length()==0){
			if(countLeft==0 && right.length()!=0){
				if(maxLeft > max)
					max=maxLeft;
				
				if(maxLeft==max && !result.contains(right))
					result.add(right);
			}
			return;
		}
		
		if(left.charAt(0)=='('){
			dfs(left.substring(1),right+"(",countLeft+1,maxLeft+1);//keep (
			dfs(left.substring(1),right,countLeft,maxLeft);//drop (
		}else if(left.charAt(0)==')'){
			if(countLeft > 0)
				dfs(left.substring(1),right+")",countLeft-1,maxLeft);
			dfs(left.substring(1),right,countLeft,maxLeft);
		}else{
			dfs(left.substring(1),right+left.charAt(0),countLeft,maxLeft);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
