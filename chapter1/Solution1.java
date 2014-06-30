/**
 * Problem:
 * Determine whether a string is unique.
 */

public class Solution1 {
	/**
	 * Solution:
	 *
	 * Analysis:
	 * Time Complexity:
	 * Space Complexity:
	 */
	public static boolean isUnique(String str) {
		
    }

	public static void main(String[] args) {
        // unique string returns true
		assert (isUniqueArray("abcdef") == true);
		assert (isUniqueBit("abcdef") == true);
		assert (isUniqueHash("abcdef") == true);
		
		// empty string is unique.
		assert (isUniqueArray(null) == true);
		assert (isUniqueBit(null) == true);
        assert (isUniqueHash(null) == true);
		 
		// normal test
        assert (isUniqueArray("aaaaa") == false);
        assert (isUniqueBit("aaaaa") == false);
        assert (isUniqueHash("aaaaa") == false);

	}
}
