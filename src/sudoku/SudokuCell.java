package sudoku;

import java.util.Arrays;

import static sudoku.SudokuDigit.*;

/**
 * Created by Dominick on 4/28/2017.
 * <p>
 * A class representing a cell on a sudoku grid
 */
class SudokuCell {
    private SudokuDigit digit;
    private boolean[] possibleValues;

    SudokuCell() {
        digit = SudokuDigit.BLANK;
        possibleValues = new boolean[10];
    }

    SudokuCell(char c) {
        digit = charToDigit(c);
        possibleValues = new boolean[10];
        Arrays.fill(possibleValues, digit != SudokuDigit.BLANK);
    }

    void setAllPossibleValues() {
        Arrays.fill(possibleValues, true);
    }

    void removePossibleValue(int num) {
        possibleValues[num] = false;
    }

    private SudokuDigit charToDigit(char c) {
        switch (c) {
            case '1':
                return ONE;
            case '2':
                return TWO;
            case '3':
                return THREE;
            case '4':
                return FOUR;
            case '5':
                return FIVE;
            case '6':
                return SIX;
            case '7':
                return SEVEN;
            case '8':
                return EIGHT;
            case '9':
                return NINE;
            default:
                return BLANK;
        }
    }

    void setValue(char c) {
        digit = charToDigit(c);
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

    SudokuDigit getDigit() {
        return digit;
    }

    @Override
    public String toString() {
        return digit.toString();
    }

    public String printPossibaleVaules() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < possibleValues.length; i++) {
            if (possibleValues[i]) {
                result.append(i + 1).append(", ");
            }
        }
        if (result.length() > 1) {
            return result.substring(0, result.length() - 2);
        }
        return result.toString();
    }
}
