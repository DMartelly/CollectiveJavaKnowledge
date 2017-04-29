package sudoku;

/**
 * Created by Dominick Martelly on 4/26/2017 at 8:04 PM.
 *
 * @author Dominick Martelly
 */
enum SudokuDigit {
    ONE(1, '1'), TWO(2, '2'), THREE(3, '3'), FOUR(4, '4'), FIVE(5, '5'), SIX(6, '6'),
    SEVEN(7, '7'), EIGHT(8, '8'), NINE(9, '9'), BLANK(Integer.MIN_VALUE, '_');

    private final char displayCharacter;
    private final int value;

    SudokuDigit(int i, char c) {
        this.value = i;
        this.displayCharacter = c;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(displayCharacter);
    }
}
