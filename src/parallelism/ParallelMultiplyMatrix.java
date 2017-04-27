package parallelism;

/**
 * Created by Dominick Martelly on 4/20/2016 at 4:26 PM.
 *
 * @author Dominick Martelly
 */
public class ParallelMultiplyMatrix implements Runnable {

    private int[][] matrix;
    private int[][] matrix2;
    private int[][] resultMatrix;

    /**
     * The Constructor
     *
     * @param matrix the repeated string
     */
    ParallelMultiplyMatrix(int[][] matrix) {
        this.matrix = matrix;

        this.matrix2 = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix2[i][j] = matrix[i][j];

        resultMatrix = new int[matrix.length][matrix.length];
    }

    @Override
    public void run() {
        int i = (int) Thread.currentThread().getId() % Runtime.getRuntime().availableProcessors();
        //System.out.println("Thread " + i + " is on the way");
        while (i < matrix.length * matrix.length) {
            for (int j = 0; j < matrix.length; j++)
                resultMatrix[i / matrix.length][i % matrix.length] += resultMatrix[i / matrix.length][j] * matrix[j][i % matrix.length];
            i += Runtime.getRuntime().availableProcessors();
        }
        for (int k = 0; k < matrix2.length; k++)
            System.arraycopy(resultMatrix[i], 0, matrix2[i], 0, matrix2[i].length);
    }

    int[][] getResultMatrix() {
        return resultMatrix;
    }
}
