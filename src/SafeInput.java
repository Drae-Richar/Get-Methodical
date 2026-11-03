import java.util.Scanner;

public class SafeInput {
    /**
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        while (true) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                int value = pipe.nextInt();
                pipe.nextLine();
                return value;
            }
            pipe.nextLine();
            System.out.println("That is not a valid integer. Please try again.");
        }
    }

    public static double getDouble(Scanner pipe, String prompt) {
        while (true) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                double value = pipe.nextDouble();
                pipe.nextLine();
                return value;
            }
            pipe.nextLine();
            System.out.println("That is not a valid number. Please try again.");
        }
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        if (low > high) {
            throw new IllegalArgumentException("low must be less than or equal to high");
        }
        while (true) {
            int value = getInt(pipe, prompt + " [" + low + " - " + high + "]");
            if (value >= low && value <= high) {
                return value;
            }
            System.out.println("Please enter a value from " + low + " to " + high + ".");
        }
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        if (low > high) {
            throw new IllegalArgumentException("low must be less than or equal to high");
        }
        while (true) {
            double value = getDouble(pipe, prompt + " [" + low + " - " + high + "]");
            if (value >= low && value <= high) {
                return value;
            }
            System.out.println("Please enter a value from " + low + " to " + high + ".");
        }
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        while (true) {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                return true;
            }
            if (response.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please enter Y or N.");
        }
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        while (true) {
            System.out.print("\n" + prompt + ": ");
            String response = pipe.nextLine();
            if (response.matches(regEx)) {
                return response;
            }
            System.out.println("Input did not match the required format. Please try again.");
        }
    }

    public static void prettyHeader(String msg) {
        if (msg.length() > 54) {
            throw new IllegalArgumentException("message must be 54 characters or fewer");
        }
        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();

        int padding = 54 - msg.length();
        int leftPadding = padding / 2;
        int rightPadding = padding - leftPadding;
        System.out.print("***");
        for (int i = 0; i < leftPadding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightPadding; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
