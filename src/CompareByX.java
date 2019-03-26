import java.util.Comparator;

/**
 * Comparator to use when sorting AlgyPoints. Sorts by X coordinate.
 *
 * @author Lauren Rose
 * @version v0.1
 *
 * Radford University
 * Department of Information Technology
 * ITEC 360 - Data Structures and Analysis of Algorithms
 */
public class CompareByX implements Comparator<AlgyPoint> {
    /**
     * Compares two AlgyPoints
     * @param a first AlgyPoint
     * @param b second AlgyPoint
     * @return the AlgyPoint with the lower X value
     */
    public int compare(AlgyPoint a, AlgyPoint b) {
        return Integer.valueOf(a.getX()).compareTo(Integer.valueOf(b.getX()));
    }
}