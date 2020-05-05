// Driver for Fraction class
import java.util.Scanner;

public class FractionDriver {
    public static void main(String[] args) {
        System.out.println("Welcome to the Fraction Calculator!");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b where a and b are both integers.");
        System.out.println("-------------------------------");
        System.out.println();

        Scanner kb = new Scanner(System.in);
        // Initialize done to false
        boolean done = false;
        while (!done) {
            System.out.print("Please enter an operation (+, -, *, /, = or Q to Quit): ");
            String operation = getOperation(kb);
            // If user quits, exit
            if (operation.equals("Q") || operation.equals("q")) {
                done = true;
                break;
            }
            // Get fractions from user
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            Fraction f1 = getFraction(kb);
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            Fraction f2 = getFraction(kb);
            
            // Assign operations to the corresponding methods
            switch (operation) {
                case "+":
                    Fraction addition = f1.add(f2);
                    addition.toLowestTerms();
                    System.out.println(f1 + " + " + f2 + " is " + addition);
                    break;
                case "-":
                    Fraction subtraction = f1.subtract(f2);
                    subtraction.toLowestTerms();
                    System.out.println(f1 + " - " + f2 + " is " + subtraction);
                    break;
                case "*":
                    Fraction multiplication = f1.multiply(f2);
                    multiplication.toLowestTerms();
                    System.out.println(f1 + " * " + f2 + " is " + multiplication);
                    break;
                case "/":
                    Fraction division = f1.divide(f2);
                    division.toLowestTerms();
                    System.out.println(f1 + " / " + f2 + " is " + division);
                    break;
                case "=":
                    System.out.println(f1 + " is the same as " + f2 + ": " + f1.equals(f2));
                    break;
            }
        }
    }
    // Keep prompting user for operation while there is no operation selected (else)
    public static String getOperation(Scanner kb) {
        String input = kb.nextLine();
        // while invalid operation, print invalid
        while (!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/") && !input.equals("Q") && !input.equals("q")) {
            System.out.print("Invalid input. Please enter an operation (+, -, *, /, = or Q to Quit): ");
            input = kb.nextLine();
        }
        return input;
    }
    // Returns if fraction is valid or not
    public static boolean validFraction(String input) {
        // negative sign can only be at front (remove it if there is one)
        // if there is neg sign at 0, remove it
        if (input.indexOf("-") == 0)
        {
            input = input.substring(1);
        }
        // if there is neg sign anywhere else, return false (not a valid frac)
        else if (input.indexOf("-") > 0) {
            return false;
        }
        // If there is no "/" character, then every character in the string must be a number
        if (input.indexOf("/") == -1) {
            // if every char is a number, return true;
            if (input.matches("[0-9]+")) {
                return true;
            }
            return false;
        }
        // If there is a "/" character, create substrings for the numerator and denominator.
        if (input.indexOf("/") >= 0) {
            // Isolate numerator
            String numTemp = input.substring(0, input.indexOf("/"));
            // Isolate denominator
            String denTemp = input.substring(input.indexOf("/") + 1);
            // Both substrings must be non-empty.
            if (numTemp.equals("") || denTemp.equals("")){
                return false;
            }
            // Both must be entirely made of numbers.
            if (numTemp.matches("[0-9]+") && denTemp.matches("[0-9]+")) {
                // The denominator cannot be "0".
                if (!denTemp.equals("0")) {
                    return true;
                }
            }
        }
        return false;
    }
    // Prompts user for valid fractions and returns Fraction
    public static Fraction getFraction(Scanner kb) {
        String frac = kb.nextLine();
        // while fraction is not valid, keep prompting and print invalid
        while (!validFraction(frac)) {
            System.out.print("Invalid input. Please enter a fraction (a/b) or integer (a): ");
            frac = kb.nextLine();
        }
        int num = 0;
        int den = 0;
        // If there is a "/" character, create substrings for the numerator and denominator.
        if (frac.indexOf("/") >= 0) {
            // Isolate numerator
            num = Integer.parseInt(frac.substring(0, frac.indexOf("/")));
            // Isolate denominator
            den = Integer.parseInt(frac.substring(frac.indexOf("/") + 1));
        }
        // If there is NO "/" character
        if (frac.indexOf("/") == -1) {
            num = Integer.parseInt(frac);
            den = 1;
        }
        return new Fraction(num, den);
    }
}