/*çok boyutlu diziler ile oluşturulmuş matrisin transpozunu bulan program
  Matris : 
2    3    4    
5    6    4    
Transpoze : 
2    5    
3    6    
4    4    
 **/
public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix = {{2, 3, 4}, {5, 6, 4}};

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] transpose = new int[columns][rows];

        // Find the transpose of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        // Print the original matrix
        System.out.println("Matrix:");
        printMatrix(matrix);

        // Print the transpose matrix
        System.out.println("Transpose:");
        printMatrix(transpose);
    }

    // Helper method to print a matrix
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
