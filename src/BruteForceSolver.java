class BruteForceSolver {

    private AlgyPoint[] closestPair;

    BruteForceSolver(String inputStream) {
        parseInput(inputStream);
    }

    private void parseInput(String s) {
        String[] allInputNums = s.split("\\s+");
        int countOfPoints = Integer.parseInt(allInputNums[0]);

        AlgyPoint[] allPoints = new AlgyPoint[countOfPoints];

        for (int i = 1, j = 0; i < allInputNums.length; i+=2, j++) {
            int pointX = Integer.parseInt(allInputNums[i]);
            int pointY = Integer.parseInt(allInputNums[i+1]);
            allPoints[j] = new AlgyPoint(pointX, pointY);
        }

        computeClosestPair(allPoints);

        for (AlgyPoint p : closestPair) {
            System.out.println(p.toString());
        }
    }

    private double getDistance(AlgyPoint a, AlgyPoint b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) +
                Math.pow((b.getY() - a.getY()), 2));
    }

    private void computeClosestPair(AlgyPoint[] points) {
        closestPair = new AlgyPoint[2];
        double smallestDistance = getDistance(points[0], points[1]);

        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i+1; j < points.length - 1; j++) {
                double distance = getDistance(points[i], points[j]);
                if (distance < smallestDistance) {
                    smallestDistance = distance;
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }
    }
}
