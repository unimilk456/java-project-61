package hexlet.code;

import java.util.Random;
import java.util.Scanner;


public class Engine {
    private static String userName;
    private static boolean isCorrectResponse = true;

    public static final int COUNT_QUESTIONS = 3;
    public static final int OPTIONS_SIZE = 3;
    public static void runGame(String taskDescription, String[][] questionsAndCorrectAnswers) {

        greetUser();
        showTaskDescription(taskDescription);

        for (int i = 0; isCorrectResponse && i < questionsAndCorrectAnswers.length; i++) {
            String question = questionsAndCorrectAnswers[i][0];
            String correctAnswer = questionsAndCorrectAnswers[i][1];

            String answer = askQuestion(question);
            isCorrectResponse = isResponseCorrect(answer, correctAnswer);
            if (!isCorrectResponse) {
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
                + "Let's try again, " + userName + "!";
    }

    public static void congratulate() {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static int getRandomNumberBetween(int minNumber, int maxNumber) {
        return new Random().nextInt(maxNumber - minNumber + 1) + minNumber;
    }
    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games! \n"
                + "May I have your name? ");

        String name = scanner.next().trim();
        userName = name;

        System.out.println("Hello, " + name + "!");
    }
}
