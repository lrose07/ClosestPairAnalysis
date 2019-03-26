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

    /**
     * Executes on program run
     * @param args input parameter flags: brute, divide, or both
     */
    public static void main(String[] args) {

        String input = getInput();

        if (args[0].compareToIgnoreCase("brute") == 0) {
            new BruteForceSolver(input);
        } else if (args[0].compareToIgnoreCase("divide") == 0) {
            new DivideConquerSolver(input);
        } else if (args[0].compareToIgnoreCase("both") == 0) {
            new BruteForceSolver(input);
            System.out.println();
            new DivideConquerSolver(input);
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
}
