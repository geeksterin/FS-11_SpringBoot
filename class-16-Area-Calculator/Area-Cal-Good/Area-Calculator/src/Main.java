// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        //Triangles : code which calculates this triangles area
        Triangle t1 = new Triangle(10,10);
        //System.out.println(0.5 * t1.getBase() * t1.getHeight());

        AreaCalculator calculator = new AreaCalculator();
        calculator.calculateArea(t1);

        //Square s1
        Square s1 = new Square(6);
        calculator.calculateArea(s1);

        //Circle s1
        Circle c1 = new Circle(10);
        calculator.calculateArea(c1);

        //Rectangle s1
        Rectangle r1 = new Rectangle(6,8);
        calculator.calculateArea(r1);

        Trapezium tr1 = new Trapezium(10,20,2);
        calculator.calculateArea(tr1);

    }
}