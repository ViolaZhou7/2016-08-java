package LinkedList;

public class Stack<E> {
	private E[] arr = null;
	private int size = 0;
	private int top = -1;
	private int CAP;
	
	@SuppressWarnings("unchecked")
	public Stack(int cap){ // initial an arr with capacity cap
		this.CAP = cap;
		this.arr = (E[]) new Object[cap];
	}
	
	public boolean push(E e){
		if(this.size == this.CAP) // arr is full, overflow
			return false;
		
		this.size++;
		
		arr[++top] = e;
		return true;
	}
	
	public E pop(){
		if(isEmpty())
			return null;
		
		this.size--;
		
		E result = arr[top];
		arr[top] = null;
		this.top--;
		
		return result;
	}
	
	public E peek(){
		if(isEmpty())
			return null;
		
		return arr[top];
	}
	
	public boolean isEmpty(){
		if(this.size == 0)
			return true;
		
		return false;
	}
	
	public String toString(){
		if(isEmpty())
			return null;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<this.size;i++){
			sb.append(arr[i] + ", ");
		}
		
		sb.setLength(sb.length()-2); // remove the last ", "
		return sb.toString();
	}
	public static void main(String[] args) {
		// A String stack instance
		Stack<String> stack = new Stack<String>(3);
		stack.push("hello");
		stack.push("world");		
		System.out.println(stack.toString());
		
		System.out.println(stack.peek());
		
		stack.pop();
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		
		// An Integer stack instance
		Stack<Integer> stack2 = new Stack<Integer>(3);
		stack2.push(1);
		stack2.push(2);
		System.out.println(stack2.toString());
	}

}
