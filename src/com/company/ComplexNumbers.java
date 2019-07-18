package com.company;

public class ComplexNumbers {

    //действительная часть комплексного числа
    private double re;

    //мнимая часть комплексного числа
    private double im;


    public ComplexNumbers(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexNumbers subtract(ComplexNumbers c1, ComplexNumbers c2) {
        return new ComplexNumbers(c1.getRe() - c2.getRe(), c1.getIm() - c2.getIm());
    }


    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    //сравнения;

    //сложение;

    public static ComplexNumbers sum(ComplexNumbers c1, ComplexNumbers c2) {
        return new ComplexNumbers(c1.getRe() + c2.getRe(), c1.getIm() + c2.getIm());
    }

    //вычитание;
    public ComplexNumbers sub(ComplexNumbers c1, ComplexNumbers c2) {
        return new ComplexNumbers(c1.getRe() - c2.getRe(), c1.getIm() - c2.getIm());
    }

    //умножение;
    public static ComplexNumbers multiply(ComplexNumbers c1, ComplexNumbers c2) {
        return new ComplexNumbers(c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm(), c1.getRe() * c2.getIm() + c1.getIm() * c2.getRe());
    }


    //деление;
    public static ComplexNumbers div(ComplexNumbers c1, ComplexNumbers c2) {
        ComplexNumbers temp = new ComplexNumbers(c2.getRe(), (-1) * c2.getIm());
        temp = ComplexNumbers.multiply(c1, temp);
        double divider = c2.getRe() * c2.getRe() + c2.getIm() * c2.getIm();
        return new ComplexNumbers(temp.getRe() / divider, temp.getIm() / divider);
    }


    private double GetArg() {
        if (this.re > 0) {
            return Math.atan(im / re);
        } else {
            if (re < 0 && im > 0) {
                return Math.PI + Math.atan(im / re);
            } else {
                return -Math.PI + Math.atan(im / re);
            }
        }
    }

    public static ComplexNumbers[] sqrt(ComplexNumbers cn) {
        double a = cn.getModule() / 2;
        ComplexNumbers pos = new ComplexNumbers(Math.sqrt(a + cn.getRe() / 2), Math.signum(cn.getIm()) * Math.sqrt(a - cn.getRe() / 2));
        ComplexNumbers neg = new ComplexNumbers((-1) * pos.getRe(), (-1) * pos.getIm());
        ComplexNumbers[] answer = {pos, neg};
        return answer;
    }

    private double getModule() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    //возведение в степень;
    public static ComplexNumbers pow(ComplexNumbers c, int power) {
        double factor = Math.pow(c.getModule(), power);
        return new ComplexNumbers(factor * Math.cos(power * c.GetArg()), factor * Math.sin(power *c.GetArg()));
    }

    //поворота на угол φ.
    //public ComplexNumbers cornering(ComplexNumbers c, int power) {

    //}
    private String sign() {
        if (im > 0) return " + ";
        else return " - ";
    }

    public String toString() {
        String string;
        if (im == 1 || im == -1) {
            if (re == 0) {
                string = sign() + "i";
            } else {
                string = re + sign() + "i";
            }
        } else {
            string = re + sign() + Math.abs(im) + "i";
        }
        return string;
    }


}
