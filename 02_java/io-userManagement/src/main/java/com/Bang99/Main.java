package com.Bang99;

import com.Bang99.Tool.Sysin;
import com.Bang99.Tool.Sysout;
import com.Bang99.Repository.MemberDTO;
import com.Bang99.method.FindPw;
import com.Bang99.method.Login;
import com.Bang99.method.SignUp;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Sysout out = new Sysout();      // println 객체 생성
        Sysin in = new Sysin();         // inputstream 객체 생성
        out.prtln("========================");
        out.prtln("=========Hello!=========");
        out.prtln("========================");
        out.prtln("");


        String file_path = "src/main/java/com/Bang99/Repository/usersInfo.txt";
        File file = new File(file_path);
        boolean flag = false;               // 로그인 상태 확인
        MemberDTO myStatus = new MemberDTO();          // 내 정보 저장

        char c = 'a';
        while (true) {
            out.prtln("------------------");
            out.prtln("로그인을 진행해주세요.:)");
            out.prtln("1. 회원가입");
            out.prtln("2. 로그인");
            out.prtln("3. 비밀번호 찾기");
            out.prtln("4. 내 정보 보기");
            out.prtln("5. 프로그램 종료");
            out.prtln("------------------");
            out.prt("어떤 절차부터 진행하시겠습니까?");

            String str = in.readLine();
            if (str.length() == 1) {
                c = str.charAt(0);
            } else {
                out.prtln("다시 입력하시죠...");
                continue;
            }

            switch (c) {
                case '1':
                    out.prtln("회원가입을 진행하겠습니다.");
                    SignUp su = new SignUp();
                    MemberDTO member = su.setInfo();    // 정보 입력
                    su.insert(member, file, file_path);    // txt파일에 insert
                    break;
                case '2':
                    out.prtln("로그인을 진행하겠습니다.");
                    Login login = new Login();
                    login.IdPw();           // ID, PW 입력
                    if(login.check(file, file_path)){       // ID, PW 체크
                        System.out.println("로그인 성공~!^^");
                        login.getStatus(file, file_path, myStatus);
                        flag = true;
                    }else{
                        System.out.println("로그인 실패!ㅠ");
                    }
                    break;
                case '3':
                    out.prtln("비밀번호를 잊어버리셨군요. 같이 찾으러 가보시죠~");
                    FindPw fp = new FindPw();
                    fp.NameEmail();     // pw 찾기위한 name, email 입력
                    System.out.println("pw: " + fp.lookPw(file, file_path));
                    break;
                case '4':
                    if(flag){
                        System.out.println("id: " + myStatus.getId());
                        System.out.println("name: " + myStatus.getName());
                        System.out.println("email: " + myStatus.getEmail());
                        System.out.println("password: " + myStatus.getPassword());
                        System.out.println("age: " + myStatus.getAge());
                        System.out.println("gender: " + myStatus.getGender());
                    }else{
                        System.out.println("로그인 먼저 진행해 주세요.");
                    }
                    break;
                case '5':
                    System.exit(0);
                    break;
                default:
                    out.prtln("다시 입력하시죠...");
            }

            if (c == '5') break;
        }

        /* =============================================================================== */


        in.close();
        out.close();
    }
}
