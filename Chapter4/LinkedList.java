class ListNode {
	int value;
	ListNode next;
	
	public ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}	
}

public class LinkedList {
	private ListNode head;
	private int size;
		
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
			mBehind = mBehind.next;
		}
		return mBehind;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.findMToLast(1);
		list = new ListNode(0, new ListNode(1, new ListNode(2, null)));
		list.findMToLast(1);
	}
}