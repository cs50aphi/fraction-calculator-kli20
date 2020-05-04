// Temp driver for Fraction class
import java.util.Scanner;

public class FractionDriver {
    public static void main(String[] args) {
        System.out.println("Welcome to the Fraction Calculator!");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b where a and b are both integers.");
        System.out.println("-------------------------------");
        System.out.println();

        // Keep prompting user while no integer
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter an operation (+, -, *, /, = or Q to Quit): ");
        String operation = getOperation(kb);


        System.out.print(operation);


        // System.out.print("Den1: "); // denominator
        // int d1 = kb.nextInt();
        // System.out.print("Num2: "); // numerator
        // int n2 = kb.nextInt();
        // System.out.print("Den2: "); // denominator
        // int d2 = kb.nextInt();
        // Fraction f1 = new Fraction(n1, d1);
        // Fraction f2 = new Fraction(n2, d2);
        // System.out.println(f1 + " + " + f2 + " is " + f1.add(f2));
        // System.out.println(f1 + " - " + f2 + " is " + f1.subtract(f2));
        // System.out.println(f1 + " * " + f2 + " is " + f1.multiply(f2));
        // System.out.println(f1 + " / " + f2 + " is " + f1.divide(f2));
        // System.out.println(f1 + " is the same as " + f2 + ": " + f1.equals(f2));
    }
    // Keep prompting user while there is no operation selected (else)
    public static String getOperation(Scanner kb) {
        String input = kb.nextLine();
        // while invalid operation, print invalid
        while (!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/") && !input.equals("Q") && !input.equals("q")) {
            System.out.print("Invalid input. Please enter an operation (+, -, *, /, = or Q to Quit): ");
            input = kb.nextLine();
        }
        return input;
    }
}