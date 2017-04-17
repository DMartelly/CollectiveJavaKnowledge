package sudoku;

/**
 * @author Dominick Martelly
 */
public class SudokuPuzzle {

    /**
     * @param args no arguments
     */
    public static void main(String[] args) {
        String config1 = "1234567892345678913456789124567891235678912346"
                + "78912345789123456891234567912345678";

        Sudoku mySudoku = new Sudoku(config1);

        if (mySudoku.isValid()) {
            System.out.println("This puzzle is valid.");
        } else {
            System.out.println("This puzzle is invalid.");
        }

        System.out.println(mySudoku);
        System.out.println("--------------------------------------------------");

        // Row Latin but column not Latin and with invalid subSquares
        String config2 = "12345678912345678912345678912345678912345678"
                + "9123456789123456789123456789123456789";
        mySudoku = new Sudoku(config2);
        if (mySudoku.isValid()) {
            System.out.println("This puzzle is valid.");
        } else {
            System.out.println("This puzzle is invalid.");
        }

        System.out.println(mySudoku);
        System.out.println("--------------------------------------------------");

        // A valid sudoku
        String config3 = "25813764914698532779324685147286319558149273663"
                + "9571482315728964824619573967354218";
        mySudoku = new Sudoku(config3);
        if (mySudoku.isValid()) {
            System.out.println("This puzzle is valid.");
        } else {
            System.out.println("This puzzle is invalid.");
        }
        System.out.println(mySudoku);
        System.out.println("--------------------------------------------------");
    }
}
