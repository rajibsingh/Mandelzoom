package com.sepoysoftware.mandelzoom;

public class ComplexNumber {
    private double real;
    private double imaginary;
    private double size;

    /** Need to comment this code **/
    public ComplexNumber() {
        real = 0d;
        imaginary = 0d;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(ComplexNumber num) {
        this.real = this.real + num.getReal();
        this.imaginary = this.imaginary + num.getImaginary();
    }

    public double getSize()
    {
        size = Math.sqrt(real * real + imaginary * imaginary);
        return size;
    }

    public void square()
    {
        // need to use a placeholder to hold the real because I use
        // the real at the time to calculate the imaginary
        double tmpReal = real * real - imaginary * imaginary;
        imaginary = 2 * real * imaginary;
        real = tmpReal;
    }

    public ComplexNumber copy()
    {
        return new ComplexNumber(this.getReal(), this.getImaginary());
    }


    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public boolean equals(Object obj)
    {
        ComplexNumber cmp = (ComplexNumber) obj;
        return (cmp instanceof ComplexNumber
                && this.real == cmp.getReal()
                && this.imaginary == cmp.getImaginary());
    }

    public String toString()
    {
        return new String(this.getReal() + " " + this.getImaginary() + "i");
    }
}
