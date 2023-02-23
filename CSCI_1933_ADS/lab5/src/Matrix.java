public class Matrix {
    private int nrows;
    private int ncols;
    private int[][] matrix;

    public Matrix(int nrows, int ncols){
        this.nrows=nrows;
        this.ncols=ncols;
        matrix = new int[nrows][ncols];
    }

    public Matrix(int[][] arr){
        nrows = arr.length;
        ncols = arr[0].length;
        matrix = new int[nrows][ncols];
        for(int i=0; i<arr.length;i++){
            for (int j=0; j<arr[i].length;j++){
                matrix[i][j] = arr[i][j];
            } // col loop
        } //  row loop
    }

    public Matrix transpose(){
        int tempRows = ncols;
        int tempCols = nrows;
        Matrix matrixTranspose = new Matrix(tempRows,tempCols);
        for(int i=0;i<nrows;i++){
            for(int j=0;j<ncols;j++){
                matrixTranspose.matrix[j][i] = matrix[i][j];
            }
        }
        return matrixTranspose;
    }

    public String toString(){
        String temp = "";
        for(int i=0;i<nrows;i++){
            for(int j=0;j<ncols;j++){
              temp += String.valueOf(matrix[i][j]);
            }
            temp += "\n";
        }
        return temp;

    }



}
