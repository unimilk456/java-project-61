package hexlet.code.games;

import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;

public class Calc {
    private static final Integer MIN_VALUE_OPERAND = 1;
    private static final Integer MAX_VALUE_OPERAND = 10;
    private static final Integer MIN_VALUE_OPERATION = 0;

    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static final int MAX_VALUE_OPERATION = OPERATIONS.length - 1;
    private static final String TASK_DESCRIPTION = "What is the result of the expression?";

    public static void generateQuestionsAndAnswersCalcGame() {

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int operand1 = getRandomNumberBetween(MIN_VALUE_OPERAND, MAX_VALUE_OPERAND);
            int operand2 = getRandomNumberBetween(MIN_VALUE_OPERAND, MAX_VALUE_OPERAND);
            String operation = OPERATIONS[getRandomNumberBetween(MIN_VALUE_OPERATION,  MAX_VALUE_OPERATION)];

            questionsAndAnswers[i][0] = operand1 + " " + operation + " " + operand2;
            questionsAndAnswers[i][1] = String.valueOf(generateAnswer(operand1, operand2, operation));
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }


    private static int generateAnswer(int operand1, int operand2, String operation) {
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
        return answer;
    }
}

