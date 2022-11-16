import functions.*;
public class Main {
    public static void main(String[] args)
    {
        TabulatedFunction points = new TabulatedFunction(0, 5, 6);
        points.print();
        System.out.println();
        FunctionPoint point = new FunctionPoint(-1, 0);
        points.addPoint(point);
        points.print();
        System.out.println();
        points.deletePoint(0);
        points.print();
    }
}