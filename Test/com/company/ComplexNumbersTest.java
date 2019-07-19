package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumbersTest {


    private ComplexNumbers x;
    private ComplexNumbers y;
    private ComplexNumbers x1;
    private ComplexNumbers y1;
    private ComplexNumbers x2;
    private ComplexNumbers y2;
    private ComplexNumbers x3;
    private ComplexNumbers y3;

    private ComplexNumbers z;

    @Before
    public void setUp() throws Exception {
        x = new ComplexNumbers(2, 3);
        y = new ComplexNumbers(-1, 2);

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void sum() {
        ComplexNumbers sum = x.sum(y);
        assertEquals(1.1, sum.getRe(),0.000001);
        assertEquals(5, sum.getIm(),0.5);
    }
/*
    @Test
    public void comparison() {
        assertTrue(x.comparison(x));
        assertEquals(true, ComplexNumbers.comparison(x, x));
        assertEquals(false, ComplexNumbers.comparison(x, y));
        assertNotEquals(true, ComplexNumbers.comparison(x, y));
    }

    @Test
    public void sub() {
        z = new ComplexNumbers(3, 1);
        assertEquals(z.getRe(), ComplexNumbers.sub(x, y).getRe(), 0.5);
        assertEquals(z.getIm(), ComplexNumbers.sub(x, y).getIm(), 0.5);
    }

    @Test
    public void multiply() {
        z = new ComplexNumbers(-8, 1);
        assertEquals(z.getRe(), ComplexNumbers.multiply(x, y).getRe(), 0.5);
        assertEquals(z.getIm(), ComplexNumbers.multiply(x, y).getIm(), 0.5);
    }

    @Test
    public void div() {
        z = new ComplexNumbers(0.8, -1.4);
        assertEquals(z.getRe(), ComplexNumbers.div(x, y).getRe(), 0.5);
        assertEquals(z.getIm(), ComplexNumbers.div(x, y).getIm(), 0.5);
    }

*/
}