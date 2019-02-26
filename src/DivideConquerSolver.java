import java.util.ArrayList;
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
        closestPair(xSorted, ySorted);
    }

    private AlgyPoint[] closestPair(AlgyPoint[] sortedXArray, AlgyPoint[] sortedYArray) {
        int totalDataSize = sortedXArray.length;
        int midpoint = sortedXArray.length / 2;

        AlgyPoint[] leftXSorted = new AlgyPoint[midpoint];
        AlgyPoint[] rightXSorted = new AlgyPoint[midpoint];
        AlgyPoint[] leftYSorted = new AlgyPoint[midpoint];
        AlgyPoint[] rightYSorted = new AlgyPoint[midpoint];

        if (totalDataSize <= 3) {
            BruteForceSolver BFSolver = new BruteForceSolver(sortedXArray);
            return BFSolver.getClosestPair();
        } else {
            System.arraycopy(sortedXArray, 0,
                    leftXSorted, 0, leftXSorted.length);
            System.arraycopy(sortedXArray, midpoint + 1,
                    rightXSorted, 0, rightXSorted.length);
            // distribute/copy the same points from leftXSorted into leftYSorted
            int index = 0;
            for (AlgyPoint point : sortedYArray) {
                for (AlgyPoint innerPoint : leftXSorted) {
                    if (innerPoint.getX() == point.getX()) {
                        leftYSorted[index] = innerPoint;
                    }
                }
                index++;
            }
            // distribute/copy the same points from rightXSorted into rightYSorted
            index = 0;
            for (AlgyPoint point : sortedYArray) {
                for (AlgyPoint innerPoint : rightXSorted) {
                    if (innerPoint.getX() == point.getX()) {
                        rightYSorted[index] = innerPoint;
                    }
                }
                index++;
            }

            AlgyPoint[] closestLeft = closestPair(leftXSorted, leftYSorted);
            AlgyPoint[] closestRight = closestPair(rightXSorted, rightYSorted);

            double distanceLeft = getDistance(closestLeft[0], closestLeft[1]);
            double distanceRight = getDistance(closestRight[0], closestRight[1]);

            double distance = Math.min(distanceLeft, distanceRight);
            double distanceSquared = Math.pow(distance, 2);

            int middlePointX = sortedXArray[midpoint].getX();

            ArrayList<AlgyPoint> slab = new ArrayList<>();
            for (AlgyPoint point : sortedYArray) {
                if (Math.abs(point.getX()) > (middlePointX - distance) ||
                        Math.abs(point.getX()) < (middlePointX + distance)) {
                    slab.add(point);
                }
            }
        }

        AlgyPoint[] temp = new AlgyPoint[5];
        return temp;
    }

    private double getDistance(AlgyPoint a, AlgyPoint b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) +
                Math.pow((b.getY() - a.getY()), 2));
    }
}
