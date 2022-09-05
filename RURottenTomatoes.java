/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author:
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);        //puts inputs in an array
            int column = Integer.parseInt(args[1]);
            int[][] review = new int[row][column];
            int input = 2;
            for(int i =0; i<row; i++){
                for(int j =0; j<column; j++){
                    review[i][j] = Integer.parseInt(args[input]);
                    input++;
                }
            }
        
            int[] sum = new int[column];        //sums up the columns
            int total = 0;
            for(int k =0; k<column; k++){
                for(int p=0; p<row; p++){
                    total = total + review[p][k];
                }
                sum[k] = total;
                total = 0;
            }
        
            int index = 0;                //prints index with greatest sum
            for(int t=1; t<column; t++){
                if(sum[t]>sum[index]){
                    index = t;
                    }
            }
            System.out.println(index);
    }
}
