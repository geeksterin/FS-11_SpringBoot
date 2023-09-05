public class AreaCalculatorTriangleSquare {

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

}
