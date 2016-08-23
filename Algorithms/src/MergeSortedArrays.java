
public class MergeSortedArrays {

	public static void main(String[] args) {
		// merge arr1 and arr2 into arr1 by ascending order
		// total number of elements in arr1 and arr2 = arr1.length
		int[] arr1=new int[10];
		for(int i=0;i<6;i++){
			arr1[i]=i;
		}
		int[] arr2={3,4,5,6};
		
		int m=6-1;
		int n=4-1;
		int k=m+n+1;
		
		// simple test cases to test if condition: 
		// arr1={1,2},arr2={3}
		// arr1={3},arr2={1,2}
		
		
		while(k>=0){
			// n<0 satisfies when all elements in arr2 have been inserted firstly
			// then need to insert remaining elements in arr1
			// think about arr1={1,2}, arr2={3}
			
			// m>=0 && arr1[m]>=arr2[n] satisfies when there are elements remaining
			// in arr1 and arr1[m]>=arr2[n]
			// m>=0 is necessary, think about arr1={3}, arr2={1,2}; if there is no m>=0
			// in some iteration, it has to compare arr1[-1] to arr2[1], it will throw 
			// index out of bound exception!!
			if(n<0 || (m>=0 && arr1[m]>=arr2[n])){
				//System.out.println("~~~~~~~~~~");
				arr1[k--]=arr1[m--];
			}else{
				//System.out.println("$$$$$$$$$$$");
				arr1[k--]=arr2[n--];
			}
		}
		
		for(int i:arr1)
			System.out.println(i);

	}

}
