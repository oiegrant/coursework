public class powerK {
    int k;
    int n;
    public powerK(){}

    public static int funcRec(int k, int n){
        if(n == 0){
            return 1;
        }
        else{
            return k * funcRec(k,n-1);
        }
    }
    public static int funcIter(int k, int n){
        int temp = 1;
        for(int i=0; i<n; i++){
            temp *= k;
        }
        return temp;

    }



    public static void main(String[] args){
        powerK obj = new powerK();
        int k = 5;
        int n = 5;
        int x;
        int y;

        x = obj.funcRec(k,n);
        System.out.println("Recursive Solution " + x);
        y = obj.funcIter(k,n);
        System.out.println("Iterative Solution " + y);


    }
}
