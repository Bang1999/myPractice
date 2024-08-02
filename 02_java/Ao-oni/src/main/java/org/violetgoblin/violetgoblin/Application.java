package org.violetgoblin.violetgoblin;

import org.violetgoblin.violetgoblin.player.service.PlayerService;
import org.violetgoblin.violetgoblin.vue.GameOver;
import org.violetgoblin.violetgoblin.vue.ending.Ending;
import org.violetgoblin.violetgoblin.vue.manipulate.Decription;
import org.violetgoblin.violetgoblin.vue.opening.Opening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class Application {

    static int cnt =0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Opening open = new Opening();   // 오프닝 메세지 출력

        /* 메뉴 값 입력 받기 */
        while (true) {
            open.runGame();
            int num = Integer.valueOf(br.readLine());
            switch (num) {
                case 1:
                    open.opening();
                    playGame();
                    break;
                case 2:
                    Decription desc = new Decription();
                    desc.desc();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }


    }

    /* 게임 시작하면  */
    private static void playGame() throws IOException {
        System.out.println("게임을 실행 합니다.");
        PlayerService ps = new PlayerService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine().toLowerCase();
            switch (input) {
                case "w":
                    if (ps.pressKeyW()) {
                        GameOver go = new GameOver();
                        go.gameOver();
                        return;
                    }
                    break;
                case "s":
                    if (ps.pressKeyS()) {
                        GameOver go = new GameOver();
                        go.gameOver();
                        return;
                    }
                    cnt++;
                    break;
                case "a":
                    if (ps.pressKeyA()) {
                        GameOver go = new GameOver();
                        go.gameOver();
                        return;
                    }
                    cnt++;
                    break;
                case "d":
                    if (ps.pressKeyD()) {
                        GameOver go = new GameOver();
                        go.gameOver();
                        return;
                    }
                    cnt++;
                    break;
                case "0":
                    System.out.println("메뉴로 돌아갑니다.");
                    return;
            }
            if(cnt == 50){
                Ending end = new Ending();
                end.end();
            }

        }

    }
}
