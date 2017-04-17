package sudoku;

/**
 * @author Dominick Martelly
 */
public class SudokuPuzzle {

    /**
     * @param args no arguments
     */
    public static void main(String[] args) {
        checkSudoku("1234567892345678913456789124567891235678912346"
                + "78912345789123456891234567912345678");
        checkSudoku("12345678912345678912345678912345678912345678"
                + "9123456789123456789123456789123456789");
        // A valid sudoku
        checkSudoku("25813764914698532779324685147286319558149273663"
                + "9571482315728964824619573967354218");
    }

    private static void checkSudoku(String sudokuString) {
        Sudoku mySudoku = new Sudoku(sudokuString);

        System.out.println("This puzzle is " + (mySudoku.isValid() ? "valid" : "invalid"));
        System.out.println(mySudoku);
        System.out.println("--------------------------------------------------\n");
    }
}
