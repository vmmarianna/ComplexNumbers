package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumbersTest {


    private ComplexNumbers x;
    private ComplexNumbers y;


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
        assertEquals(1, sum.getRe(), 0.000001);
        assertEquals(5, sum.getIm(), 0.000001);
    }

    /*
        @Test
        public void comparison(int i, ComplexNumbers x) {
            assertTrue(this.x.comparison(this.x));
            assertEquals(true, comparison());
         //   assertEquals(false, ComplexNumbers.comparison(x, y));
          //  assertNotEquals(true, ComplexNumbers.comparison(x, y));
        }
    */
    @Test
    public void sub() {
        ComplexNumbers sub = x.sub(y);

        assertEquals(3, sub.getRe(), 0.000001);
        assertEquals(1, sub.getIm(), 0.000001);
    }

    @Test
    public void multiply() {
        //z = new ComplexNumbers(-8, 1);
        ComplexNumbers multiply = ComplexNumbers.multiply(x, y);
        assertEquals(-8, multiply.getRe(), 0.000001);
        assertEquals(1, multiply.getIm(), 0.000001);
    }

    @Test
    public void div() {
        ComplexNumbers div = ComplexNumbers.div(x, y);
        assertEquals(0.8, div.getRe(), 0.000001);
        assertEquals(-1.4, div.getIm(), 0.000001);
    }


}