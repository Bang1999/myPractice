package org.violetgoblin.violetgoblin.vue.manipulate;

public class Decription {
    public Decription() {
    }

    public void desc(){
        System.out.println("=======================");
        System.out.println("======= 게임 설명 =======");
        System.out.println("=======================");
        System.out.println("- 게임 승리 조건 -> 생존! (50번 움직일 동안 살아남자!)\n" +
                "- 플레이어는 w, a, s, d 키로 움직인다.\n" +
                "- 문을 통해 여러 방을 이동할 수 있다.\n" +
                "- 아오오니 주변(상,하,좌,우) 한 칸 이내에 있으면 죽는다.\n" +
                "- 아오오니는 사용자가 있는 방 안에 랜덤으로 생성된다.\n" +
                "- 플레이어가 한칸 움직이면 아오오니도 한칸 랜덤으로 움직인다.");
    }
}
