package hexlet.code.games;

import static hexlet.code.Engine.runGame;

public class Even {

    private static final String TASK_DESCRIPTION = "Answer 'yes' if number is even otherwise 'no'.";

    public static void runEvenGame() {

        String[][] questionsAndAnswers = new String [3][2];

        for (int i = 0; i < 3; i++) {
            questionsAndAnswers[i][0] = getQuestion();
            questionsAndAnswers[i][1] = getAnswer(questionsAndAnswers[i][0]);
        }
        runGame(TASK_DESCRIPTION, questionsAndAnswers);
    }

    private static String getQuestion() {
        return String.valueOf((int)(Math.floor(Math.random() * 100) + 1));
    }
    private static String getAnswer(String question) {
        return (Integer.parseInt(question) % 2 == 0)?"yes":"no";
    }
}

