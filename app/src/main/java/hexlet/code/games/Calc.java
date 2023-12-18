package hexlet.code.games;

import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;

public class Calc {
    private static Integer operand1;
    private static Integer operand2;
    private static String operation;

    private static final String TASK_DESCRIPTION = "What is the result of the expression?";

    public static void generateQuestionsAndAnswersCalcGame() {

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = generateAnswer();
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }

    private static String generateQuestion() {
        final int minValueOperand = 1;
        final int maxValueOperand = 10;
        final int maxValueOperation = 3;

        final int addition = 1;
        final int subtraction = 2;
        final int multiplication = 3;

        operand1 = getRandomNumberBetween(minValueOperand, maxValueOperand);
        operand2 = getRandomNumberBetween(minValueOperand, maxValueOperand);
        switch (getRandomNumberBetween(minValueOperand, maxValueOperation)) {
            case addition:
                operation = "+";
                break;
            case subtraction:
                operation = "-";
                break;
            case multiplication:
                operation = "*";
                break;
            default:
        }
        return operand1 + " " + operation + " " + operand2;
    }

    private static String generateAnswer() {
        int answer = 0;
        switch (operation) {
            case "+":
                answer = operand1 + operand2;
                break;
            case "-":
                answer = operand1 - operand2;
                break;
            case "*":
                answer = operand1 * operand2;
                break;
            default:
        }
        return String.valueOf(answer);
    }
}

