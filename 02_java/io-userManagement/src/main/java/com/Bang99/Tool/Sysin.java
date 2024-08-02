package com.Bang99.Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Sysin {

    private BufferedReader br;

    public Sysin() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine(){
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public void close(){
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
