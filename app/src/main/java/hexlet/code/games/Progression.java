package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.runGame;

public class Progression {
    private static final String TASK_DESCRIPTION = "What number is missing in the progression?";
    private static String answer;


    public static String getAnswer() {
        return answer;
    }

    public static void setAnswer(String answer) {
        Progression.answer = answer;
    }
    public static void generateQuestionsAndAnswersProgression() {

        String[][] questionsAndAnswers = new String[3][2];

        for (int i = 0; i < 3; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = getAnswer();
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }
    private static String generateQuestion() {
//        random.nextInt(max - min + 1) + min
        int countNumber = new Random().nextInt(10 - 5 + 1) + 5;
        int positionForEllipses = new Random().nextInt(countNumber - 2 + 1) + 2;
        int startNumber = new Random().nextInt(20 - 1 + 1) + 1;
        int increment = new Random().nextInt(20 - 1 + 1) + 1;
        String result = startNumber + " ";
        for (int i = 1; i <= countNumber; i++) {
            if (i == (positionForEllipses - 1)) {
                result += ".. ";
                startNumber += increment;
                setAnswer(String.valueOf(startNumber));
                continue;
            }
            startNumber += increment;
            result += startNumber + " ";
        }
        return result;
    }
}
