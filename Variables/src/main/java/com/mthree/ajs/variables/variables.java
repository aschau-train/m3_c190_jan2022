package com.mthree.ajs.variables;

/**
 *
 * @author augie
 *email: aschau@wiley.com
 *date: 2022.01.22
 *purpose: Demonstrate the use of variables
 */
public class variables {
    public static void main(String[] args) {
        // Declare variables to use in the examples
        int result;
        int operand1;
        int operand2;
        int operand3;
        
        // 
        // Assignment
        // 
        // Initialize result with the value of 0 by using the
        // assignment (=) operator.  The assignment operator takes
        // the value on the right and assigns it to the variable on
        // the left.
        result = 0; // now result has the value of 0
        
        // Initialize the operatnds
        operand1 = 5;
        operand2 = 7;
        
        // Assignment works with variable values as well as literal
        // values.  We'll set operand3 to the same value as operand2
        operand3 = operand2; // now both have the value 7
        
        // Addition
        //
        // Addition is a binary infix operator (not postfix or prefix)
        // It works with literals:
        result = 42 + 53; // result is now 95
        
        // It works with variables
        result = operand1 + operand2; // result is now 12
        
        // It works with a combination of literals and variables
        result = 1 + operand1; // result is now 6
        
        // You can chain addition operator together
        result = 1 + operand1 + operand2 + operand3; // result is now 20
        
        // Finally the+ += operraotr is used to add a value to a 
        // variable.  result += operand1 is equivalent to
        // result = result + operand1.
        // NOTE: the initial value of result is used to calculate the
        //       new value of result
        result = 2;  // set result to 2
        result += 4; // result is now 6 (2 + 4)
        result += operand1; // result is now 11 (6 + 5)
        
        // Subtraction
        //
        // Subtraction is a binary infix operaor.
        // It works with literals
        result = 9 - 5; // result is now 4
        
        // It works with variables
        result = operand1 - operand2; // result is now -2
        
        // it works with a combination of literals and variables
        result = 19 - operand1 - operand2 - operand3;  // result is now 0
        
        // Finally the -= operator is used to subtract a value from a 
        // variable.  result -= operand1 is equivalent to
        // result = result - operand1
        // NOTE:  the initial value of result is used to calculate the
        //        new value of result:
        result = 2; // set result to 2
        result -= 4; // result is now -2 (2 - 4)
        result -= operand1;  // result is now -7 (-2 - 5)
        
        // Multiplication
        //
        // Multiplication is a binary infix operator.  It works with
        // literals:
        result = 2 * 3; // result is now 6
        
        // It works with variables:
        result = operand1 * operand2; // result is now 35
        
        // It works with a combination of literals and variables:
        result = 2 * operand1; // result is now 10
        
        // You can chain multiplication operators together:
        result = 2 * operand1 * operand2 * operand3; // result is now 490
        
        // Finally, the *= operator is used to update the value of a variable
        // result *= operand1 is the same as result = result * operand1
        // NOTE:  the initial value of result is used to calculate the 
        //        new value of result
        result = 2; // set result to 2
        result *= 4; // result is now 8 (2 * 4)
        result *= operand1; // result is now 40 (8 * 5)
        
        // Division and Modulus
        //
        // Division is a binary infix operator.  It works with literals:
        result = 6 /3; // result is now 2
        
        // It works with variables
        result = operand1 / operand2; //result is now 0
        
        // What?  When dividing integers, integer division 
        // is used - we only get the whole number part of the
        // quotient.  In this case 7 goes into 5 0 times with a 
        // remainder of 5
        // We can use the modulus operator (%) to get the remainder:
        result = operand1 % operand2; // result is now 5
        
        // It works with a combination of lieral and variables:
        result = 20 / operand1; // result is now 4
        
        // You can chain division operators together
        result = 245/operand1/operand2/operand3; // result is now 1
        
        // Finally the /= operator is used to update the value of a variable
        // result /= operand1 is the same as result = result / operand1
        // NOTE: the initial value os result is used to calcualte the
        //       new value of result
        result = 40; // set result to 40
        result /= 4; // result is now 10 (40/4)
        result /= operand1;  // result is now 2 (10 / 5);
        result %= 2; // result is now 0 (remainder of 2 / 2 is 0)
        
    }
}
