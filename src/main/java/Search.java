import java.util.Scanner;

public class Search extends RomanNum {
    static char operation;
    static char[] charArray;
    static Scanner scan = new Scanner(System.in);

    public static void searchOperator() {
        System.out.println("Enter two-part arithmetic expression:");
        String userInput = scan.nextLine().replaceAll("\\s+", "");
        charArray = new char[userInput.length()];
        for (int i = 0; i < userInput.length(); i++) {
            charArray[i] = userInput.charAt(i);
            if (charArray[i] == '+') {
                operation = '+';
            }
            if (charArray[i] == '-') {
                operation = '-';
            }
            if (charArray[i] == '*') {
                operation = '*';
            }
            if (charArray[i] == '/') {
                operation = '/';
            }
        }
    }
}
