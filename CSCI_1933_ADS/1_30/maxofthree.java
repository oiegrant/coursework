public class maxofthree{
    public static void main(String[] args){
        int x,y,z;

        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);
        z = Integer.parseInt(args[2]);

        sol = Math.max(x,y);
        sol = Math.max(sol,z);

        return sol
    }



}