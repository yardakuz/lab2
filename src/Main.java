import functions.*;
public class Main {
    public static void main(String[] args)
    {
        FunctionPoint point = new FunctionPoint(3, 2);
        FunctionPoint point2 = new FunctionPoint(point);
        System.out.println(point2.getX());
        System.out.println('\n');
        System.out.println(point2.getY());
    }
}