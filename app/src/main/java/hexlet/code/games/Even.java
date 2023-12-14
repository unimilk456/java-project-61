package hexlet.code.games;


import static hexlet.code.Engine.COUNT_QUESTIONS;
import static hexlet.code.Engine.OPTIONS_SIZE;
import static hexlet.code.Engine.getRandomNumberBetween;
import static hexlet.code.Engine.runGame;

public class Even {

    private static final String TASK_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void generateQuestionsAndAnswersEven() {

        String[][] questionsAndAnswers = new String[COUNT_QUESTIONS][OPTIONS_SIZE];
        for (int i = 0; i < questionsAndAnswers.length; i++) {
            questionsAndAnswers[i][0] = getQuestion();
            questionsAndAnswers[i][1] = getAnswer(questionsAndAnswers[i][0]);
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }

    private static String getQuestion() {
        final int minNumber = 1;
        final int maxNumber = 100;
        return String.valueOf(getRandomNumberBetween(minNumber, maxNumber));
    }

    private static String getAnswer(String question) {
        return (Integer.parseInt(question) % 2 == 0) ? "yes" : "no";
    }
}

