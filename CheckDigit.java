/*************************************************************************
 *  Compilation:  javac CheckDigit.java
 *  Execution:    java CheckDigit 020131452
 *
 *  @author:
 *
 *  Takes a 12 or 13 digit integer as a command line argument, then computes
 *  and displays the check digit
 *
 *  java CheckDigit 048231312622
 *  0
 *
 *  java CheckDigit 9780470458310
 *  0
 * 
 *  java CheckDigit 9780470454310
 *  8
 * 
 *  Print only the check digit character, nothing else.
 *
 *************************************************************************/

public class CheckDigit {

    public static void main (String[] args) {
    long number = Long.parseLong(args[0]);
        int counter = 0;
        int length = (int) (Math.log10(number) + 1);    //gets length of input using powers of 10
        long[] digit = new long[length];                 //initialize long array length of the input

        long z = 0;                                 //assign each digit a spot in array in reverse order
        for(int i = 1; i<=length; i++) {                
            long x = number % 10;
            digit[counter] = x;
            number = number / 10;
            counter++;
        }
        
        int counter2 = 0;                   //these two forloops do the math
        long firstNum = 0; 
        for(int j = 1; j<=(length/2)+(length%2); j++){
            firstNum = firstNum + digit[counter2];
            counter2 +=2;
        }
        firstNum = firstNum % 10;
        
        int counter3 = 1;
        long secondNum = 0;
        for(int k = 1; k<=(length/2); k++){
            secondNum = secondNum + digit[counter3];
            counter3 +=2;
        }
        secondNum = secondNum % 10;
        secondNum = (secondNum*3)%10;
        
        long finalNum = (firstNum + secondNum)%10;           //print our final number
        System.out.println(finalNum);
    }
}
