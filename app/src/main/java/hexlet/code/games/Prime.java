package hexlet.code.games;


import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;
import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;

public class Prime {
    private static final String TASK_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static Integer operand1;

    public static Integer getOperand1() {
        return operand1;
    }

    public static void setOperand1(Integer operand) {
        Prime.operand1 = operand;
    }

    public static void generateQuestionsAndAnswersPrime() {

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = generateAnswer();
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }

    private static String generateQuestion() {
        final int minValueNumber = 1;
        final int maxValueNumber = 100;

        setOperand1(getRandomNumberBetween(minValueNumber, maxValueNumber));

        return String.valueOf(getOperand1());
    }
    private static String generateAnswer() {

        for (int i = 2; i < getOperand1(); i++) {
            if (getOperand1() % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
