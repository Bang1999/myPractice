package org.violetgoblin.violetgoblin.vue.ending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ending {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    private static final String BOLD = "\u001B[1m";

    public Ending() {
    }

    public void end() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("우리는 겨우 저택을 탈출했다.");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("그러나, 그 아오오니의 존재를 잊을 수는 없을 것이다.");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("다시 그 저택에 돌아가는 일이 있을까?");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("우리의 공포는 끝나지 않는다.");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("To be continue...");
        System.out.print("Press Enter..");
        br.readLine();
        realEnding();
        System.exit(0);
    }

    private void realEnding() {
        String[] credits = {
                "******************************************",
                "*                                        *",
                "*   ██████████████████████████████     *",
                "*  ████████████████████████████████    *",
                "* ██████████████████████████████████   *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ████████████████████  ██████████████ *",
                "* ██████████████████████████████████   *",
                "*  ████████████████████████████████    *",
                "*   ██████████████████████████████     *",
                "*                                        *",
                "*         Developed by 방동호 (Bang Dongho)  *",
                "*                                        *",
                "*           GitHub: Bang1999             *",
                "*    Link: https://github.com/Bang1999   *",
                "*                                        *",
                "******************************************",
                "******************************************"
        };

        try {
            for (String line : credits) {
                printWithColorAndDelay(line, 10, getRandomColor());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000); // Pause before the final message
            printWithColorAndDelay("\nThank you for playing!", 150, GREEN);
            printWithColorAndDelay("Goodbye!", 150, PURPLE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printWithColorAndDelay(String text, int delay, String color) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(color + BOLD + c + RESET);
            Thread.sleep(delay);
        }
        System.out.println();
    }

    private static String getRandomColor() {
        int random = (int) (Math.random() * 7);
        switch (random) {
            case 0: return RED;
            case 1: return GREEN;
            case 2: return YELLOW;
            case 3: return BLUE;
            case 4: return PURPLE;
            case 5: return CYAN;
            case 6: return WHITE;
            default: return RESET;
        }
    }
}
