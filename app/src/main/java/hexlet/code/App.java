package hexlet.code;

import java.util.Scanner;
import static hexlet.code.Cli.greetUser;
import static hexlet.code.games.Calc.generateQuestionsAndAnswers;
import static hexlet.code.games.Even.runEvenGame;

public class App {
    public static void main(String[] args) {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit
                Your choice:""");
        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case 0:
                System.out.println("Bye!");
            case 1:
                greetUser();
                break;
            case 2:
                runEvenGame();
                break;
            case 3:
                generateQuestionsAndAnswers();
                break;
            default:
        }
        scanner.close();
    }


}
