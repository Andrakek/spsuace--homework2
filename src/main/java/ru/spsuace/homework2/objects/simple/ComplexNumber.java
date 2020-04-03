package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {

    private final double real;
    private final double imaginary;

    public ComplexNumber(double realHalf, double imaginaryHalf) {
        this.real = realHalf;
        this.imaginary = imaginaryHalf;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public String toString() {
        if (real < 0) {
            if (imaginary < 0) {
                return real + String.valueOf(imaginary) + "i";
            } else if (imaginary > 0) {
                return "-" + real + "+" + imaginary + "i";
            } else {
                return String.valueOf(real);
            }
        } else if (real > 0) {
            if (imaginary > 0) {
                return real + "+" + imaginary + "i";
            } else if (imaginary == 0) {
                return String.valueOf(real);
            } else {
                return real + String.valueOf(imaginary) + "i";
            }
        } else {
            if (imaginary > 0) {
                return imaginary + "i";
            } else if (imaginary < 0) {
                return imaginary + "i";
            } else {
                return "0";
            }
        }
    }

    public static ComplexNumber complexMult(ComplexNumber numb1, ComplexNumber numb2) {
        return new ComplexNumber((numb1.real * numb2.real) - (numb1.imaginary * numb2.imaginary), (numb1.real * numb2.imaginary) + (numb1.imaginary * numb2.real));
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return (Math.abs(this.real - ((ComplexNumber) o).real) == 1e-5 || Math.abs(this.imaginary - ((ComplexNumber) o).imaginary) == 1e-5);
    }

    public double vector() {
        return Math.abs(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }
}