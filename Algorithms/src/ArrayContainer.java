
public class ArrayContainer implements Comparable{
	int[] arr;
	int index;
	
	public ArrayContainer(int[] arr, int index){
		this.arr = arr;
		this.index = index;
	}
	
	@Override
	public int compareTo(Object o) {
		ArrayContainer a = (ArrayContainer) o; 
		return this.arr[this.index] - a.arr[a.index];
	}
}
