import java.util.Scanner;

public class fib {

    public static int fibRec(int n){
        if (n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        else{
            return fibRec(n-1) + fibRec(n-2);

        }
    }

    public static int fibIter(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        
        int i=2;
        int[] sol = {0,1};
        while(i<n){
            int temp = sol[0] + sol[1]; 
            sol[0] = sol[1];
            sol[1] = temp;
            i++;
        }
        return (sol[0]+sol[1]);
    }

    public static void main(String[] args){
        System.out.println("Enter an int n to get the n'th Fib #: ");
        Scanner myScanner = new Scanner(System.in);
        int x = myScanner.nextInt();
        System.out.println("The " + x + "th Fibonacci number using fibonacciRecursive is " + fibRec(x));
        System.out.println("The " + x + "th Fibonacci number using fibonacciIterative is " + fibIter(x));
    }
    
}
