package ru.spsuace.homework2.objects.simple;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте 2 любых метод (операций) над комплексными числами (на ваш выбор).
 * Одна опреация должна быть статической, другая - нет.
 */
public class ComplexNumber {

    private final double realHalf;
    private final double imaginaryHalf;

    public ComplexNumber(double realHalf, double imaginaryHalf) {
        this.realHalf = realHalf;
        this.imaginaryHalf = imaginaryHalf;
    }

    public double getRealHalf() {
        return realHalf;
    }

    public double getImaginaryHalf() {
        return imaginaryHalf;
    }

    public String toString() {

        if (realHalf != 0) {
            if (imaginaryHalf > 0) {
                return realHalf + "+" + imaginaryHalf + "i";
            } else if (imaginaryHalf == 0) {
                return String.valueOf(realHalf);
            } else if (imaginaryHalf < 0) {
                return realHalf + "-" + Math.abs(imaginaryHalf) + "i";
            }
        } else {
            if (imaginaryHalf > 0) {
                return imaginaryHalf + "i";
            } else if (imaginaryHalf == 0) {
                return "0";
            } else if (imaginaryHalf < 0) {
                return "-" + Math.abs(imaginaryHalf) + "i";
            }
        }
        return null;
    }

    public static ComplexNumber complexMult(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber complexMult = new ComplexNumber((complexNumber1.realHalf * complexNumber2.realHalf) - (complexNumber1.imaginaryHalf * complexNumber2.imaginaryHalf), (complexNumber1.realHalf * complexNumber2.imaginaryHalf) + (complexNumber1.imaginaryHalf * complexNumber2.realHalf));
        return complexMult;
    }
}