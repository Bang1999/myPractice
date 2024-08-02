package org.violetgoblin.violetgoblin.vue.opening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Opening {
    public void runGame() {
        System.out.println("=======================");
        System.out.println("  W  E  L  C  O  M  E  ");
        System.out.println("=======================");
        System.out.println("1. 게임 시작");
        System.out.println("2. 게임 설명 및 조작");
        System.out.println("9. 게임 종료");
        System.out.println("=======================");
    }

    public void opening() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("어느 마을에, 아무도 다가가지 않는 저택이 있었다.");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("그 저택에는 \"괴물\"이 나온다는 소문이 있었다.");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("어느 날, 마을 외곽에 있는 중학교에 다니는 소년들이 그 저택을 방문하게 되었다.");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("그들은 호기심에 그 저택 안으로 발을 들였다.");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("그리고... 그들은 괴물과 마주하게 된다.");
        System.out.print("Press Enter..");
        br.readLine();
        System.out.println("저택 안으로 들어가시겠습니까?");
        System.out.print("Press Enter..");
        br.readLine();
    }
}
