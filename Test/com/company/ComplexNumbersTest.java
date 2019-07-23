package com.company;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComplexNumbersTest {

    private static final double EPSILON = 0.0000001;


    @DataProvider(name = "sum")
    public static Object[][] sum() {
        return new Object[][]{
                {
                        new ComplexNumbers(1.5, 2.1),
                        new ComplexNumbers(4.2, 0.0),
                        new ComplexNumbers(5.7, 2.1)
                },
                {
                        new ComplexNumbers(1.0, 1.0),
                        new ComplexNumbers(-2.0, -3.1),
                        new ComplexNumbers(-1.0, -2.1)
                },
                {
                        new ComplexNumbers(1.00002, 1.000001),
                        new ComplexNumbers(2.00004, 1.000009),
                        new ComplexNumbers(3.00006, 2.000010)
                }
        };
    }

    @Test(dataProvider = "sum")
    public void testAdd(ComplexNumbers a, ComplexNumbers b, ComplexNumbers expected) {
        ComplexNumbers c = a.sum(b);

        double expectedRe = expected.getRe();
        double expectedIm = expected.getIm();
        double answerRe = c.getRe();
        double answerIm = c.getIm();
        assertEquals(answerRe, expectedRe, EPSILON);
        assertEquals(answerIm, expectedIm, EPSILON);
    }

    @DataProvider(name = "sub")
    public Object[][] sub() {
        return new Object[][]{
                {
                        new ComplexNumbers(1.5, 2.1),
                        new ComplexNumbers(4.2, 0.0),
                        new ComplexNumbers(-2.7, 2.1)
                },
                {
                        new ComplexNumbers(1.0, 1.0),
                        new ComplexNumbers(-2.0, -3.1),
                        new ComplexNumbers(3.0, 4.1)
                },
                {
                        new ComplexNumbers(1.00002, 1.000001),
                        new ComplexNumbers(2.00004, 1.000009),
                        new ComplexNumbers(-1.00002, -0.000008)
                }
        };
    }

    @Test(dataProvider = "sub")
    public void testSub(ComplexNumbers a, ComplexNumbers b, ComplexNumbers expected) {
        ComplexNumbers c = a.sub(b);

        double expectedRe = expected.getRe();
        double expectedIm = expected.getIm();
        double answerRe = c.getRe();
        double answerIm = c.getIm();
        assertEquals(answerRe, expectedRe, EPSILON);
        assertEquals(answerIm, expectedIm, EPSILON);
    }

    @DataProvider(name = "multiply")
    public static Object[][] multiply() {
        return new Object[][]{
                {
                        new ComplexNumbers(1.5, 2.1),
                        new ComplexNumbers(4.2, 0.0),
                        new ComplexNumbers(6.3, 8.82)
                },
                {
                        new ComplexNumbers(1.0, 1.0),
                        new ComplexNumbers(-2.0, -3.1),
                        new ComplexNumbers(1.1, -5.1)
                },
                {
                        new ComplexNumbers(1.00002, 1.000001),
                        new ComplexNumbers(2.00004, 1.000009),
                        new ComplexNumbers(1.000070000791, 3.00007100022)
                }
        };
    }

    @Test(dataProvider = "multiply")
    public static void testMul(ComplexNumbers a, ComplexNumbers b, ComplexNumbers expected) {
        ComplexNumbers c = a.multiply(b);

        double expectedRe = expected.getRe();
        double expectedIm = expected.getIm();
        double answerRe = c.getRe();
        double answerIm = c.getIm();
        assertEquals(answerRe, expectedRe, EPSILON);
        assertEquals(answerIm, expectedIm, EPSILON);
    }

    @DataProvider(name = "div")
    public static Object[][] div() {
        return new Object[][]{
                {
                        new ComplexNumbers(1.5, 2.1),
                        new ComplexNumbers(4.2, 0.0),
                        new ComplexNumbers(0.357142857142857, 0.5)
                },
                {
                        new ComplexNumbers(1.0, 1.0),
                        new ComplexNumbers(-2.0, -3.1),
                        new ComplexNumbers(-0.374724467303453, 0.080822924320352)
                },
                {
                        new ComplexNumbers(1.00002, 1.000001),
                        new ComplexNumbers(2.00004, 1.000009),
                        new ComplexNumbers(0.599996640079694, 0.199995480065671)
                },


        };
    }

    @Test(dataProvider = "div")
    public void testDiv(ComplexNumbers a, ComplexNumbers b, ComplexNumbers expected) {

        try {
            ComplexNumbers c = a.div(b);
            double expectedRe = expected.getRe();
            double expectedIm = expected.getIm();
            double answerRe = c.getRe();
            double answerIm = c.getIm();
            assertEquals(answerRe, expectedRe, EPSILON);
            assertEquals(answerIm, expectedIm, EPSILON);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "divByZero")
    public static Object[][] divByZero() {
        return new Object[][]{
                {
                        new ComplexNumbers(1.0, 1.0),
                        new ComplexNumbers(0.0, 0.0)
                }
        };
    }

    @Test(dataProvider = "divByZero", expectedExceptions = ArithmeticException.class)
    public void testDivByZero(ComplexNumbers a, ComplexNumbers b) {
        a.div(b);
    }

    @DataProvider(name = "abs")
    public static Object[][] abs() {
        return new Object[][]{
                {
                        new ComplexNumbers(1.5, 2.1),
                        2.580697580112788
                },
                {
                        new ComplexNumbers(-2.0, -3.1),
                        3.689173349139343
                },
                {
                        new ComplexNumbers(1.00002, 1.000001),
                        1.414228411679315
                },
                {
                        new ComplexNumbers(0.0, 0.0),
                        0.0
                }
        };
    }


    @DataProvider(name = "pow")
    public static Object[][] pow() {
        return new Object[][]{
                {
                        new ComplexNumbers(1.5, 2.1),
                        3.0,
                        new ComplexNumbers(-16.47, 4.914)
                },
                {
                        new ComplexNumbers(-2.0, -3.1),
                        2.0,
                        new ComplexNumbers(-5.61, 12.4)
                },
                {
                        new ComplexNumbers(2.0, 3.0),
                        -2.0,
                        new ComplexNumbers(-0.029585798816568, -0.071005917159763)
                },
                {
                        new ComplexNumbers(2.0, 3.0),
                        0.5,
                        new ComplexNumbers(1.674149228035540, 0.895977476129838)
                },
                {
                        new ComplexNumbers(1.8, -4.1),
                        3.6,
                        new ComplexNumbers(-114.755967350453287, 188.521492744689144)
                },
                {
                        new ComplexNumbers(1.00002, 1.000001),
                        10.0,
                        new ComplexNumbers(0.003040287288773, 32.003360028793528)
                },
                {
                        new ComplexNumbers(0.0, 0.0),
                        2.0,
                        new ComplexNumbers(0, 0)
                },
                {
                        new ComplexNumbers(2.3, 4.6),
                        1.0,
                        new ComplexNumbers(2.3, 4.6)
                },
                {
                        new ComplexNumbers(2.1, 6.7),
                        0.0,
                        new ComplexNumbers(1.0, 0.0)
                }
        };
    }

    @Test(dataProvider = "pow")
    public void testPow(ComplexNumbers a, double power, ComplexNumbers expected) {
        try {
            ComplexNumbers c = a.pow(power);

            double expectedRe = expected.getRe();
            double expectedIm = expected.getIm();
            double answerRe = c.getRe();
            double answerIm = c.getIm();
            assertEquals(answerRe, expectedRe, EPSILON);
            assertEquals(answerIm, expectedIm, EPSILON);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "rotate")
    public static Object[][] rotate() {
        return new Object[][]{
                {
                        new ComplexNumbers(1, 1),
                        45,
                        new ComplexNumbers(0, Math.sqrt(2))
                },
                {
                        new ComplexNumbers(1, 1),
                        90,
                        new ComplexNumbers(-1, 1)
                },
                {
                        new ComplexNumbers(1, 1),
                        180,
                        new ComplexNumbers(-1, -1)
                },
                {
                        new ComplexNumbers(1, 1),
                        -180,
                        new ComplexNumbers(-1, -1)
                },
                {
                        new ComplexNumbers(1.2, -1.2),
                        5.5,
                        new ComplexNumbers(1.3094903, -1.0794605)
                }
        };
    }

    @Test(dataProvider = "rotate")
    public void testRotate(ComplexNumbers a, double degree, ComplexNumbers expected) {
        ComplexNumbers c = a.rotate(degree);

        double expectedRe = expected.getRe();
        double expectedIm = expected.getIm();
        double answerRe = c.getRe();
        double answerIm = c.getIm();
        assertEquals(answerRe, expectedRe, EPSILON);
        assertEquals(answerIm, expectedIm, EPSILON);
    }
}

