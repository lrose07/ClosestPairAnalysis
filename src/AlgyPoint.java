/**
 * AlgyPoint object: consists of an x and a y value
 *
 * @author Lauren Rose
 * @version v0.1
 *
 * Radford University
 * Department of Information Technology
 * ITEC 360 - Data Structures and Analysis of Algorithms
 */
public class AlgyPoint {

    private int x;
    private int y;

    /**
     * Constructs an AlgyPoint object
     * @param _x x coordinate
     * @param _y y coordinate
     */
    AlgyPoint(int _x, int _y) {
        x = _x;
        y = _y;
    }

    /**
     * The x coordinate
     * @return x coordinate
     */
    int getX() {
        return x;
    }

    /**
     * The y coordinate
     * @return y coordinate
     */
    int getY() {
        return  y;
    }

    /**
     * Overrides default toString()
     * @return formatted string representation of AlgyPoint object
     */
    public String toString() {
        return "x: " + getX() + ", y: " + getY();
    }
}
