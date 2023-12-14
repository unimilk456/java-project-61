package hexlet.code.games;

import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;

public class Calc {
    private static Integer operand1;
    private static Integer operand2;
    private static String operation;

    public static Integer getOperand1() {
        return operand1;
    }

    public static void setOperand1(Integer operand) {
        Calc.operand1 = operand;
    }

    public static String getOperation() {
        return operation;
    }

    public static void setOperation(String operationType) {
        Calc.operation = operationType;
    }

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




        setOperand1(getRandomNumberBetween(minValueOperand, maxValueOperand));
        setOperand2(getRandomNumberBetween(minValueOperand, maxValueOperand));
        switch (getRandomNumberBetween(minValueOperand, maxValueOperation)) {
            case addition:
                setOperation("+");
                break;
            case subtraction:
                setOperation("-");
                break;
            case multiplication:
                setOperation("*");
                break;
            default:
        }
        return getOperand1() + " " + getOperation() + " " + getOperand2();
    }

    private static String generateAnswer() {
        int answer = 0;
        switch (getOperation()) {
            case "+":
                answer = getOperand1() + getOperand2();
                break;
            case "-":
                answer = getOperand1() - getOperand2();
                break;
            case "*":
                answer = getOperand1() * getOperand2();
                break;
            default:
        }
        return String.valueOf(answer);
    }

    public static Integer getOperand2() {
        return operand2;
    }

    public static void setOperand2(Integer operand) {
        Calc.operand2 = operand;
    }
}

