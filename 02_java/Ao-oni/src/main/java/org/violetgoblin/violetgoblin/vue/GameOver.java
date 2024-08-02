package org.violetgoblin.violetgoblin.vue;

public class GameOver {
    public GameOver() {
    }

    public void gameOver(){
        String[] gameOverMessage = {
                "******************************************",
                "*                                        *",
                "*               GAME OVER                *",
                "*                                        *",
                "*           Developed by 방동호 (Bang Dongho)  *",
                "*                                        *",
                "*           GitHub: Bang1999             *",
                "*    Link: https://github.com/Bang1999   *",
                "*                                        *",
                "******************************************",
                "******************************************"
        };
        for (String line : gameOverMessage) {
            System.out.println(line);
        }
    }

}
