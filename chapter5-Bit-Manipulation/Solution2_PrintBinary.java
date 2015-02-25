/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
 * print the binary representation. if the number cannot be represented accurately
 * in binary with at most 32 characters, print"ERROR".
 */


public class Solution2_PrintBinary {
    public static String printBinary(double num) {
        if (num <= 0 || num >= 1) return "ERROR";

        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num > 0) {
            if (sb.length() >= 32) return "ERROR";

            num *= 2;

            if (num >= 1) {
                sb.append("1");
                num -= 1;
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        double num = 0.75;
        System.out.println(printBinary(num));
    }
}