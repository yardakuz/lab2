package functions;

public class FunctionPoint {
    private double x;       //значчение x в точке
    private double y;       //значение y в точке
    public FunctionPoint(double x, double y)    //конструктор со значениями
    {
        this.x = x;
        this.y = y;
    }
    public FunctionPoint(FunctionPoint point)       //конструктор копирования
    {
        this.x = point.getX();
        this.y = point.getY();
    }
    public FunctionPoint()          //конструктор по умолчанию
    {
        this.x = 0;
        this.y = 0;
    }

    public double getX()
    {
        return x;
    }       //геттер для x

    public double getY()
    {
        return y;
    }       //геттер для y
}
