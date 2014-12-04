/**
 * Implement the "paint fill" function. Given a screen(a two-dimensional array of colors),
 * a point, and a new color, fill in the surrounding area until the color changes from the
 * original color.
 */

public class Solution7_paintFill {
    public enum Color {Red, Yellow, Blue, Black, White}

    public boolean paintFill(Color[][] screen, int x, int y, Color oColor, Color nColor) {
        if (screen == null || screen.length == 0) return false;
        if (x < 0 || y < 0 || x >= screen[0].length || y >= screen.length) {
            return false;
        }


    }
}