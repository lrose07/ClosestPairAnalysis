import java.util.Arrays;

class DivideConquerSolver {

    private AlgyPoint[] allPoints;

    DivideConquerSolver(String inputStream) {
        parseInput(inputStream);
        runAlgorithm();
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

    private AlgyPoint[] sortPointsByX() {
        AlgyPoint[] tempByX = new AlgyPoint[allPoints.length];
        System.arraycopy(allPoints, 0, tempByX, 0, allPoints.length);
        Arrays.sort(tempByX, new CompareByX());
        return tempByX;
    }

    private AlgyPoint[] sortPointsByY() {
        AlgyPoint[] tempByY = new AlgyPoint[allPoints.length];
        System.arraycopy(allPoints, 0, tempByY, 0, allPoints.length);
        Arrays.sort(tempByY, new CompareByY());
        return tempByY;
    }

    private void runAlgorithm() {
        AlgyPoint[] xSorted = sortPointsByX();
        AlgyPoint[] ySorted = sortPointsByY();
    }

    private void closestPair(AlgyPoint[] sortedXArray, AlgyPoint[] sortedYArray) {
        int totalDataSize = sortedXArray.length;
        int midpoint = sortedXArray.length / 2;

        AlgyPoint[] leftXSorted = new AlgyPoint[midpoint];
        AlgyPoint[] rightXSorted = new AlgyPoint[midpoint];
        AlgyPoint[] leftYSorted = new AlgyPoint[midpoint];
        AlgyPoint[] rightYSorted = new AlgyPoint[midpoint];

        if (totalDataSize <= 3) {
            // run brute force solver
        } else {
            System.arraycopy(sortedXArray, 0,
                    leftXSorted, 0, leftXSorted.length);
            System.arraycopy(sortedXArray, midpoint + 1,
                    rightXSorted, 0, rightXSorted.length);
            // distribute/copy the same points from leftXSorted into leftYSorted
            // distribute/copy the same points from rightXSorted into rightYSorted
        }
    }
}
