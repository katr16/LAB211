
package controller;

import model.Circle;
import model.Rectangle;
import model.Triangle;

public class CalculatorDAO {
    private static CalculatorDAO instance = null;
    Library l;

    public CalculatorDAO() {
        l = new Library();
    }

    public static CalculatorDAO Instance() {
        if (instance == null) {
            synchronized (CalculatorDAO.class) {
                if (instance == null) {
                    instance = new CalculatorDAO();
                }
            }
        }
        return instance;
    }
    
    public void inputandcalculatorShape() {
        Rectangle rectangle = inputRectangle();
        Circle circle = inputCircle();
        Triangle triangle = inputTriangle();
        calculator(triangle, rectangle, circle);
    }

    public Triangle inputTriangle() {
        while (true) {
            double a = l.checkInputDouble("Please input side A of Triangle: \n");
            double b = l.checkInputDouble("Please input side B of Triangle: \n");
            double c = l.checkInputDouble("Please input side C of Triangle: \n");
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }

    }

    public Rectangle inputRectangle() {
        double width = l.checkInputDouble("Please input side width of Rectangle: \n");
        double length = l.checkInputDouble("Please input length of Rectangle: \n");
        return new Rectangle(width, length);
    }

    public Circle inputCircle() {
        double radius = l.checkInputDouble("Please input radius of Circle: \n");
        return new Circle(radius);
    }

    public void calculator(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }
}
