package hexlet.code.games;

import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;


public class MaxDivisor {
    private static final String TASK_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static Integer operand1;
    private static Integer operand2;
    public static void generateQuestionsAndAnswersMaxDivisor() {
        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = generateAnswer();
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }
    private static String generateQuestion() {
        final int minNumber = 1;
        final int maxNumber = 10;

        operand1 = getRandomNumberBetween(minNumber, maxNumber);
        operand2 = getRandomNumberBetween(minNumber, maxNumber);

        return operand1 + " " + operand2;
    }
    private static String generateAnswer() {
        int maxDivisor = 1;
        int counter = Math.min(operand1, operand2);
        for (int i = 2; i <= counter; i++) {
            if ((operand1 % i == 0) && (operand2 % i == 0)) {
                maxDivisor = i;
            }
        }
        return String.valueOf(maxDivisor);
    }
}
