/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        double root = Math.sqrt(3);
        double tall = root*length/2;
        return tall;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double[] newx = {x,x+length/2,x-length/2};
        double[] newy = {y,y+height(length),y+height(length)};
        StdDraw.filledPolygon(newx,newy);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if(n==1){
            filledTriangle(x,y,length);
        }else{
            filledTriangle(x,y,length);
            sierpinski(n-1, x-(length/2), y, length/2);
            sierpinski(n-1, x, y+height(length), length/2);
            sierpinski(n-1, x+(length)/2, y, length/2);
        }

    }


    // DONE Takes an integer command-line argument n;
    // DONE draws the outline of an equilateral triangle (pointed upwards) of length 1;
    // DONE whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
        int command = Integer.parseInt(args[0]);
        double[] x = {0,1,0.5};
        double l = x[1]-x[0];
        double[] y = {0,0,height(l)};
        StdDraw.polygon(x,y);
        sierpinski(command, x[2], y[1], 0.5);

    }
}
