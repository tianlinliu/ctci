import java.util.NoSuchElementException;

public class ThreeStacks {
    /**
     *
     */
    private int[] stacks;
    private int[] pointers;
    private int capacityForOne;

    public ThreeStacks(int capacityForOne) {
        this.capacityForOne = capacityForOne;
        stacks = new int[capacityForOne * 3];
        pointers = new int[] {0, 0, 0};
    }

    public void push(int data, int stackNum) {
        if (stackNum < 1 && stackNum > 3) throw
            new IllegalStateException("Invalid stack number.");
        if (size(stackNum) == capacityForOne) throw
            new NoSuchElementException("Cannot add data to a full stack.");

        pointers[stackNum] = stackNum * capacityForOne + 1;
        stacks[pointers[stackNum]] = data;
    }

    public int pop(int stackNum) {
        if (stackNum < 1 && stackNum > 3) throw
            new IllegalStateException("Invalid stack number.");
        if (size(stackNum) == 0) throw
            new NoSuchElementException("Cannot pop from an empty stack.");

        return stacks[pointers[stackNum]--];
    }

    public int peek(int stackNum) {
        if (stackNum < 1 && stackNum > 3) throw
            new IllegalStateException("Invalid stack number.");
        if (size(stackNum) == 0) throw
            new NoSuchElementException("Cannot peek from an empty stack.");

        return stacks[pointers[stackNum]];
    }

    public int size(int stackNum) {
        if (stackNum < 1 && stackNum > 3) throw
            new IllegalStateException("Invalid stack number.");

        return pointers[stackNum] - stackNum * capacityForOne;
    }

    public boolean isEmpty(int stackNum) {
        return size(stackNum) == 0;
    }
}