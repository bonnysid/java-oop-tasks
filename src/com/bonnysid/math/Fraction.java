package com.bonnysid.math;

import java.util.Objects;

public final class Fraction extends Number implements Cloneable {
    private int numerator;
    private int denominator;
    private double value;
    private boolean isAutoReduce = false;

    public Fraction(int numerator, int denominator) {
        this(numerator, denominator, false);
    }

    public Fraction(int numerator, int denominator, boolean isAutoReduce) {
        setDenominator(denominator);
        this.numerator = numerator;
        this.isAutoReduce = isAutoReduce;
        reduce();
    }


    public Fraction(String fraction) {
        this(fraction, false);
    }

    public Fraction(String fraction, boolean isAutoReduce) {
        Fraction num = translateStringToFraction(fraction);
        numerator = num.getNumerator();
        denominator = num.getDenominator();
        this.isAutoReduce = isAutoReduce;
        reduce();
    }

    public Fraction setDenominator(int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be equals zero!");
        else this.denominator = denominator;
        reduce();
        return this;
    }

    public int getDenominator() { return denominator; }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        reduce();
    }

    public boolean isAutoReduce() {
        return isAutoReduce;
    }

    public boolean isAutoReduce(boolean isAutoReduce) {
        this.isAutoReduce = isAutoReduce;
        return this.isAutoReduce;
    }

    public int getNumerator() { return numerator; }

    public Fraction plus(int num) {
        String oldFraction = this.toString();

        numerator += num * denominator;
        String notReduced = reduce().toString();

        System.out.println(oldFraction + " + " + num + " = " + (!isAutoReduce || notReduced.equals(this.toString()) ? this : notReduced + " = " + this));
        return this;
    }

    public Fraction plus(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be equals zero!");
        String oldFraction = this.toString();

        if (this.denominator != denominator) {
            this.numerator = this.numerator * denominator + numerator * this.denominator;
            this.denominator *= denominator;
        } else {
            this.numerator += numerator;
        }
        String notReduced = reduce().toString();

        System.out.println(oldFraction + " + " + numerator + "/" + denominator + " = " + (!isAutoReduce || notReduced.equals(this.toString()) ? this : notReduced + " = " + this));
        return this;
    }

    public Fraction plus(Fraction num) { return plus(num.getNumerator(), num.getDenominator()); }

    public Fraction plus(String fraction) { return plus(translateStringToFraction(fraction)); }

    public Fraction div(int num) {
        if (numerator == 0) throw new IllegalArgumentException("Denominator cannot be equals zero!");
        String oldFraction = this.toString();

        denominator *= num;
        String notReduced = reduce().toString();

        System.out.println(oldFraction + " / " + num + " = " + (!isAutoReduce || notReduced.equals(this.toString()) ? this : notReduced + " = " + this));
        return this;
    }

    public Fraction div(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be equals zero!");
        String oldFraction = this.toString();

        this.denominator *= numerator;
        this.numerator *= denominator;
        String notReduced = reduce().toString();

        System.out.println(oldFraction + " / " + numerator + "/" + denominator + " = " + (!isAutoReduce ? this : notReduced + " = " + this));
        return this;
    }

    public Fraction div(Fraction num) { return div(num.getNumerator(), num.getDenominator()); }

    public Fraction div(String fraction) { return div(translateStringToFraction(fraction)); }

    public Fraction minus(int num) {
        String oldFraction = this.toString();

        numerator -= num * denominator;
        String notReduced = reduce().toString();

        System.out.println(oldFraction + " - " + num + " = " + (!isAutoReduce || notReduced.equals(this.toString()) ? this : notReduced + " = " + this));
        return this;
    }

    public Fraction minus(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be equals zero!");
        String oldFraction = this.toString();

        if (this.denominator != denominator) {
            this.numerator = this.numerator * denominator - numerator * this.denominator;
            this.denominator *= denominator;
        } else {
            this.numerator -= numerator;
        }
        String notReduced = reduce().toString();

        System.out.println(oldFraction + " - " + numerator + "/" + denominator + " = " + (!isAutoReduce || notReduced.equals(this.toString()) ? this : notReduced + " = " + this));
        return this;
    }

    public Fraction minus(Fraction num) { return minus(num.getNumerator(), num.getDenominator()); }

    public Fraction minus(String fraction) { return minus(translateStringToFraction(fraction)); }

    public Fraction multiply(int num) {
        String oldFraction = this.toString();

        numerator *= num;
        String notReduced = reduce().toString();

        System.out.println(oldFraction + " * " + num + " = " + (!isAutoReduce || notReduced.equals(this.toString()) ? this : notReduced + " = " + this));
        return this;
    }

    public Fraction multiply(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be equals zero!");
        String oldFraction = this.toString();

        this.denominator *= denominator;
        this.numerator *= numerator;
        String notReduced = reduce().toString();

        System.out.println(oldFraction + " * " + numerator + "/" + denominator + " = " + (!isAutoReduce || notReduced.equals(this.toString()) ? this : notReduced + " = " + this));
        return this;
    }

    public Fraction multiply(Fraction num) { return div(num.getNumerator(), num.getDenominator()); }

    public Fraction multiply(String fraction) { return div(translateStringToFraction(fraction)); }

    public Fraction reduceFraction() {
        int gcf = getGCF();
        numerator /=  gcf;
        denominator /= gcf;
        return this;
    }

    /**
     * GCF - greatest common factor
     */
    private int getGCF() {
        int fisrt = numerator;
        int second = denominator;

        while (true) {
            if (fisrt > second) fisrt -= second;
            else if (fisrt < second)  second -= fisrt;
            else return fisrt;
        }
    }

    private Fraction translateStringToFraction(String fraction) {
        if (fraction.indexOf("/") != fraction.lastIndexOf("/")) throw new IllegalArgumentException("Input argument is wrong!");
        String [] strValues = fraction.split("/", 2);

        return new Fraction(Integer.parseInt(strValues[0]), Integer.parseInt(strValues[1]));
    }

    private void updateValue() { value = (double)numerator / (double)denominator; }

    private Fraction reduce() {
        updateValue();
        if (isAutoReduce) return reduceFraction();
        return this;
    }

    @Override
    public Fraction clone() {
        return new Fraction(numerator, denominator, isAutoReduce);
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long)numerator / (long)denominator;
    }

    @Override
    public float floatValue() {
        return (float)value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator &&
                denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator, value, isAutoReduce);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
