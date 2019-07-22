package com.company;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TestComplex {

    private static final Double[] DATA = {
            5.0, 1.0,
            1.1, 1.2,
            1000.0

    };

    private List<Double[]> fullData = new ArrayList<>();

    private ComplexNumbers a;
    private ComplexNumbers b;

    public TestComplex() {
        for (Double numARe : DATA)
            for (Double numAIm : DATA)
                for (Double numBRe : DATA)
                    for (Double numBIm : DATA) {
                        fullData.add(new Double[]{numARe, numAIm, numBRe, numBIm, null, null});
                        fullData.add(new Double[]{numARe, numAIm, numBRe, -numBIm, null, null});
                        fullData.add(new Double[]{numARe, numAIm, -numBRe, numBIm, null, null});
                        fullData.add(new Double[]{numARe, numAIm, -numBRe, -numBIm, null, null});
                        fullData.add(new Double[]{numARe, -numAIm, numBRe, numBIm, null, null});
                        fullData.add(new Double[]{numARe, -numAIm, numBRe, -numBIm, null, null});
                        fullData.add(new Double[]{numARe, -numAIm, -numBRe, numBIm, null, null});
                        fullData.add(new Double[]{numARe, -numAIm, -numBRe, -numBIm, null, null});
                        fullData.add(new Double[]{-numARe, numAIm, numBRe, numBIm, null, null});
                        fullData.add(new Double[]{-numARe, numAIm, numBRe, -numBIm, null, null});
                        fullData.add(new Double[]{-numARe, numAIm, -numBRe, numBIm, null, null});
                        fullData.add(new Double[]{-numARe, numAIm, -numBRe, -numBIm, null, null});
                        fullData.add(new Double[]{-numARe, -numAIm, numBRe, numBIm, null, null});
                        fullData.add(new Double[]{-numARe, -numAIm, numBRe, -numBIm, null, null});
                        fullData.add(new Double[]{-numARe, -numAIm, -numBRe, numBIm, null, null});
                        fullData.add(new Double[]{-numARe, -numAIm, -numBRe, -numBIm, null, null});
                    }
    }

    @DataProvider(name = "sum")
    public Object[][] sum() {
        int resultSize = fullData.size();
        int length = fullData.get(0).length;
        Object[][] result = new Double[resultSize][length];

        for (int testCase = 0; testCase < resultSize; testCase++) {
            Double[] insert = new Double[]{
                    fullData.get(testCase)[0],
                    fullData.get(testCase)[1],
                    fullData.get(testCase)[2],
                    fullData.get(testCase)[3],
                    fullData.get(testCase)[0] + fullData.get(testCase)[2],
                    fullData.get(testCase)[1] + fullData.get(testCase)[3]
            };
            result[testCase] = insert;
        }

        return result;
    }

    @Test(dataProvider = "sum")
    public void testSum(Double numARe, Double numAIm, Double numBRe, Double numBIm, Double answerRe, Double answerIm) {
        a = new ComplexNumbers(numARe, numAIm);
        b = new ComplexNumbers(numBRe, numBIm);
        assertEquals(answerRe, a.sum(b).getRe(), 0.0000001);
        assertEquals(answerIm, a.sum(b).getIm(), 0.0000001);
    }


    @DataProvider(name = "sub")
    public Object[][] sub() {
        int resultSize = fullData.size();
        int length = fullData.get(0).length;
        Object[][] result = new Double[resultSize][length];

        for (int testCase = 0; testCase < resultSize; testCase++) {
            Double[] insert = new Double[]{
                    fullData.get(testCase)[0],
                    fullData.get(testCase)[1],
                    fullData.get(testCase)[2],
                    fullData.get(testCase)[3],
                    fullData.get(testCase)[0] - fullData.get(testCase)[2],
                    fullData.get(testCase)[1] - fullData.get(testCase)[3]
            };
            result[testCase] = insert;
        }

        return result;
    }

    @Test(dataProvider = "sub")
    public void testSub(Double numARe, Double numAIm, Double numBRe, Double numBIm, Double answerRe, Double answerIm) {
        a = new ComplexNumbers(numARe, numAIm);
        b = new ComplexNumbers(numBRe, numBIm);
        assertEquals(answerRe, a.sub(b).getRe(), 0.0000001);
        assertEquals(answerIm, a.sub(b).getIm(), 0.0000001);
    }

    @DataProvider(name = "multiply")
    public Object[][] multiply() {
        int resultSize = fullData.size();
        int length = fullData.get(0).length;
        Object[][] result = new Double[resultSize][length];

        for (int testCase = 0; testCase < resultSize; testCase++) {
            Double[] insert = new Double[]{
                    fullData.get(testCase)[0],
                    fullData.get(testCase)[1],
                    fullData.get(testCase)[2],
                    fullData.get(testCase)[3],
                    fullData.get(testCase)[0] * fullData.get(testCase)[2] - fullData.get(testCase)[1] * fullData.get(testCase)[3],
                    fullData.get(testCase)[0] * fullData.get(testCase)[3] + fullData.get(testCase)[1] * fullData.get(testCase)[2]
            };
            result[testCase] = insert;
        }

        return result;
    }

    @Test(dataProvider = "multiply")
    public void testMultiply(Double numARe, Double numAIm, Double numBRe, Double numBIm, Double answerRe, Double answerIm) {
        a = new ComplexNumbers(numARe, numAIm);
        b = new ComplexNumbers(numBRe, numBIm);
        assertEquals(answerRe, a.multiply(b).getRe(), 0.0000001);
        assertEquals(answerIm, a.multiply(b).getIm(), 0.0000001);
    }
/*

    @DataProvider(name = "div")
    public Object[][] div() {
        int resultSize = fullData.size();
        int length = fullData.get(0).length;
        Object[][] result = new Double[resultSize][length];

        for (int testCase = 0; testCase < resultSize; testCase++) {
            Double[] insert = new Double[]{
                    fullData.get(testCase)[0],
                    fullData.get(testCase)[1],
                    fullData.get(testCase)[2],
                    fullData.get(testCase)[3],
                    //   temp.getRe() * other.getRe() - temp.getIm() * other.getIm()/
                    // temp.getRe() * other.getRe() - temp.getIm() * other.getIm()/
                    //(fullData.get(testCase)[0] * fullData.get(testCase)[0] - fullData.get(testCase)[1] * fullData.get(testCase)[1])/
                    //        (fullData.get(testCase)[0]*fullData.get(testCase)[2]+fullData.get(testCase)[1]*fullData.get(testCase)[3]),
                    // temp.getRe() * other.getIm() + temp.getIm() * other.getRe()
                    //(fullData.get(testCase)[0] * fullData.get(testCase)[3] + fullData.get(testCase)[1] * fullData.get(testCase)[2])/
                   //         (fullData.get(testCase)[0]*fullData.get(testCase)[2]+fullData.get(testCase)[1]*fullData.get(testCase)[3])


                   // ( fullData.get(testCase)[0]*fullData.get(testCase)[2]+fullData.get(testCase)[1]*fullData.get(testCase)[3])/
                            //(fullData.get(testCase)[2]*fullData.get(testCase)[2]+fullData.get(testCase)[3]*fullData.get(testCase)[3]),

                  //  (fullData.get(testCase)[1]*fullData.get(testCase)[2]-fullData.get(testCase)[3]*fullData.get(testCase)[0])
                           // /(fullData.get(testCase)[2]*fullData.get(testCase)[2]+fullData.get(testCase)[3]*fullData.get(testCase)[3])



            };
            result[testCase] = insert;
        }

        return result;
    }

    @Test(dataProvider = "div")
    public void testDiv(Double numARe, Double numAIm, Double numBRe, Double numBIm, Double answerRe, Double answerIm) {
        a = new ComplexNumbers(numARe, numAIm);
        b = new ComplexNumbers(numBRe, numBIm);
        assertEquals(answerRe, a.div(b).getRe(), 0.1);
        assertEquals(answerIm, a.div(b).getIm(), 0.1);
    }
    */
}