package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.runGame;

public class Calc {
    private static Integer operand1;
    private static Integer operand2;
    private static String operation;

    private static final String TASK_DESCRIPTION = "What is the result of the expression?";

    public static void generateQuestionsAndAnswers() {

        String[][] questionsAndAnswers = new String [3][2];

        for (int i = 0; i < 3; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = generateAnswer(operand1, operand2, operation);
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }

    private static String generateQuestion() {

        operand1 = new Random().nextInt(10 + 1);
        operand2 = new Random().nextInt(10 + 1);
        switch (new Random().nextInt(3 - 1 + 1) + 1) {
            case 1:
                operation = "+";
                break;
            case 2:
                operation = "-";
                break;
            case 3:
                operation = "*";
                break;
            default:
        }
        return operand1 + " " + operation + " " + operand2;
    }
    private static String generateAnswer(Integer operand1, Integer operand2, String operation) {
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
