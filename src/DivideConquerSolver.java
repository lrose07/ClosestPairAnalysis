import java.util.ArrayList;
import java.util.Arrays;

class DivideConquerSolver {

    private AlgyPoint[] allPoints;
    private AlgyPoint[] currentClosestPair = new AlgyPoint[2];
    private AlgyPoint[] closestPair;
    private double currentSmallestDistance;
    private int recurseCount = 0;

    private AlgyPoint[] leftXSorted;
    private AlgyPoint[] rightXSorted;

    private AlgyPoint[] leftYSorted;
    private AlgyPoint[] rightYSorted;

    BruteForceSolver bfSolver = new BruteForceSolver();

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

        //System.out.println("sorted x array [0]: " + xSorted[0]);
        currentSmallestDistance = getDistance(xSorted[0], xSorted[1]);
        closestPair(xSorted, ySorted);

        System.out.println("\nSmallest distance: " + currentSmallestDistance);
        System.out.println("P1: " + currentClosestPair[0]);
        System.out.println("P2: " + currentClosestPair[1]);
    }

    double closestPair(AlgyPoint[] sortedXArray, AlgyPoint[] sortedYArray) {
        if (sortedXArray.length <= 3) {
            double tempDistance = currentSmallestDistance;

            for (int i = 0; i < sortedXArray.length - 1; i++) {
                tempDistance = getDistance(sortedXArray[i], sortedXArray[i+1]);
                if (tempDistance < currentSmallestDistance) {
                    currentSmallestDistance = tempDistance;
                    currentClosestPair[0] = sortedXArray[i];
                    currentClosestPair[1] = sortedXArray[i+1];
                }
            }

            System.out.println("Temp distance: " + tempDistance);

            return tempDistance;

        } else {
            System.out.println((char)27 + "[31m" + "\nNew recurse\n" + (char)27 + "[0m");

            // copy sortedX into left and right
            leftXSorted = new AlgyPoint[sortedXArray.length / 2];
            rightXSorted = new AlgyPoint[sortedXArray.length / 2];
            System.arraycopy(sortedXArray, 0,
                    leftXSorted, 0, leftXSorted.length);
            System.arraycopy(sortedXArray, (sortedXArray.length / 2),
                    rightXSorted, 0, rightXSorted.length);

            for (AlgyPoint p : leftXSorted) {
                System.out.println("left X sorted: " + p);
            }
            System.out.println();
            for (AlgyPoint p : rightXSorted) {
                System.out.println("right X sorted: " + p);
            }

            // copy sortedY into left and right, matching sortedX arrays
            leftYSorted = new AlgyPoint[sortedXArray.length / 2];
            rightYSorted = new AlgyPoint[sortedXArray.length / 2];

            int indexX = 0, indexY = 0;
            for (AlgyPoint point : sortedYArray) {
                for (AlgyPoint innerPoint : leftXSorted) {
                    if ((innerPoint.getX() == point.getX()) && (innerPoint.getY() == point.getY())) {
                        leftYSorted[indexX] = innerPoint;
                        indexX++;
                    }
                }

                for (AlgyPoint innerPoint : rightXSorted) {
                    if ((innerPoint.getX() == point.getX()) && (innerPoint.getY() == point.getY())) {
                        rightYSorted[indexY] = innerPoint;
                        indexY++;
                    }
                }
            }

            System.out.println();
            for (AlgyPoint p : leftXSorted) {
                System.out.println("LXS: " + p);
            }
            System.out.println();
            for (AlgyPoint p : rightXSorted) {
                System.out.println("RXS: " + p);
            }
            System.out.println();
            for (AlgyPoint p : leftYSorted) {
                System.out.println("LYS: " + p);
            }
            System.out.println();
            for (AlgyPoint p : rightYSorted) {
                System.out.println("RYS: " + p);
            }

            closestPair(rightXSorted, rightYSorted);
            closestPair(leftXSorted, leftYSorted);

        }
        return 0;
    }

    private double getDistance(AlgyPoint a, AlgyPoint b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) +
                Math.pow((b.getY() - a.getY()), 2));
    }
}
