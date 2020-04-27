// Fraction class
import java.math.BigInteger;

public class Fraction
{
    // Two private instance variables to hold the numerator and denominator as ints
    private int num;
    private int den;
    
    // A two-parameter constructor that initializes the numerator and denominator.
    public Fraction(int numUser, int denUser)
    {
        num = numUser;
        den = denUser;
        // throw IllegalArgumentException if denominator is zero
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }
        // if den is negative, bump sign to numerator
        if (den < 0) {
            den = den * -1;
            num = num * -1;
        }
    }

    // 1 parameter constructor that initializes the object equal in value to the integer parameter.
    public Fraction(int numUser)
    {
        this(numUser, 1);
    }

    // Zero parameter constructor that initializes the object to 0, meaning the numerator is 0 and the denominator is 1
    public Fraction()
    {
        this(0, 1);
    }

    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return den;
    }

    public String toString() {
        // if den is 1, just return num
        if (den == 1) {
            return Integer.toString(num);
        }
        // otherwise return fraction in string form
        return num + "/" + den;
    }

    // result of fraction division
    public double toDouble() {
        double quotient = num / den;
        return quotient;
    }

    public Fraction add(Fraction f2) {
        // find LCM of fraction denominators
        int lcm = findLCM(f2);
        // multiply numerators by same quotient of denominator to LCM ratio
        int newNum1 = lcm / den * num;
        int newNum2 = lcm / f2.getDenominator() * f2.getNumerator();
        // Add numerators together
        int additionNums = newNum1 + newNum2;
        return new Fraction(additionNums, lcm);
    }
    
    public Fraction subtract(Fraction f2) {
        // find LCM of fraction denominators
        int lcm = findLCM(f2);
        // multiply numerators by same quotient of denominator to LCM ratio
        int newNum1 = lcm / den * num;
        int newNum2 = lcm / f2.getDenominator() * f2.getNumerator();
        // Add numerators together
        int subtractionNums = newNum1 - newNum2;
        return new Fraction(subtractionNums, lcm);
    }

    public Fraction multiply(Fraction f2) {
        // Multiply numerators together
        int productNum = num * f2.getNumerator();
        // Multiply denominators together
        int productDen = den * f2.getDenominator();
        return new Fraction(productNum, productDen);
    }
    
    public Fraction divide(Fraction f2) {
        // multiply f1 by reciprocal of f2
        int quotientNum = num * f2.getDenominator();
        int quotientDen = den * f2.getNumerator();
        return new Fraction(quotientNum, quotientDen);
    }
    
    public boolean equals(Fraction f2) {
        // find LCM of fraction denominators
        int lcm = findLCM(f2);
        // multiply numerators by same quotient of denominator to LCM ratio
        int newNum1 = lcm / den * num;
        int newNum2 = lcm / f2.getDenominator() * f2.getNumerator();
        // check if the numerators are equal
        if (newNum1 == newNum2) {
            return true;
        }
        return false;
    }
    
    public void toLowestTerms() {
        // find gcd of numerator and denominator
        int factor = gcd(num, den);
        // divide numerator by GCD
        num = num / factor;
        // divide denominator by GCD
        den = den / factor;
    }
    
    public static int gcd(int a, int b) {
        //while a and b are not zero
        while (a != 0 && b != 0) {
            // find the remainder of a divided by b
            int remainder = Math.abs(a) % Math.abs(b);
            //set a to b
            a = Math.abs(b);
            //set b to the remainder you found
            b = remainder;
        }
        // Return GCD
        return a;
    }

    private int findLCM(Fraction f2) {
        // least common multiple of denominators
        int absHigherNumber = Math.max(den, f2.getDenominator());
        int absLowerNumber = Math.min(den, f2.getDenominator());
        int lcm = absHigherNumber;
        // Increment lcm by the higher absolute value until divisible
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}