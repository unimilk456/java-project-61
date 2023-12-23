package hexlet.code;

import java.util.Scanner;

import static hexlet.code.App.getScanner;


public class Engine {
    private static String userName;
    private static boolean isCorrectResponse = true;

    public static final int COUNT_QUESTIONS = 3;
    public static final int OPTIONS_SIZE = 3;
    public static void runGame(String taskDescription, String[][] questionsAndCorrectAnswers) {

        greetUser();
        System.out.println(taskDescription);
        Scanner scanner = getScanner();
        for (int i = 0; isCorrectResponse && i < questionsAndCorrectAnswers.length; i++) {
            String question = questionsAndCorrectAnswers[i][0];
            String correctAnswer = questionsAndCorrectAnswers[i][1];

            System.out.print("Question: " + question + "\n"
                    + "Your answer: ");
            String answer = scanner.next().trim();

            isCorrectResponse = answer.equals(correctAnswer);

            if (!isCorrectResponse) {
                System.out.print(generateMessageWrongAnswer(answer, correctAnswer));
                break;
            }
            System.out.println("Correct!");
            if (i == 2) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }

    public static String generateMessageWrongAnswer(String usersAnswer, String correctAnswer) {
        return "'" + usersAnswer + "' is wrong answer ;(. Correct answer was '"
                + correctAnswer + "'.\n"
                + "Let's try again, " + userName + "!";
    }

    public static void greetUser() {
        Scanner scanner = getScanner();

        System.out.print("Welcome to the Brain Games! \n"
                + "May I have your name? ");

        String name = scanner.next().trim();
        userName = name;

        System.out.println("Hello, " + name + "!");
    }
}
