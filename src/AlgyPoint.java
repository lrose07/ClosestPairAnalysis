import java.util.Comparator;

public class AlgyPoint {

    private int x;
    private int y;

    AlgyPoint(int _x, int _y) {
        x = _x;
        y = _y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return  y;
    }

    public String toString() {
        return "x: " + getX() + ", y: " + getY();
    }

    public class CompareByX implements Comparator<AlgyPoint> {
        public int compare(AlgyPoint a, AlgyPoint b) {
            return (a.x - b.x) < 0 ? 0 : 1;
        }
    }

    public class CompareByY implements Comparator<AlgyPoint> {
        public int compare(AlgyPoint a, AlgyPoint b) {
            return (a.x - b.x) >= 0 ? 0 : 1;
        }
    }
}
