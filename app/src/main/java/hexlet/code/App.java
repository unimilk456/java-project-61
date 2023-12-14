package hexlet.code;

import java.util.Scanner;
import static hexlet.code.Cli.greetUser;
import static hexlet.code.games.Calc.generateQuestionsAndAnswersCalcGame;
import static hexlet.code.games.Even.generateQuestionsAndAnswersEven;
import static hexlet.code.games.MaxDivisor.generateQuestionsAndAnswersMaxDivisor;
import static hexlet.code.games.Prime.generateQuestionsAndAnswersPrime;
import static hexlet.code.games.Progression.generateQuestionsAndAnswersProgression;

public class App {
    public static void main(String[] args) {
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
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                greetUser();
                break;
            case 2:
                generateQuestionsAndAnswersEven();
                break;
            case 3:
                generateQuestionsAndAnswersCalcGame();
                break;
            case 4:
                generateQuestionsAndAnswersMaxDivisor();
                break;
            case 5:
                generateQuestionsAndAnswersProgression();
                break;
            case 6:
                generateQuestionsAndAnswersPrime();
                break;
            default:
        }
        scanner.close();
    }


}
