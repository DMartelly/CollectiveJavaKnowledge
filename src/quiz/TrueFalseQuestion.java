package quiz;

/**
 * A question with a True or false answer.
 *
 * @author Dominick Martelly
 */
class TrueFalseQuestion extends Question {

    /**
     * Sets the answer to true or false
     *
     * @param isCorrect The correct answer for the question
     */
    void setAnswer(boolean isCorrect) {
        setAnswer(isCorrect ? "True" : "False");
    }
}
