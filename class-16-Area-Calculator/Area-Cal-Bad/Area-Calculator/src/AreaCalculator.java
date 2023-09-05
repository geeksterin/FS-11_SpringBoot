

public class AreaCalculator {

  /*  void calculateTriangleArea(int height, int base)
    {
        System.out.println(0.5 * base * height);
    }
*/

    void calculateTriangleArea(Triangle t1)
    {
        System.out.println(0.5 * t1.getBase() * t1.getHeight());
    }

    void calculateSquareArea(Square s1)
    {
        System.out.println(s1.getSide() * s1.getSide());
    }

    void calculateRectangleArea(Rectangle r1)
    {
        System.out.println(r1.getLength() * r1.getBreath());
    }

    void calculateCircleArea(Circle c1)
    {
        System.out.println(3.14 * c1.getRadius() * c1.getRadius());
    }

}
