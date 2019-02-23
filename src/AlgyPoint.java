public class AlgyPoint {

    private int x;
    private int y;

    AlgyPoint(int _x, int _y) {
        x = _x;
        y = _y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return  y;
    }

    public String toString() {
        return "x: " + getX() + ", y: " + getY();
    }
}
