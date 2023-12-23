package hexlet.code.games;

import static hexlet.code.Utils.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;


public class MaxDivisor {
    private static final String TASK_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    public static void generateQuestionsAndAnswersMaxDivisor() {
        final int minNumber = 1;
        final int maxNumber = 10;

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int operand1 = getRandomNumberBetween(minNumber, maxNumber);
            int operand2 = getRandomNumberBetween(minNumber, maxNumber);

            questionsAndAnswers[i][0] = operand1 + " " + operand2;
            questionsAndAnswers[i][1] = String.valueOf(generateAnswer(operand1, operand2));
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }

    private static int generateAnswer(int operand1, int operand2) {
        int maxDivisor = 1;
        int counter = Math.min(operand1, operand2);
        for (int i = 2; i <= counter; i++) {
            if ((operand1 % i == 0) && (operand2 % i == 0)) {
                maxDivisor = i;
            }
        }
        return maxDivisor;
    }
}
