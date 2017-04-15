package quiz;

/**
 * @author Dominick Martelly
 */

class Question {

    private String question;
    private String answer;

    Question() {

    }

    /**
     * Sets the question text.
     *
     * @param questionText the text of this question
     */
    void setQuestion(String questionText) {
        question = questionText;
    }

    /**
     * Sets the answer for this question.
     *
     * @param correctResponse the answer
     */
    void setAnswer(String correctResponse) {
        answer = correctResponse;
    }

    /**
     * Checks a given response for correctness.
     *
     * @param response the response to check
     * @return true if the response was correct, false otherwise
     */
    boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(answer);
    }

    @Override
    public String toString() {
        return this.question;
    }
}
