package sudoku;

/**
 * Created by Dominick Martelly on 4/26/2017 at 8:04 PM.
 *
 * @author Dominick Martelly
 */
enum SudokuDigit {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, BLANK;

    public static SudokuDigit getDigit(char c) {
        switch (c) {
            case '_':
                return BLANK;
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
                throw new IllegalArgumentException("The character entered is not valid");
        }
    }

    static int getValue(SudokuDigit d) {
        switch (d) {
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            default:
                return Integer.MIN_VALUE;
        }
    }


    public static char getChar(SudokuDigit d) {
        switch (d) {
            case ONE:
                return '1';
            case TWO:
                return '2';
            case THREE:
                return '3';
            case FOUR:
                return '4';
            case FIVE:
                return '5';
            case SIX:
                return '6';
            case SEVEN:
                return '7';
            case EIGHT:
                return '8';
            case NINE:
                return '9';
            case BLANK:
                return '_';
            default:
                return 'F';
        }
    }
}
