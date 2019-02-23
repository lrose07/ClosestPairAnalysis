import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        new BruteForceSolver(getInput(args[0]));
    }

    private static String getInput(String s) {
        File file = new File(s);

        StringBuilder inputStream = new StringBuilder();

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                inputStream.append(scan.nextLine());
                inputStream.append(" ");
            }
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return inputStream.toString();
    }
}
