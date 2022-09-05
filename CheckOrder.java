/*************************************************************************
 *  Compilation:  javac OrderCheck.java
 *  Execution:    java OrderCheck 5 10 15 2
 *
 *  @author:
 *
 *  Prints true if the four integer inputs are in strictly ascending
 *  or descending order, false otherwise
 *
 *  % java OrderCheck 5 10 15 2
 *  false
 *
 *  % java OrderCheck 15 11 9 4
 *  true
 *
 *************************************************************************/

public class OrderCheck {

    public static void main(String[] args) {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = Integer.parseInt(args[2]);
    int d = Integer.parseInt(args[3]);
    boolean firstCheck;
    firstCheck = ((a<b)&&(b<c));
    firstCheck = firstCheck && (c<d);
    boolean secondCheck;
    secondCheck = ((a>b)&&(b>c));
    secondCheck = secondCheck && (c>d);
    boolean orderCheck;
    orderCheck = firstCheck || secondCheck;
    System.out.println(orderCheck);
    }
}
