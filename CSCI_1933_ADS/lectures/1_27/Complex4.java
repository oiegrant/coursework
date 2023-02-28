// Complex4.java
// Revised 9/2021

// A reasonable complex number class

// Can you explain the reasoning behind everything that is done here?

public class Complex4 {

    private double realPart = 0;  
    private double imaginaryPart = 0;

    public Complex4(double a, double b) {
        realPart = a;
        imaginaryPart = b;
    }

    public Complex4() {}  // default constructor

    // accessor methods

    public void setRealPart(double value) {
        realPart = value;
    }

    public void setImaginaryPart(double value) {
        imaginaryPart = value;
    }

    public double getRealPart() {
        return realPart;
    }
   
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    // operators

    public Complex4 addComplex(Complex4 c) {
        Complex4 result = new Complex4();
        result.setRealPart(realPart + c.getRealPart());
        result.setImaginaryPart(imaginaryPart + c.getImaginaryPart());
        return result;
    }

    public Complex4 subtractComplex(Complex4 c) {
        Complex4 result = new Complex4();
        result.setRealPart(realPart - c.getRealPart());
        result.setImaginaryPart(imaginaryPart - c.getImaginaryPart());
        return result;
    }

    public String toString() {
        return "" + realPart + "+" + imaginaryPart + "i";
    }

    public boolean equals(Object anotherObject) {
        Complex4 temp;
        boolean same = false;
        if (anotherObject instanceof Complex4) {
          temp = (Complex4) anotherObject;
          if (realPart == temp.getRealPart() &&
              imaginaryPart == temp.getImaginaryPart())
              same = true;
        }
        return same;
    }
          
}  // Complex4 class
