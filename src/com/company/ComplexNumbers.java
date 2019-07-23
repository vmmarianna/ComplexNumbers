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

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    //сравнения
    public boolean comparison(ComplexNumbers other) {
        return (this.getRe() == other.getRe()) && (this.getIm() == other.getIm());
    }

    //сложение
    public ComplexNumbers sum(ComplexNumbers other) {
        return new ComplexNumbers(this.getRe() + other.getRe(), this.getIm() + other.getIm());
    }

    //вычитание
    public ComplexNumbers sub(ComplexNumbers other) {
        return new ComplexNumbers(this.getRe() - other.getRe(), this.getIm() - other.getIm());
    }

    //умножение
    public ComplexNumbers multiply(ComplexNumbers other) {
        return new ComplexNumbers(this.getRe() * other.getRe() - this.getIm() * other.getIm(),
                this.getRe() * other.getIm() + this.getIm() * other.getRe());
    }

    //деление
    public ComplexNumbers div(ComplexNumbers other) throws ArithmeticException {
        ComplexNumbers temp = new ComplexNumbers(other.getRe(), (-1) * other.getIm());
        temp = this.multiply(temp);
        double divider = other.getRe() * other.getRe() + other.getIm() * other.getIm();
        if ((other.getIm() == 0) && (other.getRe() == 0))
            throw new ArithmeticException("division by zero");
        return new ComplexNumbers(temp.getRe() / divider, temp.getIm() / divider);
    }

    //модуль
    public Double abs() {
        return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
    }

    //аргумент числа
    public Double arg() {
        return Math.atan2(this.im, this.re);
    }

    //степень
    public ComplexNumbers pow(double power) throws ArithmeticException {
        if ((this.getIm() == 0) && (this.getRe() == 0) && power <= 0)
            throw new ArithmeticException("division by zero");
        double modul = this.abs();
        double arg = this.arg();
        modul = Math.pow(modul, power);
        arg *= power;
        return new ComplexNumbers(modul * Math.cos(arg), modul * Math.sin(arg));
    }

    //поворота на угол φ в радианах
    public ComplexNumbers rotate(double angle) {
        double r = this.abs();
        double phi = this.arg();
        phi += angle * (2 * Math.PI / 360);
        return new ComplexNumbers(r * Math.cos(phi), r * Math.sin(phi));
    }

    //знак
    private String sign() {
        if (im > 0) return " + ";
        else if (im == 0) return " + ";
        else return "";
    }

    //вывод
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