//-------------------------------------------------------------------------------------------------------------------
//  Course: CS 112             Days & Time:  Tues 5:30 PM
//  Chapter Number: 18           Project Number or GroupProject Name: 1
//  Programmer(s):  Dennis La
//  Date Created or Last Modified: 20 May 2018
//-------------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------------
//  Program Title:  SierpinskiTriangle
//  Program Description:  (1 - 2 lines describing the program)
//  The purpose of this program is to:
//  Draw the Sierpinski triangle in a window.
//-------------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------------
/*ALGORITHM:
(Detailed, step-by-step, outline of the program - your analysis and design)
1.Instantiate the window size, the amount of pixels to be drawn, and the starting points for the initial triangle

2.Make a TrianglePoint class that has x and y coordinates for each point. Make TrianglePoint objects for each point of
the outer triangle, a, b and c. Pass in the points into the constructor.

3.For the window, set the title, the close operation and the size.

4.In the paint method, we draw lines between a b and c to make a triangle. We then set a TrianglePoint object named
current to PointA. Then we have a for loop that loops for as many pixels to be drawn. We make a TrianglePoint named
target and set it to a random point of the outermost triangle. The random point is generated in a method called
getRandomABCPoint that generates a random number from 0 to 2 and returns one of the points depending on what number is
generated. We then make a point called midpoint which is made in a method called getHalfwayPoint. This is the midpoint
between current and target. The method works by taking in the x and y coordinates of current and target and creating
the x and y coordinates for the midpoint using the midpoint formula. The method creates the midpoint object which is
of the class TrianglePoint using the new x and y coordinates and returns it. We then set current to the midpoint.
Then we draw a pixel at current.

5.Main creates the JFrame and sets it to visible.
        _____________________________________________________________________________
        IMPORTED PACKAGES:
import java.awt.*; - allows the use of the paint method and graphics class
import javax.swing.*; - allows the use of the JFrame components
import java.util.Random; - lets us choose a random point of the outermost triangle
        _____________________________________________________________________________*/

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class SierpinskiTriangle extends JFrame
{
    //instantiate size of window
    private final int WINDOW_WIDTH = 610;
    private final int WINDOW_HEIGHT = 610;

    //instantiate number of pixels to draw
    private final int NUM_PIXELS = 1000000;

    //instantiate points for each corner of the triangle
    private final int POINT_A_X = 305;
    private final int POINT_A_Y = 80;
    private final int POINT_B_X = 5;
    private final int POINT_B_Y = 600;
    private final int POINT_C_X = 605;
    private final int POINT_C_Y = 600;

    //create TrianglePoints
    TrianglePoint PointA = new TrianglePoint(POINT_A_X, POINT_A_Y);
    TrianglePoint PointB = new TrianglePoint(POINT_B_X, POINT_B_Y);
    TrianglePoint PointC = new TrianglePoint(POINT_C_X, POINT_C_Y);

    //constructor for window
    public SierpinskiTriangle()
    {
        //set the title text
        super("Sierpinski Triangle");

        //specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    //paint method
    public void paint(Graphics g)
    {
        super.paint(g);

        //draw lines to each point A B and C to get the outside triangle
        g.drawLine(PointA.getX(), PointA.getY(), PointB.getX(), PointB.getY());
        g.drawLine(PointB.getX(), PointB.getY(), PointC.getX(), PointC.getY());
        g.drawLine(PointC.getX(), PointC.getY(), PointA.getX(), PointA.getY());

        //set the current point to point A
        TrianglePoint current = PointA;

        //for loop to draw the pixels
        for(int i = 0; i < NUM_PIXELS; i++)
        {
            //randomly choose point a b or c to be target
            TrianglePoint target = getRandomABCPoint();

            //calculate halfway point between current and target
            TrianglePoint midPoint = getHalfwayPoint(current.getX(), current.getY(), target.getX(), target.getY());

            //set current to the midPoint
            current = midPoint;

            //draw pixel at current
            g.drawLine(current.getX(), current.getY(), current.getX(), current.getY());
        }

    }

    //method to return A B or C randomly
    public TrianglePoint getRandomABCPoint()
    {
        //make a random number from 0-2
        int randomNum = new Random().nextInt(3);

        //depending on what the random number is, return the corresponding Point
        if(randomNum == 0)
        {
            return PointA;
        }
        else if(randomNum == 1)
        {
            return PointB;
        }
        else
        {
            return PointC;
        }
    }


    //method to calculate the halfway point between two points. return a TrianglePoint object
    public TrianglePoint getHalfwayPoint(int x1, int y1, int x2, int y2)
    {
        //instantiate midpoint x and y
        int midX;
        int midY;

        //calculate the midpoint using the midpoint formula
        midX = (x1 + x2) / 2;
        midY = (y1 + y2) / 2;

        //make a new TrianglePoint with those new points
        TrianglePoint midpoint = new TrianglePoint(midX, midY);

        return midpoint;
    }

    public static void main(String[] args)
    {
        //make JFrame object
        SierpinskiTriangle sierpinskiTriangle = new SierpinskiTriangle();

        //set it to visible
        sierpinskiTriangle.setVisible(true);
    }

}
