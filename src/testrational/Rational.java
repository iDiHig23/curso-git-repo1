/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrational;

/**
 *
 * @author Usuario
 */
public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational(){
        numerator=1;
        denominator=1;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    @Override
    public int hashCode(){
        int hash= 7;
        return hash;
    }

//    public boolean equals(Rational r){
//        return(numerator==r.numerator && denominator==r.denominator);
//    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rational other = (Rational) obj;
        if (this.numerator != other.numerator) {
            return false;
        }
        return this.denominator == other.denominator;
    }

//suma resta multiplicar dividir    todo tanto con forma objeto como en static
//public simplify en modo objeto con mcm -> public void Rational r.simplify(); [r ahora significa que es el simplificador]  o Rational result=r.simplify();
public void simplify() {
    int gcd = 0; // Initialize the greatest common divisor
    
    // Find the greatest common divisor (GCD) of numerator and denominator
    for (int i = 1; i <= Math.min(numerator, denominator); i++) {
        if (numerator % i == 0 && denominator % i == 0) {
            gcd = i; // Update the gcd if 'i' is a common divisor
        }
    }
    
    // Simplify the fraction by dividing both numerator and denominator by the GCD
    setNumerator(numerator / gcd);
    setDenominator(denominator / gcd);
}

    
    public void add(Rational r) {
        int numer=(numerator*r.numerator)+(denominator*r.denominator);
        int denom=(denominator*r.denominator);
        
        setNumerator(numer);
        setDenominator(denom);
        simplify();
    }
    public static Rational add(Rational r1, Rational r2){
        int numer=(r1.numerator*r2.numerator)+(r1.denominator*r2.denominator);
        int denom=(r1.denominator*r2.denominator);
        
        Rational result = new Rational(numer, denom);
        result.simplify();
        return result;
    }
    
    public void substract(Rational r){
        int numer=(numerator*r.numerator)-(denominator*r.denominator);
        int denom=(denominator*r.denominator);
        
        setNumerator(numer);
        setDenominator(denom);
        simplify();
    }
    public static Rational substract(Rational r1, Rational r2){
        int numer=(r1.numerator*r2.numerator)+(r1.denominator*r2.denominator);
        int denom=(r1.denominator*r2.denominator);
        
        Rational result = new Rational(numer, denom);
        result.simplify();
        return result;
    }
    
    public void multiply(Rational r){
        numerator*=r.numerator;
        denominator*=r.denominator;
        
        simplify();
    }
    public static Rational multiply(Rational r1, Rational r2){
        int numer = r1.numerator * r2.numerator;
        int denom = r1.denominator * r2.denominator;
        
        Rational result = new Rational(numer, denom);
        result.simplify();
        return result;
    }
    
    public void divide(Rational r){
        if (r.denominator == 0 || denominator == 0) {
            System.out.println("Division by zero is not allowed.");
        } else {
            int numer = numerator * r.numerator;
            int denom = denominator * r.denominator;

            setNumerator(numer);
            setDenominator(denom);
            simplify();
        }
    }
    public static Rational divide(Rational r1, Rational r2){
        if (r1.denominator == 0 || r2.denominator == 0) {
            System.out.println("Division by zero is not allowed.");
            return null; // Or handle the exception according to your application's logic
        } else {
            int numer = r1.numerator * r2.numerator;
            int denom = r1.denominator * r2.denominator;

            Rational result = new Rational(numer, denom); // Create a new Rational object for the result
            result.simplify(); // Simplify the result
            return result;
        }
    }

    
    @Override
    public String toString() {
        return numerator+"/"+denominator;
    }
}
