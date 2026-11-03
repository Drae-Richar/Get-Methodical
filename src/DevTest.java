import java.util.Scanner;

public class DevTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        SafeInput.prettyHeader("SafeInput Test");
        String text = SafeInput.getNonZeroLenString(in, "Enter your username" +
                "");
        System.out.println("Name: " + text);
        int integer = SafeInput.getInt(in, "Enter any number");
        System.out.println("Favorite Number: " + integer);
        double decimal = SafeInput.getDouble(in, "Enter any double");
        System.out.println("Double: " + decimal);
        BirthDateTime.promptForBirthDateTime(in);
        double rangedDouble = SafeInput.getRangedDouble(in, "Enter a price", 0.5, 10.0);
        System.out.println("Checkout: " + rangedDouble);
        boolean confirmed = SafeInput.getYNConfirm(in, "Y");
        System.out.println("Confirmed: " + confirmed);
        String regex = SafeInput.getRegExString(in, "Enter three letters", "^[A-Za-z]{3}$");
        System.out.println("SSN: " + regex);
    }
}
