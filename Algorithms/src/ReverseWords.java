
public class ReverseWords {

	public static void main(String[] args) {
		// rotate an array with space complexity O(1) 
		// and time complexity O(n)
		// test cases: " this is the sky", "this is the sky ", " this is the sky "
		String str = "this is the sky";
		char[] arr = str.toCharArray();
		int start=0;
		
		for(int end=0;end<arr.length;end++){
			// reverse each word first
			if(arr[end]==' '){
				reverse(arr,start,end-1);
				start=end+1;
			}
		}
		//if the last char is not space, reverse the last word
		//if the last char is space, do nothing since start(arr.length) > arr.length-1(end)
		reverse(arr,start,arr.length-1);
		
		//reverse the whole sentence
		reverse(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
		
	}

	private static void reverse(char[] arr, int start, int end) {
		while(start<end){
			char temp=arr[start];
			arr[start++]=arr[end];
			arr[end--]=temp;
		}
	}

}
