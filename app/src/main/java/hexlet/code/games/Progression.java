package hexlet.code.games;

import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;
import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;

public class Progression {
    private static final String TASK_DESCRIPTION = "What number is missing in the progression?";
    private static final int MAX_NUMBER_IN_PROGRESSION = 10;
    private static final int MIN_NUMBER_IN_PROGRESSION = 5;

    private static final int MIN_POSITION_FOR_ELLIPSES = 2;

    private static final int MIN_START_NUMBER_PROGRESSION = 1;
    private static final int MAX_START_NUMBER_PROGRESSION = 20;

    private static final int MIN_INCREMENT = 1;
    private static final int MAX_INCREMENT = 20;
    private static String answer;

    public static void generateQuestionsAndAnswersProgression() {

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];


        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int countNumberInProgression = getRandomNumberBetween(MIN_NUMBER_IN_PROGRESSION, MAX_NUMBER_IN_PROGRESSION);
            int positionForEllipses = getRandomNumberBetween(MIN_POSITION_FOR_ELLIPSES, countNumberInProgression);
            int startNumber = getRandomNumberBetween(MIN_START_NUMBER_PROGRESSION, MAX_START_NUMBER_PROGRESSION);
            int increment = getRandomNumberBetween(MIN_INCREMENT, MAX_INCREMENT);

            questionsAndAnswers[i][0] = generateQuestions(startNumber, increment, positionForEllipses, countNumberInProgression);
            questionsAndAnswers[i][1] = answer;
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }
    public static String generateQuestions(int startNumber, int increment, int positionForEllipses, int countNumberInProgression) {

        int[] progression = generateProgression(startNumber, increment, countNumberInProgression);
        answer = String.valueOf(progression[positionForEllipses - 1]);

        StringBuilder progressionAsString = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == (positionForEllipses - 1)) {
                progressionAsString.append(".. ");
                continue;
            }
            progressionAsString.append(progression[i]).append(" ");
        }
        return progressionAsString.toString();
    }
    public static int[] generateProgression(int startNumber, int increment, int countNumberInProgression) {
        int[] progression = new int[countNumberInProgression];
        progression[0] = startNumber;
        for (int i = 1; i < countNumberInProgression; i++) {
            startNumber += increment;
            progression[i] = startNumber;
        }
        return progression;
    }
}
