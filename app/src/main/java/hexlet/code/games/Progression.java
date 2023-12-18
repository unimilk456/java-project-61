package hexlet.code.games;

import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;
import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;

public class Progression {
    private static final String TASK_DESCRIPTION = "What number is missing in the progression?";
    private static String answer;


    public static String getAnswer() {
        return answer;
    }

    public static void setAnswer(String userAnswer) {
        Progression.answer = userAnswer;
    }
    public static void generateQuestionsAndAnswersProgression() {

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = getAnswer();
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }
    private static String generateQuestion() {
        final int maxNumberInProgression = 10;
        final int minNumberInProgression = 5;

        final int minPositionForEllipses = 2;

        final int minStartNumberProgression = 1;
        final int maxStartNumberProgression = 20;

        final int minIncrement = 1;
        final int maxIncrement = 20;

        int countNumberInProgression = getRandomNumberBetween(minNumberInProgression, maxNumberInProgression);
        int positionForEllipses = getRandomNumberBetween(minPositionForEllipses, countNumberInProgression);
        int startNumber = getRandomNumberBetween(minStartNumberProgression, maxStartNumberProgression);
        int increment = getRandomNumberBetween(minIncrement, maxIncrement);

        StringBuilder result = new StringBuilder(startNumber + " ");
        for (int i = 1; i <= countNumberInProgression; i++) {
            if (i == (positionForEllipses - 1)) {
                result.append(".. ");
                startNumber += increment;
                setAnswer(String.valueOf(startNumber));
                continue;
            }
            startNumber += increment;
            result.append(startNumber).append(" ");
        }
        return result.toString();
    }
}
