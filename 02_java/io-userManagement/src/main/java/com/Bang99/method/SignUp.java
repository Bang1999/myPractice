package com.Bang99.method;

import com.Bang99.Repository.MemberDTO;
import com.Bang99.Tool.MyOutput;
import com.Bang99.Tool.Sysin;

import java.io.*;

public class SignUp {
    private String id;
    private String name;
    private String email;
    private String password;
    private int age;
    private char gender;
    private MemberDTO member;

    public SignUp() {
    }

    public SignUp(String id, String name, String email, String password, int age, char gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.member = new MemberDTO(id, name, email, password, age, gender);
    }

    public MemberDTO setInfo(){
        Sysin in = new Sysin();
        System.out.print("id 입력: ");
        id = in.readLine();
        System.out.print("name 입력: ");
        name = in.readLine();
        System.out.print("email 입력: ");
        email = in.readLine();
        System.out.print("password 입력: ");
        password = in.readLine();
        System.out.print("age 입력: ");
        age = Integer.valueOf(in.readLine());
        System.out.print("gender 입력: ");
        gender = in.readLine().charAt(0);

        this.member = new MemberDTO(id, name, email, password, age, gender);
        return member;
    }

    public void insert(MemberDTO member, File file, String file_path) {
        ObjectOutputStream user = null;

        try {
            if (!file.exists()) {
                user = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(file_path)));
            } else {
                user = new MyOutput(
                        new BufferedOutputStream(
                                new FileOutputStream(file_path, true)));
            }
            user.writeObject(member);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                user.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "SignUp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", member=" + member +
                '}';
    }
}
