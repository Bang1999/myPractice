package com.Bang99.method;

import com.Bang99.Repository.MemberDTO;
import com.Bang99.Tool.Sysin;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Login {
    private String id;
    private String name;
    private String email;
    private String password;
    private int age;
    private char gender;

    public Login() {
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void IdPw(){
        Sysin in = new Sysin();
        System.out.print("email 입력: ");
        email = in.readLine();
        System.out.print("password 입력: ");
        password = in.readLine();

    }

    public boolean check(File file, String file_path) {

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
            if(m.getEmail().equals(email) && m.getPassword().equals(password)){
                return true;
            }
        }

        return false;
    }

    public void getStatus(File file, String file_path, MemberDTO myStatus) {

        ObjectInputStream user = null;
        List<MemberDTO> members = new LinkedList<>();
        try {
            user = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file_path)));
            int i=0;
            while (file.length() > i) {
                members.add((MemberDTO) user.readObject());
                i++;
            }
        } catch (EOFException e) {
            System.out.println("...");
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
            if(m.getEmail().equals(email) && m.getPassword().equals(password)){
                myStatus.setId(m.getId());
                myStatus.setName(m.getName());
                myStatus.setEmail(m.getEmail());
                myStatus.setPassword(m.getPassword());
                myStatus.setAge(m.getAge());
                myStatus.setGender(m.getGender());
                return;
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
