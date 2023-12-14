package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.runGame;

public class MaxDivisor {
    private static final String TASK_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static Integer operand1;
    private static Integer operand2;
    public static void generateQuestionsAndAnswersMaxDivisor() {

        String[][] questionsAndAnswers = new String[3][2];

        for (int i = 0; i < 3; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = generateAnswer();
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }
    private static String generateQuestion() {
//        random.nextInt(max - min + 1) + min
        operand1 = new Random().nextInt((100 - 1 + 1) + 1);
        operand2 = new Random().nextInt((100 - 1 + 1) + 1);

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
