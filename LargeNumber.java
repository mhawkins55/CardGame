package phase2;


/************************************************************
 * C211 Fall 2023
 * Project Phase 2
 * Authors: Dana Vrajitoru
 * Class: LargeNumber
 * Implements an integer number of an unlimited size and 
 * a few useful arithmetic operations.
 ************************************************************/


import java.util.ArrayList; // import the ArrayList class

// A class designed to store large integers in an array called number
// with the sign stored in the attribute sign.
public class LargeNumber implements Comparable<LargeNumber> {

    ArrayList<Integer> number;
    int sign;

    // Default constructor: initialize as 0
    public LargeNumber() {
        number = new ArrayList<Integer>(1);
        number.add(0);
        sign = 1; // positive
    }

    // Constructor with a given integer
    public LargeNumber(int n) {
        init(n);
    }

    // Initialize the object based on converting an integer to decimals
    public void init(int n) {
        if (n < 0) {
            n = -n; // store the absolute value in number
            sign = -1;
        } else
            sign = 1;
        if (number != null)
            number.clear(); // Clear existing data if any
        else
            number = new ArrayList<Integer>(0); // create an empty array

        // If n is 0 the while loop will not store anything in the array
        if (n == 0)
            number.add(0);
        
        // Convert the n to decimals and add it to the array one by one
        while (n > 0) {
            int dec = n % 10;
            number.add(dec);
            n = n / 10;
        }
    }

    // copy constructor
    public LargeNumber(LargeNumber other) {
        init(other);
    }

    // Initialize the object with a copy of another object
    public void init(LargeNumber other) {
        sign = other.sign;

        if (number != null)
            number.clear(); // Clear existing data if any

        number = new ArrayList<Integer>(0);

        // copy them manually
        for (Integer i : other.number)
            number.add(i);

        // use copy from Collections - something wrong with the size
        // Collections.copy(number, other.number);
    }
    
    // find out the number of digits
    public int getSize() {
        return number.size();
    }
    
    // find out the sign
    public int getSign() {
        return sign;
    }
    
    // overriding the toString() method
    public String toString() {
        String result = "";
        for (Integer i : number)
            result = "" + i + result; // add each new digit at the front
        if (sign < 0) // add the sign at the front
            result = "-" + result;
        return result;
    }

    
    // Convert to an integer
    public int toInt() {
        int wholeNumber = 0;

        for (int i = this.getSize() - 1; i >= 0; i--) {
            wholeNumber = wholeNumber * 10 + number.get(i);
        }
        return wholeNumber;
    }
    
    // Check if the number is equal to 0.
    public boolean isZero() {
        return getSize() == 1 && number.get(0) == 0;
    }
    
    // Addition Function (Team 1)
    public void add(LargeNumber other) {
        // If both numbers are positive or both negative, perform addition
        if (this.sign == other.sign) {
            int carry = 0;
            int maxSize = Math.max(this.getSize(), other.getSize());
            
            for (int i = 0; i < maxSize || carry != 0; i++) {
                int digitSum = carry;
                if (i < this.getSize())
                    digitSum += this.number.get(i);
                if (i < other.getSize())
                    digitSum += other.number.get(i);

                if (i < this.getSize())
                    this.number.set(i, digitSum % 10);
                else
                    this.number.add(digitSum % 10);

                carry = digitSum / 10;
            }
        } else {
            // If signs are different, perform subtraction
            if (this.sign < 0) {
                this.sign = 1;
                this.subtract(other);
                this.sign = -1;
            } else {
                other.sign = 1;
                this.subtract(other);
                other.sign = -1;
            }
        }
    }

    // Function allowing us to sort an array of large numbers
    @Override
    public int compareTo(LargeNumber o) {
        // TODO Auto-generated method stub
        return 0;
    }

    // Team 6
    public LargeNumber(String n) {
    }

    // Team 6
    public void init(String n) {
    }
    
    // Team 2
    public void subtract(LargeNumber other) {
    }
    
    // Team 4 
    public void multiply(LargeNumber other) {   
    }
    
    // Team 5
    public void divide(LargeNumber other) {
    }
    
    // Team 7
    public void percent(LargeNumber other) {
    }
    
    // Team 8
    public void power(LargeNumber other) {
    }
}
