import java.util.NoSuchElementException;

public class ThreeStacks {
    /**
     * Split an array into three stacks with equal length. Use another array to
     * store the pointers.
     */
    private int[] stacks;
    private int[] pointers;
    private int capacityForOne;

    public ThreeStacks(int capacityForOne) {
        this.capacityForOne = capacityForOne;
        stacks = new int[capacityForOne * 3];
        pointers = new int[] {0, 0, 0};
    }

    public void push(int stackNum, int data) {
        if (size(stackNum) == capacityForOne) throw
            new NoSuchElementException("Cannot add data to a full stack.");

        pointers[stackNum]++;
        stacks[pointer(stackNum)] = data;
    }

    public int pop(int stackNum) {
        if (size(stackNum) == 0) throw
            new NoSuchElementException("Cannot pop from an empty stack.");

        pointers[stackNum]--;
        return stacks[pointer(stackNum)];
    }

    public int peek(int stackNum) {
        if (size(stackNum) == 0) throw
            new NoSuchElementException("Cannot peek from an empty stack.");

        return stacks[pointer(stackNum)];
    }

    public int size(int stackNum) {
        if (stackNum < 0 && stackNum > 2) throw
            new IllegalStateException("Invalid stack number.");

        return pointers[stackNum];
    }

    public boolean isEmpty(int stackNum) {
        return size(stackNum) == 0;
    }

    private int pointer(int stackNum) {
        return pointers[stackNum] + stackNum * capacityForOne;
    }
}