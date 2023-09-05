public class Trapezium implements IShape {

    private int s1;
    private int s2;
    private int h;

    public Trapezium(int s1, int s2, int h) {
        this.s1 = s1;
        this.s2 = s2;
        this.h = h;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void printArea()
    {
        System.out.println(0.5* (s1+s2)*h);
    }
}
