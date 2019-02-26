import java.util.Arrays;

class DivideConquerSolver {

    private AlgyPoint[] allPoints;

    DivideConquerSolver(String inputStream) {
        parseInput(inputStream);
    }

    private void parseInput(String s) {
        String[] allInputNums = s.split("\\s+");
        int countOfPoints = Integer.parseInt(allInputNums[0]);

        allPoints = new AlgyPoint[countOfPoints];

        for (int i = 1, j = 0; i < allInputNums.length; i+=2, j++) {
            int pointX = Integer.parseInt(allInputNums[i]);
            int pointY = Integer.parseInt(allInputNums[i+1]);
            allPoints[j] = new AlgyPoint(pointX, pointY);
        }
    }

    void sortPointsByX() {
        Arrays.sort(allPoints, new CompareByX());
    }

    void sortPointsByY() {
        Arrays.sort(allPoints, new CompareByY());
    }
}
