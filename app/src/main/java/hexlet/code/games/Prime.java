package hexlet.code.games;


import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;
import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;

public class Prime {
    private static final String TASK_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void generateQuestionsAndAnswersPrime() {
        final int minValueNumber = 1;
        final int maxValueNumber = 100;

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int operand = getRandomNumberBetween(minValueNumber, maxValueNumber);
            questionsAndAnswers[i][0] = String.valueOf(operand);
            questionsAndAnswers[i][1] = generateAnswer(operand);
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }

    private static String generateAnswer(int operand) {

        for (int i = 2; i < operand; i++) {
            if (operand % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
