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
* Implements a Fraction data type for exact arithmetic using integers.
* Supports addition, subtraction, multiplication, division, negation,
* and power operations, while handling special cases: Infinity, -Infinity, and NaN.
*
* Method / Algorithm:
* Uses Euclidean algorithm (GCD) to reduce fractions to normalized form.
* Denominators are always positive, and operations return new Fraction objects.
*
* Data Structures:
* - Two integers: numerator and denominator.
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
* Mason Snyder
********************************************************************/

public class Fraction
{
    private final int numerator;   // Numerator
    private final int denominator; // Denominator

    /***************************** Fraction *****************************
    * Description: Creates a Fraction from a whole number.
    *
    * Parameters:
    *   n (input) – whole number to convert to fraction
    *
    * Pre: n is a valid integer
    * Post: Fraction created with denominator 1
    *
    * Returns: none
    * Called by: Main
    * Calls: Fraction(int, int)
    ********************************************************************/
    public Fraction(int n)
    {
        this(n, 1);
    }

    /***************************** Fraction *****************************
    * Description: Creates a Fraction with numerator and denominator,
    *              and reduces it to its normalized form.
    *
    * Parameters:
    *   n (input) – numerator
    *   d (input) – denominator
    *
    * Pre: n and d are valid integers
    * Post: Fraction is reduced and normalized; denominator >= 0
    *
    * Returns: none
    * Called by: Main, other Fraction methods
    * Calls: gcd(int, int)
    ********************************************************************/
    public Fraction(int n, int d)
    {
        if (d == 0)
        {
            numerator = n;
            denominator = 0;
        }
        else if (n == 0)
        {
            numerator = 0;
            denominator = 1;
        }
        else
        {
            int gcdValue = gcd(n, d);
            n /= gcdValue;
            d /= gcdValue;

            if (d < 0)
            {
                n = -n;
                d = -d;
            }

            numerator = n;
            denominator = d;
        }
    }

    /***************************** add *****************************
    * Description: Adds one Fraction to another Fraction.
    *
    * Parameters:
    *   f (input) – the Fraction to add
    *
    * Pre: f is a valid Fraction object
    * Post: Returns a new Fraction equal to this + f
    *
    * Returns: Added Fraction result
    * Called by: Main
    * Calls: Fraction(int, int)
    ********************************************************************/
    public Fraction add(Fraction f)
    {
        return new Fraction(
            numerator * f.denominator + f.numerator * denominator,
            denominator * f.denominator
        );
    }

    /***************************** subtract *****************************
    * Description: Subtracts one Fraction from another Fraction.
    *
    * Parameters:
    *   f (input) – the Fraction to subtract
    *
    * Pre: f is a valid Fraction object
    * Post: Returns a new Fraction equal to this - f
    *
    * Returns: Subtracted Fraction result
    * Called by: Main
    * Calls: Fraction(int, int)
    ********************************************************************/
    public Fraction subtract(Fraction f)
    {
        return new Fraction(
            numerator * f.denominator - f.numerator * denominator,
            denominator * f.denominator
        );
    }

    /***************************** multiply *****************************
    * Description: Multiplies Fraction by another Fraction.
    *
    * Parameters:
    *   f (input) – the Fraction to multiply with
    *
    * Pre: f is a valid Fraction object
    * Post: Returns a new Fraction equal to this * f
    *
    * Returns: Multiplied Fraction result
    * Called by: Main
    * Calls: Fraction(int, int)
    ********************************************************************/
    public Fraction multiply(Fraction f)
    {
        return new Fraction(
            numerator * f.numerator,
            denominator * f.denominator
        );
    }

    /***************************** divide *****************************
    * Description: Divides Fraction by another Fraction.
    *
    * Parameters:
    *   f (input) – the Fraction to divide by
    *
    * Pre: f is a valid Fraction object; f != 0 (numerator != 0)
    * Post: Returns a new Fraction equal to this / f
    *
    * Returns: Divided Fraction result
    * Called by: Main
    * Calls: Fraction(int, int)
    ********************************************************************/
    public Fraction divide(Fraction f)
    {
        return new Fraction(
            numerator * f.denominator,
            denominator * f.numerator
        );
    }

    /***************************** negate *****************************
    * Description: Negates Fraction.
    *
    * Parameters: none
    *
    * Pre: Fraction object is valid
    * Post: Returns a new Fraction equal to -this
    *
    * Returns: Negated Fraction
    * Called by: Main
    * Calls: Fraction(int, int)
    ********************************************************************/
    public Fraction negate()
    {
        return new Fraction(-numerator, denominator);
    }

    /***************************** pow *****************************
    * Description: Raises Fraction to a provided integer power.
    *
    * Parameters:
    *   n (input) – exponent (can be zero or negative)
    *
    * Pre: Fraction object is valid
    * Post: Returns a new Fraction equal to this^n
    *
    * Returns: Exponated Fraction
    * Called by: Main
    * Calls: Fraction(int, int), multiply(Fraction)
    ********************************************************************/
    public Fraction pow(int n)
    {
        if (n == 0) return new Fraction(1);

        Fraction base = this;
        int exp = n;

        if (n < 0)
        {
            base = new Fraction(denominator, numerator);
            exp = -n;
        }

        Fraction result = new Fraction(1);
        for (int i = 0; i < exp; i++)
        {
            result = result.multiply(base);
        }

        return result;
    }

    /***************************** gcd *****************************
    * Description: Computes greatest common divisor (GCD) of two integers.
    *
    * Parameters:
    *   a (input) – first integer
    *   b (input) – second integer
    *
    * Pre: a and b are valid integers
    * Post: Returns the GCD of a and b; if both are zero, returns 1
    *
    * Returns: int – GCD
    * Called by: Fraction constructor
    * Calls: none
    ********************************************************************/
    private int gcd(int a, int b)
    {
        if (a < 0) a = -a;

        while (b != 0)
        {
            int r = a % b;
            a = b;
            b = r;
        }

        if (a == 0) a = 1;

        return a;
    }

    /***************************** toString *****************************
    * Description: Converts Fraction to a string representation.
    *
    * Parameters: none
    *
    * Pre: Fraction object is valid
    * Post: Returns string as "numerator/denominator", "numerator" if
    *       denominator is 1, or special values: Infinity, -Infinity, NaN
    *
    * Returns: String
    * Called by: Main, System.out.println()
    * Calls: none
    ********************************************************************/
    @Override
    public String toString()
    {
        if (denominator == 0)
        {
            if (numerator == 0) return "NaN";
            return (numerator > 0) ? "Infinity" : "-Infinity";
        }

        if (denominator == 1) return Integer.toString(numerator);

        return numerator + "/" + denominator;
    }
}
