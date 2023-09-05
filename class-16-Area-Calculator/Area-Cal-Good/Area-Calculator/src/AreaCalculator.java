

public class AreaCalculator {

    IShape shape;
    void calculateArea(IShape someShape)
    {
        this.shape = someShape;
        shape.printArea();
    }


}
