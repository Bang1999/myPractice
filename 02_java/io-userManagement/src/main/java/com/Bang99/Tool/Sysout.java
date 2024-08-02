package com.Bang99.Tool;

import java.io.*;

public class Sysout {

    private BufferedWriter bw;

    public Sysout() {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void prt(String str) {
        try {
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void prtln(String str) {
        try {
            bw.write(str + "\n");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            if (bw != null) bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
