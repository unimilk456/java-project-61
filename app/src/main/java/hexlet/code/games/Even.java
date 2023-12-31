package hexlet.code.games;


import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;
import static hexlet.code.Engine.runGame;
import static hexlet.code.Utils.getRandomNumberBetween;

public class Even {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;

    private static final String TASK_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void generateQuestionsAndAnswersEven() {

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];
        for (int i = 0; i < questionsAndAnswers.length; i++) {

            questionsAndAnswers[i][0] = String.valueOf(getRandomNumberBetween(MIN_NUMBER, MAX_NUMBER));
            questionsAndAnswers[i][1] = getAnswer(questionsAndAnswers[i][0]) ? "yes" : "no";
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }

    private static boolean getAnswer(String question) {
        return Integer.parseInt(question) % 2 == 0;
    }
}

