package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.greetUser;
import static hexlet.code.games.Calc.generateQuestionsAndAnswersCalcGame;
import static hexlet.code.games.Even.generateQuestionsAndAnswersEven;
import static hexlet.code.games.MaxDivisor.generateQuestionsAndAnswersMaxDivisor;
import static hexlet.code.games.Prime.generateQuestionsAndAnswersPrime;
import static hexlet.code.games.Progression.generateQuestionsAndAnswersProgression;

public class App {
    public static void main(String[] args) {
        final int greet = 1;
        final int even = 2;
        final int calc = 3;
        final int gcd = 4;
        final int progression = 5;
        final int prime = 6;
        final int exit = 0;

        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:""");
        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case exit:
                System.out.println("Bye!");
                break;
            case greet:
                greetUser();
                break;
            case even:
                generateQuestionsAndAnswersEven();
                break;
            case calc:
                generateQuestionsAndAnswersCalcGame();
                break;
            case gcd:
                generateQuestionsAndAnswersMaxDivisor();
                break;
            case progression:
                generateQuestionsAndAnswersProgression();
                break;
            case prime:
                generateQuestionsAndAnswersPrime();
                break;
            default:
        }
        scanner.close();
    }


}
