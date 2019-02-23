import java.util.ArrayList;

class BruteForceSolver {

    //private ArrayList<AlgyPoint> allPoints = new ArrayList<>();
    private AlgyPoint[] allPoints;

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

        for (AlgyPoint p : allPoints) {
            System.out.println(p.toString());
        }
    }
}
