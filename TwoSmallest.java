/*************************************************************************
 *  Compilation:  javac TwoSmallest.java
 *  Execution:    java TwoSmallest 1.1 6.9 0.3
 *
 *  @author:
 *
 *  The program TwoSmallest takes a set of double command-line
 *  arguments and prints the smallest and second-smallest number, in that
 *  order. It is possible for the smallest and second-smallest numbers to
 *  be the same (if the sequence contains duplicate numbers).
 *
 *  Note: display one number per line
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  1.1
 *
 *  % java TwoSmallest 17.0 23.0 5.0 0.3 1.1 6.9 0.3
 *  0.3
 *  0.3
 *************************************************************************/

public class TwoSmallest {
    public static void main(String[] args) {
    int length = args.length;
        double[] input = new double[length];
        for(int i=0;i<length;i++){
            input[i] = Double.parseDouble(args[i]);
        }
        
        double smallestNum = input[0];          //prints the smallest number of commandline inputs
        for(int j=1; j<length; j++){
            if(smallestNum>input[j]){
                smallestNum = input[j];
            }
        }
        System.out.println(smallestNum);
        
        int repeat = 0;                         //checks for repeats of the smallestNum 
        for(int p = 0; p<length; p++){          
            if(smallestNum==input[p]){
                repeat++;
            }
        }
        
        if(repeat>1){                           //prints smallestNum if there is a repeat
            System.out.println(smallestNum);
        }else{                                  //prints the secondSmallestNumber if no repeat
            for(int k = 0; k<length; k++){          
                if(smallestNum==input[k]){
                input[k] = Double.MAX_VALUE;
                }
            }
        double secondSmallestNum = input[0];          
        for(int d=1; d<length; d++){
            if(secondSmallestNum>input[d]){
                secondSmallestNum = input[d];
            }
        }
        System.out.println(secondSmallestNum);
        }
    }
}
