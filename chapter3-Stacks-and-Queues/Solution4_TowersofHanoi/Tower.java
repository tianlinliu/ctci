/**
 * Question 3.4: ???
 * The classic problem of the Towers of Hanoi.
 */

import java.util.Stack;

public class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int index) {
        this.index = index;
        disks = new Stack<Integer>();
    }

    private int index() {
        return index;
    }

    public void addDisk(int disk) {
        if (!disks.isEmpty() && disks.peek() <= disk) {
            System.out.println("Error placing disk " + disk + ".");
        } else {
            disks.push(disk);
        }
    }

    private void moveTopTo(Tower to) {
        int top = disks.pop();
        to.addDisk(top);
        System.out.println("Move disk " + top + " from " + index() + " to " + to.index() + ".");
    }
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }


    public static void main(String[] args) {
        Tower first = new Tower(1);
        Tower second = new Tower(2);
        Tower third = new Tower(3);
        for (int i = 2; i > 0; i--) {
            first.addDisk(i);
        }
        first.moveDisks(2, third, second);
    }
}