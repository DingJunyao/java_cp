package org.hlworks.cp.main;

import java.io.*;

public class cp {
    public static void main(String args[]) {
        String ifpath;
        String ofpath;
        System.out.print("Input existing file path: ");
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try {
            ifpath = br.readLine();
        } catch (IOException e) {
            System.out.println("Error inputting existing file path");
            return;
        }
        System.out.print("Input new file path: ");
        try {
            ofpath = br.readLine();
        } catch (IOException e) {
            System.out.println("Error inputting existing file path");
            return;
        }
        try {
            File ifp = new File(ifpath);
            FileInputStream in = new FileInputStream(ifp);
            File ofp = new File(ofpath);
            FileOutputStream out = new FileOutputStream(ofp);
            BufferedInputStream bin = new BufferedInputStream(in, 2048);
            int len;
            byte bArrary[] = new byte[2048];
            while ((len = bin.read(bArrary)) != -1) {
                out.write(bArrary, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            System.out.println("Error");
            return;
        }
        System.out.println("Copy finished");
    }
}
