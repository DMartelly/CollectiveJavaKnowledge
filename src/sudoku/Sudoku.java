package sudoku;

/**
 * @author Dominick Martelly
 */
class Sudoku {

    private SudokuDigit[][] sudokuBoard = new SudokuDigit[9][9];

    /**
     * Parses an 81 character string into a 2D string array (sudoku board)
     *
     * @param listOfNumbers the numbers of the sudoku board in from left to right
     */
    Sudoku(String listOfNumbers) {
        if (listOfNumbers.length() != 81) {
            throw new IllegalArgumentException("The string length is not 81 chars");
        }
        int k = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuBoard[i][j] = SudokuDigit.getDigit(listOfNumbers.charAt(k));
                k++;
            }
        }
    }

    /**
     * Prints a full sudoku board
     *
     * @return Prints the Sudoku board as a string in full layout
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if ((i == 3) || (i == 6)) {
                result.append("=================\n");
            }
            for (int j = 0; j < 9; j++) {
                if ((j == 3) || (j == 6)) {
                    result.append(" || ");
                }
                result.append(SudokuDigit.getValue(sudokuBoard[i][j]));
            }
            result.append("\n");
        }
        return result.toString();
    }


    /**
     * Checks if the Sudoku puzzle is valid for trial
     *
     * @return True iff the Sudoku board meets rules/specifications
     */
    boolean isValid() {
        return areRowsAndColumnsLatin() && areSubSquaresLatin();
    }

    /**
     * Checks to see if all rows are Latin
     *
     * @return If all columns are Latin, returns a boolean true
     */
    private boolean areRowsAndColumnsLatin() {
        int sumOfRows = 0;
        int sumOfColumns = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sumOfRows += SudokuDigit.getValue(sudokuBoard[i][j]);
                sumOfColumns += SudokuDigit.getValue(sudokuBoard[j][i]);
            }
            if (sumOfRows != 45 || sumOfColumns != 45) {
                return false;
            }
            sumOfRows = 0;
            sumOfColumns = 0;
        }
        return true;
    }

    /**
     * Checks to see if all subSquares for the sudoku puzzle are Latin
     *
     * @return if all subSquares are Latin, returns boolean true
     */
    private boolean areSubSquaresLatin() {
        for (int i = 0; i < 9; i++) {
            if (!isValidSubSquare(getQuadrant(i))) {//when i == 1
                return false;
            }
        }
        return true;
    }

    private boolean isValidSubSquare(int[][] quadrant) {
        int sumOfQuadrant = 0;
        for (int[] row : quadrant) {
            for (int num : row) {
                sumOfQuadrant += num;
            }
        }
        return sumOfQuadrant == 45;
    }


    private int[][] getQuadrant(int quadrantNumber) {
        int[][] result = new int[3][3];
        int startRow = (quadrantNumber / 3) * 3;
        int startColumn = (quadrantNumber % 3) * 3;
        int i1 = 0, j1 = 0;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                result[i1][j1] = SudokuDigit.getValue(sudokuBoard[i][j]);
                j1++;
            }
            i1++;
            j1 = 0;
        }
        return result;
    }

}
