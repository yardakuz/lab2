import functions.*;
public class Main {
    public static void main(String[] args)
    {
        TabulatedFunction points = new TabulatedFunction(0, 5, 6);
        points.deletePoint(0);
        points.print();

    }
}