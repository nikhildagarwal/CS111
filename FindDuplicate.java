/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author:
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 2 5 2 1 
 *  true
 *************************************************************************/

public class FindDuplicate {

    public static void main(String[] args) {
    int loop = args.length;
        int[] input = new int[loop];
        for(int i = 0; i<loop; i++){
            input[i] = Integer.parseInt(args[i]);
        }

        boolean result = false;
        for(int j =0; j<loop; j++){
            for(int k = 0; k<loop; k++){
                if(j != k){
                    if(input[j] == input[k]){
                        result = true;
                    }
                }
            }
            if(result == true){                 //end loop after first duplicate
                j = loop;
            }
        }
        System.out.println(result);
    }
}
