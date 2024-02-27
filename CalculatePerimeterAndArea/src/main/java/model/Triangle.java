package model;

public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = (this.getA() + this.getB() + this.getC()) / 2;
        return Math.sqrt(p * (p - this.getA()) * (p - this.getB()) * (p - this.getC()));
    }

    @Override
    public double getPerimeter() {
        return this.getA() + this.getB() + this.getC();
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + this.getA());
        System.out.println("Side B: " + this.getB());
        System.out.println("Side C: " + this.getC());
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

}
