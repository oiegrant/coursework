import java.util.Arrays;

public class test {
    int[] arr = new int[10];

//    public test(){
//        this.arr = new int[]
//    }


    public static void arrayInit(int[] arr, int init){
        for(int i=0;i<arr.length;i++){
            arr[i] = init;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    public static void reset(int[] arr){
        for(int i=101;i<arr.length;i++){
            arr[i] = -1;
        }
        for(int i=0;i<arr.length;i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }

    public static void reverse(int[] arr){
        int[] temp = new int[arr.length];

        for(int i = 0;i<arr.length;i++){
            temp[i] = arr[arr.length-1-i];
        }

        for(int i=0;i<arr.length;i++) {
            System.out.println(i + ": " + temp[i]);
        }

    }



    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        test.reverse(arr);
    }



}
