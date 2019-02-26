import java.util.Comparator;

public class CompareByY implements Comparator<AlgyPoint> {
    public int compare(AlgyPoint a, AlgyPoint b) {
        return Integer.compare(a.getY(), b.getY());
    }
}