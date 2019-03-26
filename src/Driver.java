import java.util.Scanner;

public class Driver {

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
