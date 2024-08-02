package com.Bang99.method;

import com.Bang99.Repository.MemberDTO;
import com.Bang99.Tool.Sysin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindPw {
    private String name;
    private String email;

    public FindPw() {
    }

    public FindPw(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void NameEmail(){
        Sysin in = new Sysin();
        System.out.print("name 입력: ");
        name = in.readLine();
        System.out.print("email 입력: ");
        email = in.readLine();

    }

    public String lookPw(File file, String file_path) {

        ObjectInputStream user = null;
        List<MemberDTO> members = new ArrayList<>();
        try {
            user = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file_path)));

            while (true) {
                members.add((MemberDTO) user.readObject());
            }
        } catch (EOFException e) {
            System.out.println("확인중입니다~");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (user != null) user.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for(MemberDTO m : members){
            if(m.getEmail().equals(email) && m.getName().equals(name)){
                return m.getPassword();
            }
        }

        return "해당 정보가 없습니다. 기억을 회상하세요.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FindPw{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
