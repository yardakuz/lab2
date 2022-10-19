package functions;

public class TabulatedFunction {
    private FunctionPoint[] points;         //массив точек

    TabulatedFunction(double leftX, double rightX, int pointsCount)         //конструктор для заданных границ x и количества точек
    {
        this.points = new FunctionPoint[pointsCount];
        double len = (rightX - leftX) / (pointsCount - 1);
        for(int i = 0; i < pointsCount; ++i)
        {
            this.points[i] = new FunctionPoint(leftX + len*i, 0);
        }
    }

    TabulatedFunction(double leftX, double rightX, double[] values)             //конструктор для заданных границ x и массива из значений y
    {
        this.points = new FunctionPoint[values.length];
        double len = (rightX - leftX)/ (values.length - 1);
        for (int i = 0; i < values.length; ++i)
        {
            this.points[i] = new FunctionPoint(leftX + len*i, values[i]);
        }
    }

    public double getLeftDomainBorder()                 //метод, возвращающий левую крайнюю границу массива точек
    {
        return this.points[0].getX();
    }

    public double getRightDomainBorder()                //метод, возвращаюший правую крайнюю границу массива точек
    {
        return this.points[points.length-1].getX();
    }

    public double getFunctionValue(double x)           //метод, возвращающий значение функции в точке x
    {
        if ((this.points[0].getX() > x) || (this.points[points.length-1].getX() < x)) return Double.NaN;
        int i = 0;
        while (points[i].getX() < x)
        {
            ++i;
        }

        double a, b;
        double x1 = points[i - 1].getX();
        double x2 = points[i].getX();
        double y1 = points[i - 1].getY();
        double y2 = points[i].getY();
        a = (y2 - y1)/(x2 - x1);
        b = y1 - x1*a;
        return x * a + b;

    }

    public int getPointsCount()        //метод, возвращающий количество точек
    {
            return points.length;
    }

    public FunctionPoint getPoint(int index)       //метод, возвращающий ссылку на объект, описывающий точку с данным номером
    {
        //if(index < 0 || index > points.length) return null;
        return this.points[index];
    }

    public void setPoint(int index, FunctionPoint point)
    {

    }



}
