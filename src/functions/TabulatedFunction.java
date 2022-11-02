package functions;

public class TabulatedFunction {
    private FunctionPoint[] points;         //массив точек

    private int NumberPoints;           //кол-во точек в массиве

    public TabulatedFunction(double leftX, double rightX, int pointsCount)         //конструктор для заданных границ x и количества точек
    {
        this.points = new FunctionPoint[pointsCount + 10];
        double len = (rightX - leftX) / (pointsCount - 1);
        for(int i = 0; i < pointsCount; ++i)
        {
            this.points[i] = new FunctionPoint(leftX + len*i, 0);
        }
        this.NumberPoints = pointsCount;
    }

    public TabulatedFunction(double leftX, double rightX, double[] values)             //конструктор для заданных границ x и массива из значений y
    {
        this.points = new FunctionPoint[values.length + 10];
        double len = (rightX - leftX)/ (values.length - 1);
        for (int i = 0; i < values.length; ++i)
        {
            this.points[i] = new FunctionPoint(leftX + len*i, values[i]);
        }
        this.NumberPoints = values.length;
    }

    public double getLeftDomainBorder()                 //метод, возвращающий левую крайнюю границу массива точек
    {
        return this.points[0].getX();
    }

    public double getRightDomainBorder()                //метод, возвращаюший правую крайнюю границу массива точек
    {
        return this.points[NumberPoints - 1].getX();
    }

    public double getFunctionValue(double x)           //метод, возвращающий значение функции в точке x
    {
        if ((this.points[0].getX() > x) || (this.points[NumberPoints - 1].getX() < x)) return Double.NaN;
        int i = 0;
        while (this.points[i].getX() < x) ++i;
        double a, b;
        double x1 = this.points[i - 1].getX();
        double x2 = this.points[i].getX();
        double y1 = this.points[i - 1].getY();
        double y2 = this.points[i].getY();
        a = (y2 - y1)/(x2 - x1);
        b = y1 - x1*a;
        return x * a + b;
    }

    public int getPointsCount()        //метод, возвращающий количество точек
    {
            return NumberPoints;
    }

    public FunctionPoint getPoint(int index)       //метод, возвращающий ссылку на объект, описывающий точку с данным номером
    {
        if(index < 0 || index > NumberPoints) return null;
        return this.points[index];
    }

    public void setPoint(int index, FunctionPoint point)    //метод, заменяющий точку с данным индексом на другую
    {
        if (index < 0 || index > NumberPoints || point.getX() > this.getRightDomainBorder() || point.getX() < this.getLeftDomainBorder()) return;
        if (index == 0)
        {
            if (point.getX() < this.points[index + 1].getX()) points[index] = new FunctionPoint(point);
        }
        if (index == NumberPoints)
        {
            if(point.getX() > this.points[index - 1].getX()) points[index] = new FunctionPoint(point);
        }
        else
        {
            if( (point.getX() > this.points[index-1].getX()) && (point.getX() < this.points[index-1].getX())) points[index] = new FunctionPoint(point);
        }

    }

    public double getPointX(int index)          //метод, возвращающий значение абсциссы точки с данным номером
    {
        if (index < 0 || index > NumberPoints) return Double.NaN;
        return this.points[index].getX();
    }

    public void setPointX(int index, double x)      //метод,  изменяющий значение абсциссы точки с указанным номером
    {
        setPoint(index, new FunctionPoint(x, this.points[index].getY()));
    }

    public double getPointY(int index)          //метод, возвращающий значение ординаты точки с данным номером
    {
        if (index < 0 || index > NumberPoints) return Double.NaN;
        return this.points[index].getY();
    }

    public void setPointY(int index, double y)      //метод,  изменяющий значение ординаты точки с указанным номером
    {
        if (index < 0 || index > NumberPoints) return;
        this.points[index] = new FunctionPoint(this.points[index].getX(), y);
    }

    public void deletePoint(int index)      //метод, удаляющий заданную точку
    {
        if (index < 0 || index > NumberPoints) return;
        System.arraycopy(points, index + 1, points, index, this.points.length - index - 1);
        --NumberPoints;
    }

    public void addPoint(FunctionPoint point)       //метод, добавляющий новую точку
    {
        int index = 0;
        if(point.getX() > this.points[NumberPoints - 1].getX())
        {
            index = NumberPoints + 1;
        }
        else
        {
            while (this.points[index].getX() < point.getX()) ++index;
        }

        if (index < NumberPoints)
        {
            if (NumberPoints <= this.points.length)
            {
                FunctionPoint[] tmp = new FunctionPoint[NumberPoints];
                System.arraycopy(points, 0, tmp, 0, tmp.length);
                this.points = new FunctionPoint[NumberPoints + 1];
                ++NumberPoints;
                System.arraycopy(tmp, 0, points, 0, index);
                this.points[index] = point;
            }
            else
            {
                System.arraycopy(points, index, points, index + 1, NumberPoints - index);
                this.points[index] = point;
            }
        }
        else
        {
            FunctionPoint[] tmp = new FunctionPoint[getPointsCount()];
            System.arraycopy(points,0,tmp,0,tmp.length);
            this.points = new FunctionPoint[getPointsCount() + 1];
            NumberPoints++;
            System.arraycopy(tmp,0,points,0,tmp.length);
            this.points[NumberPoints-1] = point;

        }

    }

    public void print() {
        for (int i = 0; i < NumberPoints; i++) {
            System.out.println("(" + points[i].getX() + " ; " + points[i].getY() + ")");
        }
    }
}
