import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class performs a divide and conquer find of the two closest
 * points from a list of points.
 *
 * @author Lauren Rose
 * @version v0.1
 *
 * Radford University
 * Department of Information Technology
 * ITEC 360 - Data Structures and Analysis of Algorithms
 */
class DivideConquerSolver {

    private long startTimeSort;

    private AlgyPoint[] allPoints;
    private AlgyPoint[] currentClosestPair = new AlgyPoint[2];
    private double currentSmallestDistance;

    private int numberOfInitialPoints;

    private int distanceCalculations = 0;
    private int recurseCalls = 0;

    /**
     * Constructs a DivideConquerSolver object
     * @param inputStream string of points as input
     */
    DivideConquerSolver(String inputStream) {
        System.out.println("*******************\nDivide and Conquer Solver\n");
        startTimeSort = System.nanoTime();
        parseInput(inputStream);
        runAlgorithm();
    }

    /**
     * Converts string into an array of AlgyPoints
     * @param s input string
     */
    private void parseInput(String s) {
        String[] allInputNums = s.split("\\s+");
        numberOfInitialPoints = Integer.parseInt(allInputNums[0]);

        allPoints = new AlgyPoint[numberOfInitialPoints];

        for (int i = 1, j = 0; i < allInputNums.length; i+=2, j++) {
            int pointX = Integer.parseInt(allInputNums[i]);
            int pointY = Integer.parseInt(allInputNums[i+1]);
            allPoints[j] = new AlgyPoint(pointX, pointY);
        }
    }

    /**
     * Sorts points by X coordinate
     * @return array of sorted points
     */
    private AlgyPoint[] sortPointsByX() {
        AlgyPoint[] tempByX = new AlgyPoint[allPoints.length];
        System.arraycopy(allPoints, 0, tempByX, 0, allPoints.length);
        Arrays.sort(tempByX, new CompareByX());
        return tempByX;
    }

    /**
     * Sorts points by Y coordinate
     * @return array of sorted points
     */
    private AlgyPoint[] sortPointsByY() {
        AlgyPoint[] tempByY = new AlgyPoint[allPoints.length];
        System.arraycopy(allPoints, 0, tempByY, 0, allPoints.length);
        Arrays.sort(tempByY, new CompareByY());
        return tempByY;
    }

    /**
     * Launches the divide and conquer algorithm
     */
    private void runAlgorithm() {
        AlgyPoint[] xSorted = sortPointsByX();
        AlgyPoint[] ySorted = sortPointsByY();
        long endTimeSort = System.nanoTime();

        System.out.println("Time to parse/sort: " + (endTimeSort - startTimeSort) / 1000000 + " milliseconds");

        currentSmallestDistance = getDistance(xSorted[0], xSorted[1]);

        long startTimeAlgorithm = System.nanoTime();
        closestPair(xSorted, ySorted);
        long endTimeAlgorithm = System.nanoTime();

        System.out.println("Time to compute " + numberOfInitialPoints + " points: "
                + (endTimeAlgorithm - startTimeAlgorithm) / 1000000 + " milliseconds");
        System.out.println("Closest pair: (" + currentClosestPair[0] + ") and (" + currentClosestPair[1] + ")");
        System.out.println("with a distance of " + currentSmallestDistance);
        System.out.println("Algorithm made " + distanceCalculations + " distance calculations.");
        System.out.println("Algorithm made " + recurseCalls + " recursive calls.");
    }

    /**
     * Recursive method to solve closest pair problem.
     * Java implementation of algorithm
     * @param sortedXArray array of points sorted by X coordinate
     * @param sortedYArray array of the same points sorted by Y coordinate
     */
    private void closestPair(AlgyPoint[] sortedXArray, AlgyPoint[] sortedYArray) {
        recurseCalls++;
        // brute force on small data sets
        if (sortedXArray.length <= 3) {
            for (int i = 0; i < sortedXArray.length - 1; i++) {
                double tempDistance = getDistance(sortedXArray[i], sortedXArray[i+1]);
                if (tempDistance < currentSmallestDistance) {
                    currentSmallestDistance = tempDistance;
                    currentClosestPair[0] = sortedXArray[i];
                    currentClosestPair[1] = sortedXArray[i+1];
                }
            }
        } else {
            // copy sortedX into left and right
            AlgyPoint[] leftXSorted = new AlgyPoint[sortedXArray.length / 2];
            AlgyPoint[] rightXSorted = new AlgyPoint[sortedXArray.length / 2];
            System.arraycopy(sortedXArray, 0,
                    leftXSorted, 0, leftXSorted.length);
            System.arraycopy(sortedXArray, (sortedXArray.length / 2),
                    rightXSorted, 0, rightXSorted.length);

            // copy sortedY into left and right, matching sortedX arrays
            AlgyPoint[] leftYSorted = new AlgyPoint[sortedXArray.length / 2];
            AlgyPoint[] rightYSorted = new AlgyPoint[sortedXArray.length / 2];

            int lysIterator = 0, rysIterator = 0;
            for (AlgyPoint p : sortedYArray) {
                if (Arrays.asList(leftXSorted).contains(p)) {
                    leftYSorted[lysIterator] = p;
                    lysIterator++;
                } else if (Arrays.asList(rightXSorted).contains(p)) {
                    rightYSorted[rysIterator] = p;
                    rysIterator++;
                }
            }

            // recursive calls
            closestPair(rightXSorted, rightYSorted);
            closestPair(leftXSorted, leftYSorted);

            // check slab
            double midpoint = sortedXArray[sortedXArray.length / 2].getX();
            ArrayList<AlgyPoint> strip = new ArrayList<AlgyPoint>();
            for (int i = 0; i < sortedXArray.length; i++) {
                if (Math.abs(sortedXArray[i].getX() - midpoint) < currentSmallestDistance) {
                    strip.add(sortedYArray[i]);
                }
            }

            for (int i = 0; i < strip.size(); i++) {
                for (int j = i; j < 6 && j < strip.size() - 1; j++) {
                    double tempDistance = getDistance(strip.get(j), strip.get(j+1));
                    if (tempDistance < currentSmallestDistance) {
                        currentSmallestDistance = tempDistance;
                        currentClosestPair[0] = strip.get(j);
                        currentClosestPair[1] = strip.get(j+1);
                    }
                }
            }
        }
    }

    /**
     * Calculates the distance between two points
     * @param a first point
     * @param b second point
     * @return distance between the points
     */
    private double getDistance(AlgyPoint a, AlgyPoint b) {
        distanceCalculations++;
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) +
                Math.pow((b.getY() - a.getY()), 2));
    }
}
