/*************************************************************************
 *  Compilation:  javac RecursiveAppend.java
 *  Execution:    java RecursiveAppend
 *
 *  @author:
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    public static String appendNTimes (String original, int n) {
        if(n==0){
            return original;
        }else{
            //original = original + original;
            return appendNTimes(original,n-1) + original;
        }
    }

    public static void main (String[] args) {
        int input = Integer.parseInt(args[0]);
        System.out.println(appendNTimes("ho", input));
    }
}
