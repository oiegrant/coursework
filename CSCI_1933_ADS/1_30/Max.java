public class Max {
    
    public static int RecMaxDig(int n){
        if (n<10){
            return n;
        }
        else{
            if ((n%10) >= ((n/10)%10)){
                int temp = ((n/100)*10)+(n%10);
                return (RecMaxDig(temp));
            }
            else{
                int temp = ((n/100)*10)+((n/10)%10);
                return (RecMaxDig(temp));
            }
        }
    }

    public static int IterMaxDig(int n){
        int sol = 0;
        while (n > 0){
            sol = Math.max(sol, n%10);
            n = n / 10;

        }
        return sol;
    }



    public static void main(String[] args){
        System.out.println("Recursive Solution");
        System.out.println(RecMaxDig(578));
        System.out.println(RecMaxDig(10));
        System.out.println(RecMaxDig(9999));
        System.out.println(RecMaxDig(13442));

        System.out.println("Iterative Solution");
        System.out.println(IterMaxDig(578));
        System.out.println(IterMaxDig(10));
        System.out.println(IterMaxDig(9999));
        System.out.println(IterMaxDig(13442));

    }
    
}
