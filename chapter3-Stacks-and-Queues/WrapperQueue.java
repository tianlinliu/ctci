import java.util.LinkedList;

public class WrapperQueue {
    private LinkedList<Object> queue;

    public WrapperQueue() {
        queue = new LinkedList<Object>();
    }
    public void enqueue(Object data) {
        queue.addLast(data);
    }

    public Object dequeue() {
        return queue.removeFirst();
    }

    public Object peek() {
        return queue.getFirst();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}