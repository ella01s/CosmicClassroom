package functionality;

import java.io.InputStream;
import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);
    private InputHelper() {}

    public static String readLine() {
        return scanner.nextLine();
    }
    public static int readInt() {
        return scanner.nextInt();
    }
    public static double readDouble() {
        return scanner.nextDouble();
    }
    public static void closeScanner() {
        scanner.close();
    }

    // Method to set the input stream (for testing)
    public static void setInputStream(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }
}

