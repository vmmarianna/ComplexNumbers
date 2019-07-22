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

        if ((this.getRe() == other.getRe()) && (this.getIm() == other.getIm())) {
            return true;
        } else return false;
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
    public ComplexNumbers div(ComplexNumbers other) {
        ComplexNumbers temp = new ComplexNumbers(other.getRe(), (-1) * other.getIm());
        temp = this.multiply(temp);
        double divider = other.getRe() * other.getRe() + other.getIm() * other.getIm();
        return new ComplexNumbers(temp.getRe() / divider, temp.getIm() / divider);
    }

    //получение аргумента
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

    //модуль числа
    private double getModule() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    //возведение в степень;
    public ComplexNumbers pow(ComplexNumbers c, int power) {
        double factor = Math.pow(c.getModule(), power);
        return new ComplexNumbers(factor * Math.cos(power * c.GetArg()), factor * Math.sin(power * c.GetArg()));
    }

    //поворота на угол φ.
    public ComplexNumbers rotate(ComplexNumbers other, int angle) {
        other = other.sub(this);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new ComplexNumbers(this.getRe() * cos + other.getRe() * sin, this.getIm() * sin + other.getIm() * cos);
    }

    //знак
    private String sign() {
        if (im > 0) return " + ";
        else if (im == 0) return "";
        else return " - ";
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