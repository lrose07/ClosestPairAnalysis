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
class BruteForceSolver {

    private AlgyPoint[] allPoints;
    private AlgyPoint[] closestPair;

    private int numberOfInitialPoints;

    /**
     * Constructs a BruteForceSolver object that runs the brute force
     * algorithm on a set of input points
     * @param inputStream sting of points as input
     */
    BruteForceSolver(String inputStream) {

        System.out.println("*******************\nBrute Force Solver\n");

        long readStartTime = System.nanoTime();
        parseInput(inputStream);
        long readEndTime = System.nanoTime();

        System.out.println("Time to read/parse array: " + ((readEndTime - readStartTime) / 1000000) + " milliseconds");

        long computeStartTime = System.nanoTime();
        computeClosestPair(allPoints);
        long computeEndTime = System.nanoTime();

        System.out.println("Time to compute " + numberOfInitialPoints + " points: "
                + ((computeEndTime - computeStartTime) / 1000000) + " milliseconds");

        System.out.println("Closest pair: (" + closestPair[0] + ") and (" + closestPair[1] + ")");
        System.out.println("with a distance of " + getDistance(closestPair[0], closestPair[1]));
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
     * Calculates the distance between two points
     * @param a first point
     * @param b second point
     * @return distance between the points
     */
    private double getDistance(AlgyPoint a, AlgyPoint b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) +
                Math.pow((b.getY() - a.getY()), 2));
    }

    /**
     * Computes the closest two points
     * @param points list of points
     */
    private void computeClosestPair(AlgyPoint[] points) {
        closestPair = new AlgyPoint[2];
        double smallestDistance = Math.abs(getDistance(points[0], points[1]));

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double distance = Math.abs(getDistance(points[i], points[j]));
                if (distance < smallestDistance) {
                    smallestDistance = distance;
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }
    }
}
