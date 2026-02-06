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
        System.out.println("Test 1: 16/1= " + a);

        // ---------------- Test Case 2: Addition ----------------
        // Condition: add a fraction to a whole number
        Fraction b = new Fraction(3,5).add(new Fraction(7)); // 3/5 + 7 = 38/5
        System.out.println("Test 2: (3/5 + 7)= " + b);

        // ---------------- Test Case 3: Division ----------------
        // Condition: divide a fraction by another fraction
        Fraction numerator1 = new Fraction(6,7);   // 6/7
        Fraction denominator1 = new Fraction(3,4); // 3/4
        Fraction divisionResult = numerator1.divide(denominator1); // (6/7) ÷ (3/4) = 24/21 = 8/7
        System.out.println("Test 3: (6/7 ÷ 3/4)= " + divisionResult);

        // ---------------- Test Case 4: Multiplication ----------------
        // Condition: multiply two different fractions
        Fraction factor1 = new Fraction(2,5);   // 2/5
        Fraction factor2 = new Fraction(7,3);   // 7/3
        Fraction multiplicationResult = factor1.multiply(factor2); // (2/5) * (7/3) = 14/15
        System.out.println("Test 4: (2/5 * 7/3)= " + multiplicationResult);


        // ---------------- Test Case 5: Subtraction ----------------
        // Condition: subtract fractions
        Fraction f1 = new Fraction(5,6);
        Fraction f2 = new Fraction(2,3);
        System.out.println("Test 5: (5/6 - 2/3)= " + f1.subtract(f2)); // 1/6

        // ---------------- Test Case 6: Negate ----------------
        // Condition: negation of fraction
        Fraction f3 = new Fraction(-3,4);
        System.out.println("Test 6: -3/4 negated= " + f3.negate()); // 3/4

        // ---------------- Test Case 7: Power ----------------
        // Condition: positive, zero, negative exponent
        Fraction f4 = new Fraction(2,3);
        System.out.println("Test 7a: (2/3 ^ 3)= " + f4.pow(3)); // 8/27
        System.out.println("Test 7b: (2/3 ^ 0)= " + f4.pow(0)); // 1
        System.out.println("Test 7c: (2/3 ^ -2)= " + f4.pow(-2)); // 9/4

        // ---------------- Test Case 8: Special case NaN ----------------
        // Condition: 0/0
        Fraction nan = new Fraction(0,0);
        System.out.println("Test 8: (0/0)= " + nan);

        // ---------------- Test Case 9: Special case Infinity ----------------
        // Condition: positive numerator / 0 denominator
        Fraction inf = new Fraction(7,0);
        System.out.println("Test 9: (7/0)= " + inf);

        // ---------------- Test Case 10: Special case -Infinity ----------------
        // Condition: negative numerator / 0 denominator
        Fraction negInf = new Fraction(-6,0);
        System.out.println("Test 10: (-6/0)= " + negInf);

        // ---------------- Test Case 11: Zero fraction ----------------
        // Condition: 0 numerator / non-zero denominator
        Fraction zero = new Fraction(0,5);
        System.out.println("Test 11: (0/5)= " + zero);

        // ---------------- Test Case 12: Reduce fraction ----------------
        // Condition: numerator and denominator have common factor
        Fraction reduce = new Fraction(8,12); // should reduce to 2/3
        System.out.println("Test 12: (8/12 reduction)= " + reduce);

        // ---------------- Test Case 12: Complex operations ----------------
        // Condition: multiple operations combined
        Fraction complex = new Fraction(1,2)
                            .add(new Fraction(1,3))
                            .multiply(new Fraction(3,4))
                            .subtract(new Fraction(1,6))
                            .divide(new Fraction(2));
        System.out.println("Test 12: (1/2 + 1/3 * 3/4 -1/6)/2 =" + complex);
    }
}
