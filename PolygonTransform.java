/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author:
 *
 *************************************************************************/

public class PolygonTransform {

    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {
        int zlength = array.length;
        double[] newArray = new double[zlength];
        for(int f = 0; f< zlength; f++){
            newArray[f] = array[f];
        }
        return newArray;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {
        int length = x.length;
        for(int i = 0; i<length; i++){
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {
        int ylength = y.length;
        for(int p =0; p<ylength; p++){
            x[p] = x[p] + dx;
            y[p] = y[p] + dy;
        }
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {
        int xlength = x.length;
        double pi = Math.PI;
        double radian = theta*pi/180;
        double cos = Math.cos(radian);
        double sin = Math.sin(radian);
        for(int k = 0; k < xlength; k++){
            double xval = x[k];
            double yval = y[k];
            x[k] = xval*cos - yval*sin;
            y[k] = yval*cos + xval*sin;
        }
    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {
        double[] x = {0,1,1,0};
        double[] y = {0,0,2,1};
        copy(x);
        copy(y);
        scale(x,y,2);
        translate(x,y,2,2);
        rotate(x,y,45);
    }
}
