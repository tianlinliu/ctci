class ListNode {
	int value;
	ListNode next;
	
	public ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}
	
	public String toString() {
		return "The node value: " + value;
	}
}

public class LinkedStack {
	private ListNode head;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(int value) {
		ListNode top = new ListNode(value, null);		
		if(isEmpty()) {
			head = top;
		} else {
			top.next = head;
			head = top;
		}
		size++;
	}
	
	public int pop() {
		if (head == null) throw new IllegalStateException("Cannot pop element from empty stack.");
		int headValue = head.value;
		head = head.next;
		size--;
		return headValue;
	}
	
	public ListNode findMToLast(int m) {
		if (head == null){
			return null;
		}
		ListNode current = head;
		for(int i = 0; i < m; i++) {
			if(current.next == null) throw new IllegalStateException(
				"The number of elements in the list is less than " + m + ".");
			current = current.next;
		}
		
		ListNode mBehind = head;
		while(current.next != null) {
			current = current.next;
			mBehind = mBehind.next;
		}
		return mBehind;
	}
	
	public static void main(String[] args){
		LinkedStack stack = new LinkedStack();
		//System.out.println(stack.isEmpty());
		//System.out.println(stack.pop());
		//System.out.println(stack.size());
		System.out.println(stack.findMToLast(1));
		
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.findMToLast(1));
		//System.out.println(stack.findMToLast(12));
		
		for (int i = 0; i < 10; i++) System.out.print(stack.pop() + " ");
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.pop());
		}
	}
	
}