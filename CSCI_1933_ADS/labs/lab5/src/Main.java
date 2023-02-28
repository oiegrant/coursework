public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        int count = 0;

        for(int i=0;i <3;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = ++count;
            }
        }
        Matrix mat1 = new Matrix(arr);
        System.out.println(mat1);
        Matrix mat2;
        mat2 = mat1.transpose();
        System.out.println(mat2);




    }
}