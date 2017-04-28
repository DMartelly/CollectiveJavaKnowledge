package sudoku;

import java.util.Arrays;

/**
 * Created by Dominick on 4/28/2017.
 * <p>
 * A class representing a cell on a sudoku grid
 */
public class SudokuCell {
    private SudokuDigit digit;
    private boolean[] possibleValues;

    SudokuCell() {
        digit = SudokuDigit.BLANK;
        possibleValues = new boolean[10];
        Arrays.fill(possibleValues, false);
    }

    void setValue(char c) {
        digit = SudokuDigit.getDigit(c);
    }

    String getPossibleValues() {
        StringBuilder values = new StringBuilder();
        for (int i = 0; i < possibleValues.length; i++) {
            if (possibleValues[i]) {
                values.append(i);
            }
        }
        return values.toString();
    }
}
