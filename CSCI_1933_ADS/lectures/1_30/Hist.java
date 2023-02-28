import java.util.Scanner;


public class Hist{
    private int lower;
    private int upper;
    private int[] a;

    public Hist(int L, int U){
        if (L>U){
            lower = U;
            upper = L;
            System.out.println("lower is " + lower + "upper is" + upper);
        }
        else{                    
        lower = L;
        upper = U;
        }
        a = new int[upper-lower+1];

    }

    public boolean add(int i){
        if (i >= lower && i<= upper){
            a[i-lower]++;
            // System.out.println(a[i-lower]);
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String finalstring = "";

        for(int i=0; i < a.length; i++){
            String temp = (i+lower) + ": ";
            for(int j=0; j<a[i];j++){
                temp = temp + "*";
            }
            temp = temp + "\n";
            finalstring = finalstring + temp ;
        }
        return finalstring;
    }


    public static void main(String[] args){
        // Hist histo = new Hist(0, 5);
        // histo.add(3);
        // histo.add(2);
        // histo.add(1);
        // histo.add(2);
        // histo.add(3);
        // histo.add(0);
        // histo.add(1);
        // histo.add(5);
        // histo.add(3);
        // System.out.println(histo);
        System.out.println("__Histogram Console__\n" + "Options\n" +
        "add - used to add numbers to the histogram\n"
        + "print - prints the histogram to the screen\n"
        + "quit - leaves the program\n\n" 
        );
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Enter a lower bound: ");
        int L = myScanner.nextInt();
        System.out.println("Enter a upper bound: ");
        int U = myScanner.nextInt();
        Hist histo = new Hist(L, U);
        
        String entry = "print";
        do{
            System.out.println("Enter a command: ");
            entry = myScanner.next();
            System.out.println("entry is " + entry );

            if(entry.equals("add")){
                System.out.println("Enter a number: ");
                int adder = myScanner.nextInt();
                if (histo.add(adder)){
                    continue;
                }
                else{
                    System.out.println(adder + " is not in range");
                }
            }
            else if(entry.equals("print")){
                System.out.println(histo);

            }
            else if(entry.equals("quit")){
                System.out.println("Bye!");
                continue;
            }
            else{
                System.out.print("Incorrect menu option\n");
            }


        }while(!entry.equals("quit")); 

    }
}