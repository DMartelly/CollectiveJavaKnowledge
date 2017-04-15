package quiz;

import javax.swing.*;

/**
 * @author Dominick Martelly
 */
public class Quiz {

    private static int questions = 0;

    public static void main(String[] args) {

        int correctAnswers = 0;

        //Question 1
        if (choiceQuestion("Which is the Apollo mission what landed Neal and Buzz on the moon?",
                1, "Apollo 11", "Apollo 12", "Apollo 13", "Apollo 14")) correctAnswers++;

        //Question 2
        if (trueOrFalseQuestion("Another name for a Zebra is a Horse", false)) correctAnswers++;

        //Question 3
        if (question("George Washington's horse's name was ______.", "nelson")) correctAnswers++;

        //Question 4
        if (trueOrFalseQuestion("Like Java and Ruby, Diamond is a programming language.", true))
            correctAnswers++;

        //Question 5
        if (question("The color _ _ _ _ _ is actually the color of mirrors", "green")) correctAnswers++;

        //Question 6
        if (question("Java was first released in the year _ _ _ _", "1995")) correctAnswers++;

        //Question 7
        if (choiceQuestion("Which of these is not a variety of apple?", 5,
                "Almata", "Delblush", "Granny Smith", "Toko", "Unity")) correctAnswers++;

        //Question 8
        if (trueOrFalseQuestion("Are you a Human being?", true)) correctAnswers++;

        //Question 9
        if (question("The four string instrument with a lower octave than a guitar is a _ _ _ _",
                "bass")) correctAnswers++;

        //Question 10
        if (choiceQuestion("A Photon is currently known as a (an)", 2,
                "Wave", "Wave-particle", "Particle", "Anomaly", "Flashlight")) correctAnswers++;


        //Summary
        System.out.println("You have answered " + correctAnswers + " correctly out of " +
                questions + " question(s).");

        int wrong = questions - correctAnswers;
        System.out.println("You have answered " + wrong + " incorrectly");
        if (wrong == 0) System.out.println("Congratulations! :)");
    }

    private static boolean question(String question, String answer) {
        questions++;
        Question myQuestion = new Question();
        myQuestion.setQuestion(question);
        myQuestion.setAnswer(answer);
        System.out.println(myQuestion);

        String response = JOptionPane.showInputDialog("What is your answer?");


        return result(myQuestion, response);
    }

    private static boolean trueOrFalseQuestion(String question, boolean answer) {
        questions++;
        TrueFalseQuestion myQuestion = new TrueFalseQuestion();
        myQuestion.setQuestion(question);
        myQuestion.setAnswer(answer);
        System.out.println(myQuestion);

        String response = JOptionPane.showInputDialog("What is your answer? (T or F)");
        while (!(response.equalsIgnoreCase("F") || response.equalsIgnoreCase("T"))) {
            response = JOptionPane.showInputDialog("Error, please try again... (T or F)");
        }
        response = response.equalsIgnoreCase("T") ? "True" : "False";

        return result(myQuestion, response);
    }

    private static boolean choiceQuestion(String question, int correctAnswer, String... choices) {
        questions++;
        ChoiceQuestion myQuestion = new ChoiceQuestion();
        myQuestion.setQuestion(question);
        int ans = 1;
        for (String choice : choices) {
            myQuestion.addChoice(choice, ans == correctAnswer);
            ans++;
        }
        System.out.println(myQuestion);

        String response = JOptionPane.showInputDialog("What is your choice? (1-" + myQuestion.numOfChoices() + ")");
        while (Integer.parseInt(response) < 1 || Integer.parseInt(response) > myQuestion.numOfChoices()) {
            response = JOptionPane.showInputDialog("Error, please try again...");
        }

        return result(myQuestion, response);
    }

    private static boolean result(Question question, String response) {
        boolean correct = question.checkAnswer(response);
        System.out.println("Your response \"" + response + "\" is " + (correct ? "correct" : "incorrect"));
        System.out.println("-------------------\n\n");
        return correct;
    }
}