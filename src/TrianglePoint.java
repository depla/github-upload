public class TrianglePoint
{
    private int x;
    private int y;

    //default constructor
    public TrianglePoint()
    {
        x = 0;
        y = 0;
    }

    //parameterized constructor
    public TrianglePoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    //setters
    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    //getters
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    //toString
    public String toString()
    {
        return "\nX coordinate: " + x  +
                "\nY coordinate: " + y;
    }
}
