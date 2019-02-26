import java.util.Comparator;

public class CompareByX implements Comparator<AlgyPoint> {
    public int compare(AlgyPoint a, AlgyPoint b) {
        return Integer.compare(a.getX(), b.getY());
    }
}