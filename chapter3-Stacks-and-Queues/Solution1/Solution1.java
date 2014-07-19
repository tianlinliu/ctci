/**
 * Question 3.1:
 * Use a single array to implement three stacks.
 */

public class Solution1 {

    public static void main(String[] args) {
        ThreeStacks stacks = new ThreeStacks(5);
        System.out.println(stacks.isEmpty(1));
        stacks.push(2, 1);
        stacks.push(2, 2);
        System.out.println(stacks.pop(2));
        System.out.println(stacks.size(2));
        System.out.println(stacks.isEmpty(2));
    }
}