import java.util.Random;
import java.util.Scanner;

/**
 * This program solves the closest pair problem by both brute force and divide
 * and conquer, and outputs the time it takes to perform each. 
 *
 * @author Lauren Rose
 * @version v0.1
 *
 * Radford University
 * Department of Information Technology
 * ITEC 360 - Data Structures and Analysis of Algorithms
 */
public class Driver {

    private static String input;

    /**
     * Executes on program run
     * @param args input parameter flags: brute, divide, or both
     */
    public static void main(String[] args) {

        if (args[0].equals("-dev")) {
            Scanner scan = new Scanner(System.in);
            System.out.println("How many points: ");
            int pointsCount = scan.nextInt();
            System.out.println("How many runs: ");
            int runCount = scan.nextInt();

            //String input = getInput();
            for (int i = 0; i < runCount; i++) {
                randomPointGenerator(pointsCount);
                new BruteForceSolver(input);
                System.out.println();
                new DivideConquerSolver(input);
            }
        } else {
            if (args[0].compareToIgnoreCase("brute") == 0) {
                new BruteForceSolver(getInput());
            } else if (args[0].compareToIgnoreCase("divide") == 0) {
                new DivideConquerSolver(getInput());
            } else if (args[0].compareToIgnoreCase("both") == 0) {
                new BruteForceSolver(getInput());
                System.out.println();
                new DivideConquerSolver(getInput());
            }
        }
    }

    /**
     * Grabs input from stdin and builds a string with the contents
     * @return string from input file
     */
    private static String getInput() {
        StringBuilder inputStream = new StringBuilder();

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            inputStream.append(scan.nextLine());
            inputStream.append(" ");
        }
        scan.close();

        return inputStream.toString();
    }

    private static void randomPointGenerator(int points) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        sb.append(points);
        sb.append("\n");

        for (int i = 0; i < points; i++) {
            sb.append(rand.nextInt(150000));
            sb.append(" ");
            sb.append(rand.nextInt(150000));
            sb.append("\n");
        }

        input = sb.toString();
    }
}
