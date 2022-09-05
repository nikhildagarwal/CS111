/*************************************************************************
 *  Compilation:  javac LargestOfFive.java
 *  Execution:    java LargestOfFive 35 10 32 1 8
 *
 *  @author:
 *
 *  Takes five distinct integers as command-line arguments and prints the 
 *  largest value
 *
 *
 *  % java LargestOfFive 35 10 32 1 8
 *  35
 *
 *  Assume the inputs are 5 distinct integers.
 *  Print only the largest value, nothing else.
 *
 *************************************************************************/

public class LargestOfFive {

    public static void main (String[] args) {
        int largestNum = Integer.parseInt(args[0]);
        int counter = 1;
            while(counter<5){
                    int x = Integer.parseInt(args[counter]);
                    if(x>largestNum){
                    largestNum = x;
                }
                counter++;
        }
        System.out.println(largestNum);
    }
}
