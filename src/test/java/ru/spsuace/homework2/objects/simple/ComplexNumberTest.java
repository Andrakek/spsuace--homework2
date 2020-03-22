package ru.spsuace.homework2.objects.simple;

import org.junit.Test;

import static org.junit.Assert.*;

import ru.spsuace.homework2.objects.simple.ComplexNumber;

public class ComplexNumberTest {
    @Test
    public void ComplexNumber() {
        assertEquals("-9.0i", new ComplexNumber(0, -9).toString());
    }
}