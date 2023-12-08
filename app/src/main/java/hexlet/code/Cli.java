package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String userName;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String name) {
        userName = name;
    }

    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games! \n"
                + "May I have your name? ");

        String name = scanner.next().trim();
        setUserName(name);

        System.out.println("Hello, " + name + "!");
    }
}
