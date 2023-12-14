package hexlet.code;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.Cli.greetUser;

public class Engine {
    private static boolean isCorrectResponse = true;

    public static final int COUNT_QUESTIONS = 3;
    public static final int OPTIONS_SIZE = 3;
    public static boolean isIsCorrectResponse() {
        return isCorrectResponse;
    }

    public static void setIsCorrectResponse(boolean isCorrectResp) {
        Engine.isCorrectResponse = isCorrectResp;
    }

    public static void runGame(String taskDescription, String[][] questionsAndCorrectAnswers) {

        greetUser();
        showTaskDescription(taskDescription);

        for (int i = 0; isIsCorrectResponse() && i < questionsAndCorrectAnswers.length; i++) {
            String question = questionsAndCorrectAnswers[i][0];
            String correctAnswer = questionsAndCorrectAnswers[i][1];

            String answer = askQuestion(question);
            setIsCorrectResponse(isResponseCorrect(answer, correctAnswer));
            if (!isIsCorrectResponse()) {
                System.out.print(generateMessageWrongAnswer(answer, correctAnswer));
                break;
            }
            System.out.println("Correct!");
            if (i == 2) {
                congratulate();
            }
        }
    }

    private static void showTaskDescription(String description) {
        System.out.println(description);
    }

    private static String askQuestion(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Question: " + question + "\n"
                + "Your answer: ");
        return scanner.next().trim();
    }

    public static boolean isResponseCorrect(String usersAnswer, String correctAnswer) {
        return usersAnswer.equals(correctAnswer);
    }

    public static String generateMessageWrongAnswer(String usersAnswer, String correctAnswer) {
        return "'" + usersAnswer + "' is wrong answer ;(. Correct answer was '"
                + correctAnswer + "'.\n"
                + "Let's try again, " + Cli.getUserName() + "!";
    }

    public static void congratulate() {
        System.out.println("Congratulations, " + Cli.getUserName() + "!");
    }

    public static int getRandomNumberBetween(int minNumber, int maxNumber) {
        return new Random().nextInt(maxNumber - minNumber + 1) + minNumber;
    }
}
