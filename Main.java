/*************************************************************************
* Assignment II for CSCI 271-001 Spring 2026
*
* Author: Mason Snyder
* Course: CSCI 271
* OS: Windows 11 Build 26100.7623
* Compiler: javac 25.0.1
* Date: February 6, 2026
*
* Purpose:
* This program tests the Fraction class by creating instances and performing
* arithmetic operations. It demonstrates correct handling of normal fractions,
* Infinity, -Infinity, and NaN.
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
*   instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
*   or any unauthorized sources, including the Internet.
* - Any external sources used have been properly cited.
* - I have not attempted to interfere with the grading code.
*
* MasonSnyder
********************************************************************/

public class Main
{
    /***************************** main *****************************
    * Description: Tests the Fraction class with multiple test cases,
    *              including normal fractions, whole numbers, zero,
    *              negative numbers, and special cases: Infinity, -Infinity, NaN.
    *
    * Parameters:
    *   args (input) – command line arguments (not used)
    *
    * Pre: Fraction class is implemented and compiled
    * Post: Prints the results of all test cases to standard output
    *
    * Returns: none
    * Called by: Java runtime
    * Calls: Fraction class methods
    ********************************************************************/
public static void main(String[] args)
    {
        System.out.println("=== Fraction Class Test Cases ===\n");

        // ---------------- Test Case 1: Whole number fraction ----------------
        // Condition: fraction created from a single integer
        Fraction a = new Fraction(16); // 16/1
        System.out.println("Test 1 (Whole number 16): " + a);

        // ---------------- Test Case 2: Addition ----------------
        // Condition: add a fraction to a whole number
        Fraction b = new Fraction(3,5).add(new Fraction(7)); // 3/5 + 7 = 38/5
        System.out.println("Test 2 (3/5 + 7): " + b);

        // ---------------- Test Case 3: Multiplication and Division ----------------
        // Condition: multiply and divide fractions
        Fraction c = new Fraction(6,7); // 6/7
        Fraction result = c.multiply(a.divide(b)); // 6/7 * (16 / 38/5) = 240/133
        System.out.println("Test 3 (6/7 * (16 / (3/5 + 7))): " + result);

        // ---------------- Test Case 4: Subtraction ----------------
        // Condition: subtract fractions
        Fraction f1 = new Fraction(5,6);
        Fraction f2 = new Fraction(2,3);
        System.out.println("Test 4 (5/6 - 2/3): " + f1.subtract(f2)); // 1/6

        // ---------------- Test Case 5: Negate ----------------
        // Condition: negation of fraction
        Fraction f3 = new Fraction(-3,4);
        System.out.println("Test 5 (-3/4 negated): " + f3.negate()); // 3/4

        // ---------------- Test Case 6: Power ----------------
        // Condition: positive, zero, negative exponent
        Fraction f4 = new Fraction(2,3);
        System.out.println("Test 6a (2/3 ^ 3): " + f4.pow(3)); // 8/27
        System.out.println("Test 6b (2/3 ^ 0): " + f4.pow(0)); // 1
        System.out.println("Test 6c (2/3 ^ -2): " + f4.pow(-2)); // 9/4

        // ---------------- Test Case 7: Special case NaN ----------------
        // Condition: 0/0
        Fraction nan = new Fraction(0,0);
        System.out.println("Test 7 (0/0 → NaN): " + nan);

        // ---------------- Test Case 8: Special case Infinity ----------------
        // Condition: positive numerator / 0 denominator
        Fraction inf = new Fraction(7,0);
        System.out.println("Test 8 (7/0 → Infinity): " + inf);

        // ---------------- Test Case 9: Special case -Infinity ----------------
        // Condition: negative numerator / 0 denominator
        Fraction negInf = new Fraction(-6,0);
        System.out.println("Test 9 (-6/0 → -Infinity): " + negInf);

        // ---------------- Test Case 10: Zero fraction ----------------
        // Condition: 0 numerator / non-zero denominator
        Fraction zero = new Fraction(0,5);
        System.out.println("Test 10 (0/5 → 0): " + zero);

        // ---------------- Test Case 11: Reduce fraction ----------------
        // Condition: numerator and denominator have common factor
        Fraction reduce = new Fraction(8,12); // should reduce to 2/3
        System.out.println("Test 11 (8/12 → reduced 2/3): " + reduce);

        // ---------------- Test Case 12: Complex operations ----------------
        // Condition: multiple operations combined
        Fraction complex = new Fraction(1,2)
                            .add(new Fraction(1,3))
                            .multiply(new Fraction(3,4))
                            .subtract(new Fraction(1,6))
                            .divide(new Fraction(2));
        System.out.println("Test 12 (Complex operations): (1/2 + 1/3 * 3/4 -1/6)/2" + complex);

        System.out.println("\n=== End of Test Cases ===");
    }
}
