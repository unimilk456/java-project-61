package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.runGame;

public class MaxDivisor {
    private static final String TASK_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static Integer operand1;
    private static Integer operand2;


    public static Integer getOperand1() {
        return operand1;
    }

    public static void setOperand1(Integer operand1) {
        MaxDivisor.operand1 = operand1;
    }

    public static Integer getOperand2() {
        return operand2;
    }

    public static void setOperand2(Integer operand2) {
        MaxDivisor.operand2 = operand2;
    }
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
        setOperand1(new Random().nextInt(100 - 1 + 1) + 1);
        setOperand2(new Random().nextInt(100 - 1 + 1) + 1);

        return getOperand1() + " " + getOperand2();
    }
    private static String generateAnswer() {
        int maxDivisor = 1;
        int counter = Math.min(getOperand1(), getOperand2());
        for (int i = 2; i <= counter; i++) {
            if ((getOperand1() % i == 0) && (getOperand2() % i == 0)) {
                maxDivisor = i;
            }
        }
        return String.valueOf(maxDivisor);
    }
}
