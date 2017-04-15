package quiz;

import java.util.ArrayList;

/**
 * A question with multiple choices.
 */
class ChoiceQuestion extends Question {

    private class Choice {

        String choice;
        boolean correct;
        int number;

        Choice(String choice, boolean correct, int number) {
            this.choice = choice;
            this.correct = correct;
            this.number = number;
        }

    }

    private ArrayList<Choice> choices;

    ChoiceQuestion() {
        choices = new ArrayList<>();
    }

    /**
     * Adds an answer choice to this question.
     *
     * @param answer  the choice to add
     * @param correct true if this is the correct answer, false otherwise
     */
    void addChoice(String answer, boolean correct) {
        Choice choice = new Choice(answer, correct, choices.size() + 1);
        choices.add(choice);
        if (correct) setAnswer(answer);
    }

    int numOfChoices() {
        return choices.size();
    }

    @Override
    boolean checkAnswer(String number) {
        String response = this.choices.get(Integer.parseInt(number) - 1).choice;
        return super.checkAnswer(response);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString()).append("\n");

        choices.forEach(c -> result.append(c.number).append(". ")
                .append(c.choice).append("\n"));
        return result.toString();
    }
}
